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
    
    public String getNom(){
        return this.nomPiece;
    }
    
    public Position getPosition(){
        return this.positionPiece;
    }
    
    @Override
    public String toString(){
        return ("C'est un(e) "+this.getNom()+" situé(e) à la position : "+this.getPosition().x+";"+this.getPosition().y);
    }
    
    public void setPosition(Position position){
        this.positionPiece=position;
    }
    
    public void setNom(String nom){
        this.nomPiece=nom;
    }
   
}
