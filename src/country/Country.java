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
public class Country {
    private String code;
    private String name;
    
    public void setCode(String code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
}
