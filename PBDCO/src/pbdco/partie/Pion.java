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
public class Pion extends Piece{
    private String nomPiece = "pion";

    public Pion(Position position, Boolean c) {
        super();
        this.setNom("pion");
        this.updatePosition(position);
        this.setCouleur(c);
    }
    
    
}
