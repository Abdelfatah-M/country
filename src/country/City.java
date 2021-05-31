/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

/**
 *
 * @author Administrator
 */
public class City {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private boolean isCapital;
    
    public void setCode(String code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setContinent(String continent){
        this.continent = continent;
    }
    public void setSurfaceArea(double surfaceArea){
        this.surfaceArea = surfaceArea;
    }
    public void setPopulation(int population){
        this.population = population;
    }
    public void setIsCapital(boolean isCapital){
        this.isCapital = isCapital;
    }
    
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public String getContinent(){
        return this.continent;
    }
    public double getSurfaceArea(){
        return this.surfaceArea;
    }
    public int getPopulation(){
        return this.population;
    }
    public boolean getIsCapital(){
        return this.isCapital;
    }
    
}
