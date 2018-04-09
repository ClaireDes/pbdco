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
public abstract class Piece {
    String nomPiece;
    Position positionPiece;
    
    String getNom(){
        return this.nomPiece;
    }
    
    Position getPosition(){
        return this.positionPiece;
    }
    
    void setPosition(Position position){
        this.positionPiece=position;
    }
}
