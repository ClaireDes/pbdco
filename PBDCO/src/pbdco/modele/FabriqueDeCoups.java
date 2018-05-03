/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import pbdco.*;
import pbdco.partie.*;
import java.sql.*;
import javax.sql.*;


/**
 *
 * @author milcenan
 */
public class FabriqueDeCoups/* extends FabriqueTransaction*/{
  
   
    public  void fabriqueRequete(String operation, Coup coup){
        
        throw new UnsupportedOperationException("Not supported yet.");
    };    


    public void fabriqueTransaction(String operation, Coup coup) {
         switch (operation) {
            case "new"://création d'un coup 
                    System.out.println("enregistrement d'un nouveau joueur dans la base");
                break;
                
         
         }
         
    }
    
}

