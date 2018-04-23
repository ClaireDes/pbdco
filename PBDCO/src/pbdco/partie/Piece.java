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
    public Position positionPiece;
    public Boolean couleur;
    
    public String getNom(){
        return this.nomPiece;
    }
    
    public Position getPosition(){
        return this.positionPiece;
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
        return ("C'est un(e) "+this.getNom()+" de couleur "+this.getCouleur()+" situé(e) à la position : "+this.getPosition().x+";"+this.getPosition().y);
    }
    
    public void setPosition(int x, int y){
        this.positionPiece.x=x;
        this.positionPiece.y=y;
    }
    
    public void setNom(String nom){
        this.nomPiece=nom;
    }
    
    public void setCouleur(Boolean couleur){
        this.couleur=couleur;
    }
   
}
