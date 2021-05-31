/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Administrator
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //get cities and countries from csv files and stores them in lists
        List<City> cities = new ArrayList<City>();
        List<Country> countries = new ArrayList<Country>();
        FileDAO Dao = new FileDAO();
        cities = Dao.readCityfromCSV("city1.csv");
        countries = Dao.readCountryfromCSV("country.csv");
        
        //print list of cities and countries
        System.out.println("\n#################### Cities ###################");
        for(City c:cities){
            System.out.println(" "+c.getName());
        }
        System.out.println("\n#################### Countries ###################");
        for(Country count:countries){
            System.out.println(" "+count.getName());
        }
        
        //map that uses the country code as keys and a list of cities as the value for each country. 
        List<City> citiesInSameCountry = new LinkedList<City>();
        List<City> y = new LinkedList<City>();
        List<City> maxPopulationCities = new LinkedList<City>();
        Map<String,List<City>> map = new HashMap<>();
        
        System.out.println("\n#################### Map of cities in each country ###################");
        for(Country country:countries){
            for(City city:cities){
                //System.out.println(city.getName());
                if(country.getCode().equals(city.getCode()))
                    citiesInSameCountry.add(city);       
            }
            map.put(country.getCode(), citiesInSameCountry);

            //citiesInSameCountry.clear();              //using incorrect because this clear the location in memory "citiesInSameCountry" that map also refer to.
            citiesInSameCountry = new LinkedList<City>();   //"citiesInSameCountry" refer to a new location in memory not same as location"citiesInSameCountry" that map refer to.
            
            y = map.get(country.getCode()); //get a list of cities in each country
            for(City m:y)
                System.out.println("countryCode: "+country.getCode()
                                  +", cityName: "  +m.getName()
                                  +", continent: " +m.getContinent()
                                  +", Surface Area: "+m.getSurfaceArea()
                                  +", population: "  +m.getPopulation()
                                  );

            //get max population city in each country and add them to a linked list
            maxPopulationCities.add(Collections.max(y, (City c1,City c2)->Integer.compare(c1.getPopulation(), c2.getPopulation())));
            
        }
        
        System.out.println("\n##################### Highest population city of each country ########################");
        int i=0;    
        for(Country country:countries){
            System.out.println("max population city in "+country.getName()+" is "+maxPopulationCities.get(i).getName());
            i++;
        }
      
        System.out.println("\n#################### Map of cities in each continent ###################");

        Map<String,City> mapContinent_maxPopCity = new HashMap<>();
        City maxPopulationCity = new City();
        
        Map<String,List<City>> groupByContinent=cities.stream().collect(Collectors.groupingBy(City::getContinent)); //map cities in same continent
        groupByContinent.forEach((k,v)->{
                                        System.out.print("\nCities in "+k+" are: \n");                             //print groupByContinent map
                                        groupByContinent.get(k).forEach((c)->System.out.println(c.getName()));
                                        }
                                );
        System.out.println("\n##################### Highest population city by continent ########################");
        groupByContinent.forEach((k,v)->{
                                         groupByContinent.get(k).stream().max(Comparator.comparingInt(City::getPopulation)).map((c)->{System.out.println("Highest population city in "+k+" is "+c.getName());return 1;});
                                        }
                                );
        
       // maxPopulationCity = groupByContinent.forEach((k,v)->groupByContinent.get(y)).max(Comparator.comparingInt(City::getPopulation)).get(); //get max population city in each continent

        /*
        List<String> continents = new LinkedList<String>();
        List<City> citiesInSameContinent = new LinkedList<City>();
        Map<String,List<City>> mapContinent = new HashMap<>();
        continents = cities.stream().map(City::getContinent).distinct().collect(toList());  //get distinct continents
        
        for (String s:continents){
        System.out.print("Cities in "+s+" are: ");
            for (City c:groupByContinent.get(s)){
                System.out.print(c.getName()+" , ");
            }
            System.out.println("\n");
        }
        
        for (String s:continents){
            
            for(City c:cities){
                if(s.equals(c.getContinent()) ){
                    citiesInSameContinent.add(c);
                }
            }
            mapContinent.put(s,citiesInSameContinent );     //map  a list of cities for each continent 
            maxPopulationCity = mapContinent.get(s).stream().max(Comparator.comparingInt(City::getPopulation)).get(); //get max population city in each continent
            mapContinent_maxPopCity.put(s,maxPopulationCity);   //get all max population cities in all continents
            citiesInSameContinent = new LinkedList<City>(); //used as a temp list
            maxPopulationCity = new City();      //used as a temp list
            
            //print Map of cities in each continent
            System.out.print("Cities in "+s+" are: ");
            for (City c:mapContinent.get(s)){
                System.out.print(c.getName()+" , ");
            }
            System.out.println("\n");
            
        }
                

       
        System.out.println("\n##################### Highest population city by continent ########################");
        //print max population city for each continent
        mapContinent_maxPopCity.forEach((k,v)->System.out.println("in "+k+" maxPopulationCity is "+v.getName()));
        */
        System.out.println("\n##################### Highest population capital ###############################");
        City maxCapitalPopCity = new City();
        maxCapitalPopCity = cities.stream().filter(c->c.getIsCapital()).max((City c1,City c2)->Integer.compare(c1.getPopulation(),c2.getPopulation())).get();
        System.out.println("Highest population capital is "+maxCapitalPopCity.getName());

        System.out.println("\n##################### Sorted cities according to input country code ########################");
        //Ask user to enter country code
        citiesInSameCountry = new LinkedList<City>();
        System.out.println("Enter Country code[from 1 to 3]: ");
        Scanner sc = new Scanner(System.in);
        String searchKey = sc.next().trim();
        citiesInSameCountry = map.get(searchKey);
        
        //citiesInSameCountry.stream().sorted(Comparator.comparingInt(City::getPopulation)).collect(toList());
        //citiesInSameCountry.sort(Integer::compare( c1.getPopulation(), c2.getPopulation()));

        
         //1. using object of class "populationSorter" that implements "Comparator" interface
        //citiesInSameCountry.sort(new populationSorter());
        
        
        //2. using anonemous class implements "Comparator" interface
        citiesInSameCountry.sort(new Comparator<City>() {
        @Override
        public int compare(City c1, City c2) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //return c2.getSurfaceArea().compareTo(c1.getSurfaceArea());
            return Integer.compare(c1.getPopulation(), c2.getPopulation());
        }});
        
        
        
       //3. using reference method
       //citiesInSameCountry.sort(Integer::compare);
        
        for(City m:citiesInSameCountry)
            System.out.println("countryCode: "+searchKey
                              +", cityName: "  +m.getName()
                              +", continent: " +m.getContinent()
                              +", Surface Area: "+m.getSurfaceArea()
                              +", population: "  +m.getPopulation()
                              );
        
        
    }
    
}
