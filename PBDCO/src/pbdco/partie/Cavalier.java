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
public class Cavalier extends Piece{
    private String nomPiece = "cavalier";
    
    public Cavalier(Position position, Boolean c){
        this.nomPiece="cavalier";
        this.updatePosition(position);
        this.setCouleur(c);
    }

    @Override
    public Boolean verifySituation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
