/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.*;
import pbdco.*;
import static pbdco.modele.FabriqueTransaction.*;


/**
 *
 * @author milcenan
 */
public class FabriqueDeOrganisation {
    public int nbrDeJoueurs(Code codeTournois) throws BDAccessEx{
        //ici la requète pour
        //appel à la BD concernant la table TOUR
        //pour connaitre le nombre de joueurs dans le tournois
        String requete = "SELECT COUNT(codeJoueur) FROM Joueur NATURAL JOIN Rencontre WHERE codeTour=?;";
        ResultSet resultat;
        int nbJoueurs=0;
        
        try{// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        }catch( SQLException ex){
            throw new BDAccessEx("nbrDeJoueurs Raised classNotFound exception "
                    + "during the driver loading"+ex.getMessage());
        }
        System.out.println("Driver ok");
        
         // Connexion à la BD
         try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connection ok");
             try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            
            //préparation de la requète
            PreparedStatement pstmt = conn.prepareStatement(requete);
            pstmt.setString(1, "qualif");
            
            resultat = pstmt.executeQuery();
            nbJoueurs = resultat.getInt(1);
            
            conn.commit();
            conn.close();
           System.out.println("Le nombre de participants au tournoi est : " + nbJoueurs);         
             }catch(  SQLException ex){//si la transaction echoue
                conn.close();
                 System.err.println(ex.getMessage());
             }
        }catch(  SQLException ex){
            throw new BDAccessEx("nbrDeJoueurs Raised SQLException during the connection\n"+ ex.getMessage());
        }
         
         return nbJoueurs;
    
    }
    
    public String quelTour(Code codeTournoi){
        
        
        
        //;;;;;
        
        /*if pas de code correspondant , renvoie null ou exception
                
        sinon
        
          renvoie le tour correspondant au code courant*/
        throw new UnsupportedOperationException("Not supported yet.");  
        
    }
        
    public void creerTournois(){
        Code codeTournois = new Code("qualif");
        
        //insert ... crée un tour qualif
    } 
            
    public void setCodeTour(String codeTour){
        
    }        
            
            //Pour l'instanciation dans organisation
    /*fabrique = new fabriqueDeOrganisation()
            fabrique.nbrDeJoueurs()*/
}
