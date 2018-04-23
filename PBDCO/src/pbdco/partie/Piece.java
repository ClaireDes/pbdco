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
    private String nomPiece;
    private Boolean couleur;
    
    private Position currentPosition = new Position(1,1,true);
    
    public String getNom(){
        return this.nomPiece;
    }
    
    public Position getCurrentPosition(){
        return this.currentPosition;
    }
    
    public String getCouleur(){
        if(!this.couleur){
            return "noir";
        }
        else{
            return "blanc";
        }
    }
    
    public Boolean getColorBool(){
        return this.couleur;
    }
    
    @Override
    public String toString(){
        return ("C'est un(e) "+this.getNom()+" de couleur "+this.getCouleur()+" situé(e) à la position : "+this.getCurrentPosition().getX()+";"+this.getCurrentPosition().getY());
    }
    
    public void updatePosition(Position position){
        this.getCurrentPosition().setPosition(position.getX(), position.getY());
    }
    
    public void setNom(String nom){
        this.nomPiece=nom;
    }
    
    public void setCouleur(Boolean couleur){
        this.couleur=couleur;
    }

    public abstract Boolean verifySituation();
   
}
