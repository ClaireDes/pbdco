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
    public Tour(){
        this.nomPiece="tour";
        Position p = new Position(3,5);
        this.positionPiece=p;
    }
}
