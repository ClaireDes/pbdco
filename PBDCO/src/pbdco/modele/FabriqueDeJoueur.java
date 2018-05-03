/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;

import pbdco.Code;
import static pbdco.modele.FabriqueTransaction.URL;
import pbdco.partie.*;


/**
 *
 * @author milcenan
 */
public class FabriqueDeJoueur extends FabriqueTransaction{

    //@Override
   /* public  void fabriqueTransaction(String operation,Joueur joueur){
        
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
            

                    
                    
                    switch (operation) {
                        case "new"://création d'un joueur (uniquement dans inscription)
                            
                            
                            System.out.println("enregistrement d'un nouveau joueur dans la base");
                            
                                        PreparedStatement pstmt = conn.prepareStatement("insert into Joueurs(codeJoueur, Prenom, Nom, Adresse) VALUES(?,?,?,?)");
            pstmt.setInt(1, joueur.codeJoueur.getValue());
            pstmt.setString(2, joueur.prenom);
            pstmt.setString(3, joueur.nom);
            pstmt.setString(4, joueur.adresse);
                      
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
                        case "load": //charge un joueur depuis un code joueur
                            System.out.println("chargement d'un joueur depuis la base de donnees");
                            break;
                    }
          conn.commit();
          conn.close();
          
        } catch (SQLException ex) {
            Logger.getLogger(FabriqueDeJoueur.class.getName()).log(Level.SEVERE, null, ex);
        }
         }*/
    
    
    public void creerDansBD(Joueur joueur) throws BDAccessEx{

         // Connexion à la BD
         try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connection ok");
             try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //préparation de la requète
            PreparedStatement pstmt = conn.prepareStatement("insert into Joueur VALUES(?,?,?,?);");
            pstmt.setInt(1,1 /*joueur.codeJoueur.getValue()*/);
            pstmt.setString(2, joueur.prenom);
            pstmt.setString(3, joueur.nom);
            pstmt.setString(4, joueur.adresse);

            conn.commit();
            conn.close();
           System.out.println("Enregistrement du joueur " +joueur.codeJoueur.getValue() + "effectué");         
             }catch(  SQLException ex){//si la transaction echoue
                conn.close();
                 System.err.println(ex.getMessage());
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("creerJoueur Raised SQLException during the connection\n"+ ex.getMessage());
        }
    }
    
        public void MAJBD(Joueur joueur) throws BDAccessEx{//remplace les données du joueur de code joueur.codeJoueur par celles de joueur
            
         int codeJoueur = joueur.codeJoueur.getValue();
         String requete = "UPDATE joueurs Set nom = ?, prenom = ?, adresse = ? WHERE codeJoueur = ?;";
         
//         try{// Chragement du Driver
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
            //préparation de la requète
            
            PreparedStatement pstmt = conn.prepareStatement(requete);
            pstmt.setString(1, joueur.nom);
            pstmt.setString(2, joueur.prenom);
            pstmt.setString(3, joueur.adresse);
            pstmt.setInt(3, codeJoueur);
            
            conn.commit();
            conn.close();
            
           System.out.println("MAJ du joueur " +joueur.codeJoueur.getValue() + "effectuée");         
             }catch(  SQLException ex){//si la transaction echoue
                conn.close();
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("MAJJoueur Raised SQLException during the connection");
        }
    }
        
  public Joueur LoadFromBD(Code code) throws BDAccessEx{//remplace les données du joueur de code joueur.codeJoueur par celles de joueur
         Joueur J; 
         int codeJoueur = code.getValue();
         String nom;
         String prenom;
         String adresse;
         List rencontres ;
         int nbVictoires;
         String etat = "En cours";
         
         String requete = "SELECT * FROM  joueur  WHERE codeJoueur=?;";
         String requete2 = "SELECT codeRencontre From rencontre WHERE joueur1 = ? OR joueur2 = ? AND etat = ? ;";
         String requete3 = "SELECT COUNT(vainqueur) FROM rencontre where vainqueur= ?;";
         
         ResultSet resultat;
         
//     try{// Chragement du Driver
//        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//    }catch( SQLException ex){
//        throw new BDAccessEx("creerJoueur Raised classNotFound exception during the driver loading"+ex.getMessage());
//    }
         // Connexion à la BD
         try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
             try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //préparation de la requète
            
            PreparedStatement pstmt = conn.prepareStatement(requete);
            pstmt.setInt(1, codeJoueur);
            System.out.println("1");
            
            resultat = pstmt.executeQuery();
            
            System.out.println("2");
            resultat.next();
            nom=resultat.getString(2);
            prenom=resultat.getString(3);
            adresse = resultat.getString(4);
            
                 System.out.println("requete 1 ok");
         
            pstmt.close();
            resultat.close();
            
            pstmt = conn.prepareStatement(requete2); 
            pstmt.setInt(1, codeJoueur);
            pstmt.setInt(2, codeJoueur);
            pstmt.setString(3,etat);
            
            resultat = pstmt.executeQuery();
            
            rencontres = new ArrayList();
            boolean resteResultat = resultat.next();
            while (resteResultat){
                    rencontres.add(resultat.getInt(1));
                    resteResultat = resultat.next();
            }
            pstmt.close();
            resultat.close();
            
            pstmt = conn.prepareStatement(requete3); 
            pstmt.setInt(1, codeJoueur);
           
            resultat = pstmt.executeQuery();
            resultat.next();
            nbVictoires=resultat.getInt(1);
            pstmt.close();
            resultat.close();
            
            J = new Joueur(nom ,prenom ,code,adresse,rencontres,nbVictoires,this);
            
            conn.commit();
            conn.close();
            
           System.out.println("LoadFromBD du joueur " +codeJoueur + "effectuée");      
           return J;
           
             }catch(  SQLException ex){//si la transaction echoue
                conn.close();
                 throw new BDAccessEx("LoadFromBD Joueur Raised SQLException during the transaction" + ex.getMessage());
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("LoadFromBD Joueur Raised SQLException during the connection"+ex.getMessage());
        }
    }
        
  
  
  
    public Code lastCodeBD() throws BDAccessEx{//renvoie le dernier code joueur utilisé dans la base pour pouvoiren creer un nouveau
        Code code; 
        ResultSet resultat;
        String requete="SELECT MAX(codeJoueur) FROM Joueur;" ;
        System.out.println("Recherche du dernier code Joueur");
        
        
//        try{// Chragement du Driver
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//        }catch( SQLException ex){
//            throw new BDAccessEx("creerJoueur Raised classNotFound exception during the driver loading" + ex.getMessage());
//        }
         // Connexion à la BD
         try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
             try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
     
            
           //Statement stmt = conn.createStatement();   
           PreparedStatement pstmt;
           
           System.out.println("statement  ok : " + requete);
           
           pstmt = conn.prepareStatement(requete); 
           resultat = pstmt.executeQuery();
           
           //resultat= stmt.executeQuery(requete);
                 System.out.println("requete ok");
            code =new Code();
            code.setValue(resultat.getInt(1));
            
            conn.close();
            
           System.out.println("Le plus grand codeJoueur Enregistré est "+code.getValue());         
           return code;
           
             }catch(  SQLException ex){//si la transaction echoue
                 conn.rollback();
                 conn.close();
                  throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the transaction"+ ex.getMessage());
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection"+ex.getMessage());
         }
    }
}
