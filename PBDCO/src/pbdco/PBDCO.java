/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pbdco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.modele.FabriqueDeJoueur;
import pbdco.modele.Joueur;
import pbdco.*;

/**
 *
 * @author milcenan
 */
public class PBDCO {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //test création joueur + déclaration dans la BD
        
                 try{// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }catch( SQLException ex){
                     System.err.println("proleme diver"); 
        }
         System.out.println("Driver ok");
         
        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        try {
            Joueur J = fabJoueur.LoadFromBD(new Code(1));
            
            
            //test création controleur
            
            
            
            
            //test communication vue / controlleur
            
            
            
            
            
            //test communication vue / modèle
        } catch (BDAccessEx ex) {
            Logger.getLogger(PBDCO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
}
    
}
