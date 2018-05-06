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
public class Dame extends Piece{
    private String nomPiece = "dame";
    
    public Dame(Position position, int c){
        this.nomPiece="dame";
        this.updatePosition(position);
        this.setCouleur(c);
    }

    
}
