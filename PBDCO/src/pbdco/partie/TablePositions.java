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
    private Position[] echiquier = new Position[64];

    public TablePositions() {
        if (echiquier == null){
            System.out.println("Essaie"+echiquier.toString());
        }
        else System.out.println("Pas nul"+echiquier[0]);
        for (int lig=0; lig<8;lig++){
            for (int col=0;col<8;col++){
                echiquier[lig+col] = new Position();
                if(lig < 2){ //cases occupées initialement
                    echiquier[lig+col].setPosition(lig+1, col+1);
                    this.echiquier[lig+col].setState(1);
                }
                else if (lig > 5) {
                    this.echiquier[lig+col].setPosition(lig+1, col+1);
                    this.echiquier[lig+col].setState(2);
                }
                else { //cases libres
                    this.echiquier[lig+col].setPosition(lig+1, col+1);
                    this.echiquier[lig+col].setState(0);
                }
            }
        }
    }
    
    public Position getPosition(int number){
        return echiquier[number];
    }
    
    public void init(){
        // creation de la table des positions
        for (int lig=0; lig<8;lig++){
            for (int col=0;col<8;col++){
                if(lig < 2){ //cases occupées initialement par les blancs
                    this.echiquier[8*lig+col].setPosition(lig+1, col+1);
                    this.echiquier[8*lig+col].setState(1);
                }
                if (lig>5) {
                    this.echiquier[8*lig+col].setPosition(lig+1, col+1);
                    this.echiquier[8*lig+col].setState(1);
                }
                else { //cases libres
                    this.echiquier[8*lig+col].setPosition(lig+1, col+1);
                    this.echiquier[8*lig+col].setState(2);
                }
            }
        }      
    }

    public int caseOccupee(int numeroCase) {
        System.out.println("numeroCase = "+ numeroCase+echiquier.toString()+echiquier[0].toString());
        
        return echiquier[numeroCase].getState();
    }

    private Position Position(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
