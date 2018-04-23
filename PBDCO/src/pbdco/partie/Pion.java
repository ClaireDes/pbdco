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
    public String nomPiece;

    public Pion(int x, int y, Boolean c) {
        super();
        this.setNom("pion");
        this.setPosition(x,y);
        this.setCouleur(c);
    }
}
