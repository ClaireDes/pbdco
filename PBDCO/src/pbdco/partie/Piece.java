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
abstract public class Piece {
    public String nomPiece;
    public Boolean couleur;
    public int xPos;
    public int yPos;
    
    public String getNom(){
        return this.nomPiece;
    }
    
    public int getPositionX(){
        return (this.xPos);
    }
    
    public int getPositionY(){
        return(this.yPos);
    }
    
    public String getCouleur(){
        if(!this.couleur){
            return "noir";
        }
        else{
            return "blanc";
        }
    }
    
    @Override
    public String toString(){
        return ("C'est un(e) "+this.getNom()+" de couleur "+this.getCouleur()+" situé(e) à la position : "+this.getPositionX()+";"+this.getPositionY());
    }
    
    public void setPosition(int x, int y){
        this.xPos=x;
        this.yPos=y;
    }
    
    public void setNom(String nom){
        this.nomPiece=nom;
    }
    
    public void setCouleur(Boolean couleur){
        this.couleur=couleur;
    }
   
}
