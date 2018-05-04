/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;


import java.sql.*;
import java.util.Random;
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

        FabriqueDeJoueur fabDeJoueur;
        FabriqueDePiece fabDePiece;
        FabriqueDeCoups fabDeCoups;
        
        public Code lastCodeBD() throws BDAccessEx{//renvoie le dernier code rencontre utilisé dans la base pour pouvoir en creer un nouveau
        Code code; 
        ResultSet resultat;
        String requete="SELECT MAX(codeRencontre) FROM Rencontres" ;
        System.out.println("Recherche du dernier code rencontre");

         // Connexion à la BD
            try{
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn==null){throw new BDAccessEx("connexion échouée");}
            else{ System.out.println("Connection ok");}
            try{
                Statement stmt = conn.createStatement();     
                resultat= stmt.executeQuery(requete);
                
                resultat.next();

                code =new Code(resultat.getInt(1));

                stmt.close();
                resultat.close();
                conn.close();

                System.out.println("Le plus grand codeRencontre enregistré est "+code.getValue());         
                return code;
           
             }catch(  SQLException ex){//si la transaction echoue

                 conn.close();
                 throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the transaction");
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection");
         }
    
    }
    
    public void LoadFromBD(Rencontre rencontre) throws BDAccessEx{
        
        String requete1 = "SELECT * from Rencontre Where codeRencontre = ?";
        ResultSet resultat;
        Code codeJoueur1, codeJoueur2;
       // String codeTour;
       
         // Connexion à la BD
            try{
              Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn==null){throw new BDAccessEx("connexion échouée");}
            else{ System.out.println("Connection ok");}
            try{
             
                PreparedStatement stmt = conn.prepareStatement(requete1);
                stmt.setInt(1, rencontre.codeRencontre.getValue());
                
                resultat= stmt.executeQuery(requete1);
               
                rencontre.codeJoueur1 = new Code(resultat.getInt("Joueur1"));
                rencontre.codeJoueur2 = new Code(resultat.getInt("Joueur2"));

                rencontre.codeTour = resultat.getString("codeTour");
                rencontre.terminee = resultat.getInt("Vainqueur");
                rencontre.blanc=  resultat.getInt("Blanc");

                stmt.close();
                conn.close();
           
             }catch(  SQLException ex){//si la transaction echoue
                 conn.rollback();
                 conn.close();
                 throw new BDAccessEx("loadFromBD Raised SQLException during the transaction");
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("loadFromBD Raised SQLException during the connection");
         }
    }
    
    public void MAJBD(Rencontre rencontre) throws BDAccessEx{ //utilisé pour mettre à jour le vainqueur uniquement 
        
        String requete = "UPDATE Rencontre SET Vainqueur=? WHERE codeTour=? AND codeRencontre=?";
        
        //Chargement du driver
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }catch( SQLException ex){
            throw new BDAccessEx("MajBD Raised classNotFound exception during the driver loading");
        }
        
        //Connexion bd
        

            try{
              Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn==null){throw new BDAccessEx("connexion échouée");}
            else{ System.out.println("Connection ok");}
            
            try{
                        PreparedStatement pstmt = conn.prepareStatement(requete);
                            if(rencontre.terminee==1){
                                pstmt.setInt(1,rencontre.joueurs[0].codeJoueur.getValue());
                            }
                            if(rencontre.terminee==2){
                                pstmt.setInt(1, rencontre.joueurs[1].codeJoueur.getValue());
                            }
                            pstmt.setString(2,rencontre.codeTour);
                            pstmt.setInt(3, rencontre.codeRencontre.getValue());
                            pstmt.executeUpdate();
                            
                            pstmt.close();
                            conn.close();
                
            }catch(  SQLException ex){//si la transaction echoue
                 conn.close();
                 throw new BDAccessEx("majBD() Raised SQLException during the transaction" + ex.getLocalizedMessage());
            } 
        }catch(  SQLException ex){
            throw new BDAccessEx("majBD() Raised SQLException during the connection"+ex.getMessage());
         }
    }
    
    
    public void creerDansBD(Rencontre rencontre) throws BDAccessEx{
        
        String requete = "INSERT INTO Rencontre (codeRencontre, codeTour,Joueur1,joueur2,Blanc,Noir) VALUES(?,?,?,?,?,?)";
        int nbModif;
         // Connexion à la BD
            try{
              Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn==null){throw new BDAccessEx("connexion échouée");}
            else{ System.out.println("Connection ok");}
             try{
            
            //préparation de la requète
            PreparedStatement pstmt = conn.prepareStatement(requete);
            pstmt.setInt(1, rencontre.codeRencontre.getValue());
            pstmt.setString(2, rencontre.codeTour);
            pstmt.setInt(3, rencontre.joueurs[0].codeJoueur.getValue());
            pstmt.setInt(4, rencontre.joueurs[1].codeJoueur.getValue());
            if (rencontre.blanc == 1){
                pstmt.setInt(5, rencontre.joueurs[0].codeJoueur.getValue());  
                pstmt.setInt(6, rencontre.joueurs[1].codeJoueur.getValue());  
            }else{
                pstmt.setInt(5, rencontre.joueurs[1].codeJoueur.getValue()); 
                pstmt.setInt(6, rencontre.joueurs[0].codeJoueur.getValue());  
            }
            

            nbModif = pstmt.executeUpdate();
            if (nbModif !=6){throw  new BDAccessEx("erreur lors de l'insertion de l'insertion d'une rencontre : " + nbModif  +"champs ajoutés au lieu de 6");}
   
            pstmt.close();
            conn.close();
            System.out.println("Enregistrement de la rencontre " +rencontre.codeRencontre.getValue() + "effectué");         
             }catch(  SQLException ex){//si la transaction echoue
                conn.close();
                 System.err.println(ex.getMessage());
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("creerREncontre Raised SQLException during the connection\n"+ ex.getMessage());
        }
    }



//    //@Override
//    public void fabriqueTransaction(String operation, Rencontre renc) throws BDAccessEx {
//        try {
//            // Chargement driver
//            System.out.print("Loading Oracle driver... "); 
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            System.out.println("loaded");
//
//            
//            // Connexion à la BDD
//            System.out.println("Connexion à la base de données...");
//            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
//            System.out.println("connecté.");
//            
//            conn.setAutoCommit(false);
//            conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
//            
//            PreparedStatement pstmt;
//                    switch (operation) {
//                        
//                        // création d'une nouvelle rencontre
//                        case "new":
//                            pstmt = conn.prepareStatement("INSERT INTO Rencontre(codeTour, codeRencontre, JoueurBlanc, JoueurNoir) VALUES (?,?,?,?)");
//                            pstmt.setInt(1,renc.codeTour.getValue());
//                            pstmt.setInt(2, renc.codeRencontre.getValue());
//                            pstmt.setInt(3, renc.joueurs[0].codeJoueur.getValue());
//                            pstmt.setInt(4, renc.joueurs[1].codeJoueur.getValue());  
//                            
//                            pstmt.executeUpdate();
//                            // chargement d'une rencontre avec la base de données
//                            break;
//                        
//                        // enregistrement du résultat d'une rencontre    
//                        case "fini":
//                            pstmt = conn.prepareStatement("UPDATE Rencontre SET Vainqueur=? WHERE codeTour=?, codeRencontre=?");
//                            if(renc.terminee==1){
//                                pstmt.setInt(1,renc.joueurs[0].codeJoueur.getValue());
//                            }
//                            if(renc.terminee==2){
//                                pstmt.setInt(1, renc.joueurs[1].codeJoueur.getValue());
//                            }
//                            
//                            pstmt.setInt(2,renc.codeTour.getValue());
//                            pstmt.setInt(3, renc.codeRencontre.getValue());
//                            pstmt.executeUpdate();
//                            
//                            break;
//                          
//                        // chargement d'une rencontre avec la base de données    
//                        case "load":
//                            //a recuperer : les deux joueurs, terminee?, la grille
//                            pstmt =  conn.prepareStatement("SELECT ");
//                            //A COMPLETER                                                        
//                            break;
//                            
//                        case "lastCodeRencontre":// le dernier code rencontre utilisé (pour en generer un nouveau)
//                            
//                            break;
//                            
//                    }
//                    
//                conn.close();
//        } catch (SQLException ex) {
//throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection"+ex.getMessage());        }
// }
   
}
