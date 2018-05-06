/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author barbault
 */
public class TablePositions {
    private Position[] echiquier;
    
    public void init(){
        // creation de la table des positions
        for (int lig=0; lig<8;lig++){
            for (int col=0;col<8;col++){
                if(lig < 2 || lig >5){ //cases occupées initialement
                    this.echiquier[lig+col].setPosition(lig+1, col+1);
                    this.echiquier[lig+col].setState(true);
                }
                else { //cases libres
                    this.echiquier[lig+col].setPosition(lig+1, col+1);
                    this.echiquier[lig+col].setState(true);
                }
            }
        }      
    }
}
