/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.BDAccessEx;
import pbdco.Code;

/**
 *
 * @author milcenan
 */
public class PreparationTour extends Organisation{
    
    
    public PreparationTour() throws BDAccessEx{
        super();
    }
    
    public void creeRencontre(){
        switch(this.getTour()){
            case "qualif": 
                
        }
    }
}
