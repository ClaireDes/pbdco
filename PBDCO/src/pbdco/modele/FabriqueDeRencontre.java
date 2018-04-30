/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milcenan
 */
public class FabriqueDeRencontre extends FabriqueTransaction{
    
  

    public  void fabriqueRequete(){
        throw new UnsupportedOperationException("Not supported yet.");
    };    

    @Override
    public void fabriqueTransaction(String operation, Modele param) {
    
        try {
            // Chargement driver
            System.out.print("Loading Oracle driver... "); 
            //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("loaded");

            
            // Connexion à la BDD
            System.out.println("Connexion à la base de données...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("connecté.");
            
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
            
            PreparedStatement pstmt = conn.prepareStatement("");
                    switch (operation) {
                        case "new":// création d'une nouvelle rencontre
                            
                            break;
                        case "fini":// enregistrement du résultat d'une rencontre
                            
                            break;
                        case "load":// chargement d'une rencontre avec la base de données
                            
                            break;
                        case "lastCodeRencontre":// le dernier code rencontre utilisé (pour en generer un nouveau)
                            
                            break;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(FabriqueDeRencontre.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
   
}
