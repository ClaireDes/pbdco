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
    private Position previousPosition = new Position(1,1,false);
    
    public String getNom(){
        return this.nomPiece;
    }
    
    public Position getCurrentPosition(){
        return this.currentPosition;
    }
    
    public Position getPreviousPosition(){
        return this.previousPosition;
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
        //on met à jour l'ancienne position
        this.getPreviousPosition().setPosition(this.getCurrentPosition().getX(), this.getCurrentPosition().getY());
        //on indique que la case n'est plus occupée
        this.getPreviousPosition().setState(false);
        //on met à jour la nouvelle position
        this.getCurrentPosition().setPosition(position.getX(), position.getY());
        //on indique que la case est occupée
        this.getCurrentPosition().setState(true);
    }
    
    public void setNom(String nom){
        this.nomPiece=nom;
    }
    
    public void setCouleur(Boolean couleur){
        this.couleur=couleur;
    }

   
}
