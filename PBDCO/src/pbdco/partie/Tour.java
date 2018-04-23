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
public class Tour extends Piece {
    public Tour(int x, int y, Boolean c){
        this.nomPiece="tour";
        this.setPosition(x,y);
        this.setCouleur(c);
    }
}
