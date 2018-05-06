/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

import pbdco.Code;

/**
 *
 * @author belinbr
 */
public class Piece {
    private String nomPiece;
    private int couleur; //1 pour blanc et 2 pour noir
    private Code codePiece;

    private Position currentPosition = new Position(1,1,couleur);
    private Position previousPosition = new Position(1,1,0);

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
        if(this.couleur!=2){
            return "noir";
        }
        else if(this.couleur==1){
            return "blanc";
        }
        else{
            return "erreur de couleur : 1 ou 2";
        }
    }

    public Code getCode(){
      return this.codePiece;
    }

    public void setCode(Code codePiece){
      this.codePiece = codePiece;
    }

    public int getIntCurrentPosition(){
        return ((this.getCurrentPosition().getX()+(this.getCurrentPosition().getY()-1)*8));
    }

    public int getIntPreviousPosition(){
        return ((this.getPreviousPosition().getX()+(this.getPreviousPosition().getY()-1)*8));
    }

    public int getColorBool(){
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
        this.getPreviousPosition().setState(0);
        //on met à jour la nouvelle position
        this.getCurrentPosition().setPosition(position.getX(), position.getY());
        //on indique que la case est occupée
        if(this.getColorBool() == 1){
            this.getCurrentPosition().setState(1);
        }
        else{
            this.getCurrentPosition().setState(2);
        }
    }

    public void setNom(String nom){
        this.nomPiece=nom;
    }

    public void setCouleur(int couleur){
        this.couleur=couleur;
    }

    public Piece(){
        this.setNom("");
        this.setCouleur(2);
    }

}
