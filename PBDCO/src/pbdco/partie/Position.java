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
    private int state; //0 pour case vide, 1 pour case avec pièce blanche, 2 pour noir
    private Boolean echec = false;
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
 
    public int getState(){
        return this.state;
    }
    
    public Boolean getEchec(){
        return this.echec;
    }
    
    public Boolean getColor(){
        // A FAIRE
        // requete pour avoir couleur a partir de position
        return true; //à enlever ensuite une fois que c'est complété au dessus
    }
    
    public Piece getPiece(){
        // A FAIRE 
        // requete pour avoir piece a une position
        Tour tour = new Tour(new Position(1,1, 1),true);//à enlever ensuite une fois que c'est complété au dessus
        return tour;//à enlever ensuite une fois que c'est complété au dessus
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
    
    public void setState(int state){
        this.state = state;
    }
    
    public void setEchec(Boolean echec){
        this.echec = echec;
    }
    
    public Position(int x, int y, int state){
        this.x = x;
        this.y = y;
        this.state = state;
    }
    
    public Position() {
        x = 0;
        y = 0;
    }
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
