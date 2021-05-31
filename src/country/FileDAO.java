/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class FileDAO {
    public List<City> readCityfromCSV(String filename){
        String line=null;
        String[] features=null;
        List<City> cities = new ArrayList<City>();
        File f = new File(filename);
        Scanner sc = null;
        try {
            
            sc = new Scanner(f);
            line = sc.nextLine();
            while(sc.hasNextLine()){
                City city = new City();
                line = sc.nextLine();
                features = line.split(",");
                city.setCode(features[0]);
                city.setName(features[1]);
                city.setContinent(features[2]);
                city.setSurfaceArea(Double.parseDouble(features[3].trim()));
                city.setPopulation(Integer.parseInt(features[4].trim()));
                city.setIsCapital(Integer.parseInt(features[5].trim())==1?true:false);  //convert 1 to true, 0 to false
                cities.add(city);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            sc.close();
        }  //closes the scanner  }
        return cities;
    }
    public List<Country> readCountryfromCSV(String filename){
        
        
            String line=null;
            String[] features=null;
            List<Country> countries = new ArrayList<Country>();
            Scanner sc = null;
            try {
            File f = new File(filename);
            sc = new Scanner(f);
            line = sc.nextLine();
            while(sc.hasNextLine()){
                line = sc.nextLine();
                features = line.split(",");
                Country c = new Country();
                c.setCode(features[0]);
                c.setName(features[1]);
                countries.add(c);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            sc.close();
        }  //closes the scanner  }
        return countries;
    }
}
