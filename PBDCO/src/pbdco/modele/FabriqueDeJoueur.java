/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pbdco.modele.FabriqueTransaction.URL;
import sun.awt.X11.XConstants;

/**
 *
 * @author milcenan
 */
public class FabriqueDeJoueur extends FabriqueTransaction{

    @Override
    public  void fabriqueTransaction(String operation,Modele joueur){
        
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
            
            PreparedStatement pstmt = conn.prepareStatement("insert into Joueurs(codeJoueur, Prenom, Nom, Adresse) VALUES(?,?,?,?)");
            pstmt.setInt(1, joueur.codeJoueur.getValue());
            pstmt.setString(2, joueur.prenom);
            pstmt.setString(3, joueur.nom);
            pstmt.setString(4, joueur.adresse);
                    
                    
                    switch (operation) {
                        case "new"://création d'un joueur (uniquement dans inscription)
                            System.out.println("enregistrement d'un nouveau joueur dans la base");
                            break;
                        case "nom"://modification du nom d'un joueur (existant)
                            System.out.println("modification du nom d'un joueur");
                            break;
                        case "prenom"://modification du prénom d'un joueur (existant)
                            System.out.println("modificatio du prenom d'un joueur");
                            break;
                        case "update":// mise à jour du joueur avec les données dans joueur actuellement
                            System.out.println("modification d'un joueur ");
                            break;
                        case "lastCodeJoueur"://trouver le dernier code joueur utilisé(pour en creer un nouveau)
                            System.out.println("Recherche du dernier code Joueur");
                            int lastCode = 0;
                            //#########acces au dernier code joueur utilisé
                            
                            joueur.setCodeJoueur(lastCode);
                            break;
                        case "load": //charge un joueur depuis un code joueur
                            System.out.println("chargement d'un joueur depuis la base de donnees");
                            break;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(FabriqueDeJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    };
    
    
    public  void fabriqueRequete(){
        
        throw new UnsupportedOperationException("Not supported yet.");
    };    



    
}
