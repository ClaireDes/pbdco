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
public class Tour extends Piece{
    private String nomPiece = "tour";
    
    public Tour(Position position, int c){
        this.nomPiece="tour";
        this.updatePosition(position);
        this.setCouleur(c);
    }
}