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
    public final int x,y;
    
    /*vérifie que les coordonnées des positions sont comprises entre 1 et 8*/
    public int verifyPosition(Position position){
        if ((((1 <= position.x) && (position.x <= 8)) && (1 <= position.y)) && (position.y <= 8)){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
