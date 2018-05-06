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
public class Fou extends Piece{
    private String nomPiece = "fou";
    
    public Fou(Position position, int c){
        this.nomPiece="fou";
        this.updatePosition(position);
        this.setCouleur(c);
    }

    
}
