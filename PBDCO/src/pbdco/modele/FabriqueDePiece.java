/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import pbdco.partie.*;
import pbdco.*;

/**
 *
 * @author milcenan
 */
public class FabriqueDePiece {
    
     public  void fabriqueTransaction(String operation,Piece piece){
        switch (operation) {
           
            case "move" : //déplacement d'une pièce dans la base de données à l'occasiond'un coup 
                    System.out.println("enregistrement d'une pièce \""+ piece.getNom() +"\" dans la base");
                break;
        }
     }
     
     public void nouvellePiece(Piece piece, Code codeTour, Code codeRencontre){//création d'une pièce correspondant à la pièce passée en parametre
         
        System.out.println("enregistrement d'une pièce \""+ piece.getNom() +"\" dans la base");
     }
    
      public void bougePiece(Piece piece,Coup coup, Code codeTour, Code codeRencontre){//création d'une pièce correspondant à la pièce passée en parametre
         
        System.out.println("enregistrement du déplacement de la pièce \""+ piece.getNom() +"\"  à partir de " + coup.getPreviousY(piece) +"," +coup.getPreviousX(piece));
     }
     
}
