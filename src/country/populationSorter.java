/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.util.Comparator;

/**
 *
 * @author Administrator
 */
public class populationSorter implements Comparator<City> {

    @Override
    public int compare(City c1, City c2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return c2.getSurfaceArea().compareTo(c1.getSurfaceArea());
        return Integer.compare(c1.getPopulation(), c2.getPopulation());
    }
    
}
