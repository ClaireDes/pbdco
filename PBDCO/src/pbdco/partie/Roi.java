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
public class Roi extends Piece{
    private String nomPiece = "roi";
    private Boolean echec = false;
    
    public Roi(Position position, Boolean c){
        this.nomPiece="roi";
        this.updatePosition(position);
        this.setCouleur(c);
    }

    public Boolean getEchec(){
        return this.echec;
    }
}
