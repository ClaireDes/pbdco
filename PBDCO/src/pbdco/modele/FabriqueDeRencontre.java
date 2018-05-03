/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.Code;

import static pbdco.modele.FabriqueTransaction.*;


/**
 *
 * @author milcenan
 */

public class FabriqueDeRencontre  extends FabriqueTransaction{


        public Code lastCodeBD() throws BDAccessEx{//renvoie le dernier code rencontre utilisé dans la base pour pouvoir en creer un nouveau
        Code code; 
        ResultSet resultat;
        String requete="SELECT MAX(codeRencontre) FROM Rencontres;" ;
        System.out.println("Recherche du dernier code rencontre");
        
        
//        try{// Chragement du Driver
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//        }catch( SQLException ex){
//            throw new BDAccessEx("creerJoueur Raised classNotFound exception during the driver loading");
//        }
         // Connexion à la BD
         try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            try{
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);


                Statement stmt = conn.createStatement();     
                resultat= stmt.executeQuery(requete);

                code =new Code();
                code.setValue(resultat.getInt(1));

                conn.close();

                System.out.println("Le plus grand codeRencontre enregistré est "+code.getValue());         
                return code;
           
             }catch(  SQLException ex){//si la transaction echoue
                 conn.rollback();
                 conn.close();
                 throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the transaction");
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection");
         }
    
    }
    
    public Rencontre LoadFromBD(Code code) throws BDAccessEx{
            return null;
           
        
    }
    
    public void MAJBD(Rencontre rencontre) throws BDAccessEx{
        
        String requete = "UPDATE Rencontre SET Vainqueur=? WHERE codeTour=?, codeRencontre=?";
        
        //Chargement du driver
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }catch( SQLException ex){
            throw new BDAccessEx("MajBD Raised classNotFound exception during the driver loading");
        }
        
        //Connexion bd
        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            try{
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                PreparedStatement pstmt = conn.prepareStatement(requete);
                            if(rencontre.terminee==1){
                                pstmt.setInt(1,rencontre.joueurs[0].codeJoueur.getValue());
                            }
                            if(rencontre.terminee==2){
                                pstmt.setInt(1, rencontre.joueurs[1].codeJoueur.getValue());
                            }
                            
                            pstmt.setInt(2,rencontre.codeTour.getValue());
                            pstmt.setInt(3, rencontre.codeRencontre.getValue());
                            pstmt.executeUpdate();
                            
                
            }catch(  SQLException ex){//si la transaction echoue
                 conn.rollback();
                 conn.close();
                 throw new BDAccessEx("majBD() Raised SQLException during the transaction");
            } 
        }catch(  SQLException ex){
            throw new BDAccessEx("majBD() Raised SQLException during the connection");
         }
    }
    
    public void creerDansBD(Joueur joueur) throws BDAccessEx{
    
    }

    public  void fabriqueRequete(){
        throw new UnsupportedOperationException("Not supported yet.");
    };    

    //@Override
    public void fabriqueTransaction(String operation, Rencontre renc) throws BDAccessEx {
    
        
    
        
        try {
            // Chargement driver
            System.out.print("Loading Oracle driver... "); 
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("loaded");

            
            // Connexion à la BDD
            System.out.println("Connexion à la base de données...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("connecté.");
            
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
            
            PreparedStatement pstmt;
                    switch (operation) {
                        
                        // création d'une nouvelle rencontre
                        case "new":
                            pstmt = conn.prepareStatement("INSERT INTO Rencontre(codeTour, codeRencontre, JoueurBlanc, JoueurNoir) VALUES (?,?,?,?)");
                            pstmt.setInt(1,renc.codeTour.getValue());
                            pstmt.setInt(2, renc.codeRencontre.getValue());
                            pstmt.setInt(3, renc.joueurs[0].codeJoueur.getValue());
                            pstmt.setInt(4, renc.joueurs[1].codeJoueur.getValue());  
                            
                            pstmt.executeUpdate();
                            // chargement d'une rencontre avec la base de données
                            break;
                        
                        // enregistrement du résultat d'une rencontre    
                        case "fini":
                            pstmt = conn.prepareStatement("UPDATE Rencontre SET Vainqueur=? WHERE codeTour=?, codeRencontre=?");
                            if(renc.terminee==1){
                                pstmt.setInt(1,renc.joueurs[0].codeJoueur.getValue());
                            }
                            if(renc.terminee==2){
                                pstmt.setInt(1, renc.joueurs[1].codeJoueur.getValue());
                            }
                            
                            pstmt.setInt(2,renc.codeTour.getValue());
                            pstmt.setInt(3, renc.codeRencontre.getValue());
                            pstmt.executeUpdate();
                            
                            break;
                          
                        // chargement d'une rencontre avec la base de données    
                        case "load":
                            //a recuperer : les deux joueurs, terminee?, la grille
                            pstmt =  conn.prepareStatement("SELECT ");
                            //A COMPLETER                                                        
                            break;
                            
                        case "lastCodeRencontre":// le dernier code rencontre utilisé (pour en generer un nouveau)
                            
                            break;
                            
                    }
                    
                conn.close();
        } catch (SQLException ex) {
throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection"+ex.getMessage());        }
 }
   
}
