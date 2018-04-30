/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco;

/**
 *
 * @author milcenan
 */
public class Code {
    private int value; // Utiliser name pour les codes sous forme d'entier
    private String name; //Utiliser name pour les codes sous forme de Strings 
    
    public Code(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }
    public void setName(String i){
        this.name=name;
    }
    
    
    public Code(int i){
        this.value = i;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int i){
        this.value=i;
    }
    
    
}
