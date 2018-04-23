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
public class Coup {
    
    public int getPreviousX(Piece piece){
        return piece.getCurrentPosition().getX();
    }
    
    public int getPreviousY(Piece piece){
        return piece.getCurrentPosition().getY();
    }
    
    public void updatePositionPiece(Piece piece, Position newPosition){
        piece.updatePosition(new Position(newPosition.getX(), newPosition.getY(),true));
    }
    
    public void verifyCoup(Piece piece, Position newPosition){
        
        int deltaX = newPosition.getX()-piece.getCurrentPosition().getX();
        int deltaY = newPosition.getY()-piece.getCurrentPosition().getY();
        int i =0;
        
        switch (piece.getNom()) {
            case "pion":
                if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                break;
            case "roi":
                if(piece.verifySituation()){//on vérifie que le roi ne se met pas en échec
                    if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                    }
                    updatePositionPiece(piece, newPosition); //la pièce est déplacée
                }
                else{
                    throw new UnsupportedOperationException("Le roi ne peut se mettre en échec");
                }
                break;
            case "dame":
                if(deltaX==0){//déplacement vertical
                    if(deltaY>0){//si la dame est en dessous de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            Position p = new Position(1,1,false);
                            p.setPosition(piece.getCurrentPosition().getX(), piece.getCurrentPosition().getY()+i);
                            if(p.getState()){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaY<0){//si la dame est au dessus de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            Position p = new Position(1,1,false);
                            p.setPosition(piece.getCurrentPosition().getX(), piece.getCurrentPosition().getY()-i);
                            if(p.getState()){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaY==0){//déplacement horizontal
                    if(deltaX>0){//si la dame est à gauche de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY());
                            if(p.getState()){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaX<0){//si la dame est à droite de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY());
                            if(p.getState()){
                                throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaX<0 && deltaY<0){//déplacement diagonale basse gauche
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY()-i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX<0 && deltaY>0){//déplacement diagonale haute gauche
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY()+i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY<0){//déplacement diagonale basse droite
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY()-i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY>0){//déplacement diagonale haute droite
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY()+i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("La dame ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                break;
            case "tour":
                if(deltaX==0){//déplacement vertical
                    if(deltaY>0){//si la tour est en dessous de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            Position p = new Position(1,1,false);
                            p.setPosition(piece.getCurrentPosition().getX(), piece.getCurrentPosition().getY()+i);
                            if(p.getState()){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaY<0){//si la tour est au dessus de la case sélectionnée
                        while(i<deltaY){
                            i = i+1;
                            Position p = new Position(1,1,false);
                            p.setPosition(piece.getCurrentPosition().getX(), piece.getCurrentPosition().getY()-i);
                            if(p.getState()){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                else if(deltaY==0){//déplacement horizontal
                    if(deltaX>0){//si la tour est à gauche de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY());
                            if(p.getState()){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                    else if(deltaX<0){//si la tour est à droite de la case sélectionnée
                        while(i<deltaX){
                            i = i+1;
                            Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY());
                            if(p.getState()){
                                throw new UnsupportedOperationException("La tour ne peut aller aussi loin, un obstacle lui bloque la route");
                            }
                        }
                    }
                }
                if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                break;
            case "fou":
                if(deltaX<0 && deltaY<0){//déplacement diagonale basse gauche
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY()-i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX<0 && deltaY>0){//déplacement diagonale haute gauche
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()-i, piece.getCurrentPosition().getY()+i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY<0){//déplacement diagonale basse droite
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY()-i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                else if(deltaX>0 && deltaY>0){//déplacement diagonale haute droite
                    while(i<deltaX){
                        i = i+1;
                        Position p = new Position(piece.getCurrentPosition().getX()+i, piece.getCurrentPosition().getY()+i);
                        if(p.getState()){
                            throw new UnsupportedOperationException("Le fou ne peut aller aussi loin, un obstacle lui bloque la route");
                        }
                    }
                }
                if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                break;
            case "cavalier":
                if(newPosition.getState()){//si la case est occupée
                        // On enlève la pièce qui était à cette position --> manger(newPosition);
                }
                updatePositionPiece(piece, newPosition); //la pièce est déplacée
                break;
            default:
                throw new UnsupportedOperationException("Pièce inexistante : mauvais nom");
        }
    }
}
