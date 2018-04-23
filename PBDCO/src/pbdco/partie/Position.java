/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author belinbr
 */
public class Position {
    private int x=1;
    private int y=1;
    private Boolean state; //true pour case occupée, false sinon
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
 
    public Boolean getState(){
        return this.state;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setPositionX(int x){
        this.x = x;
    }
    
    public void setPositionY(int y){
        this.y = y;
    }
    
    public void setState(Boolean state){
        this.state = state;
    }
    
    public Position(int x, int y, Boolean state){
        this.x = x;
        this.y = y;
        this.state = state;
    }
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
