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
import pbdco.tournois.Inscription;

/**
 *
 * @author milcenan
 */
public class FabriqueDeJoueur extends FabriqueTransaction {

    public void creerDansBD(Joueur joueur) throws BDAccessEx {
        Connection conn = null;
        // Connexion à la BD
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }

            try {
                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement("insert into Joueur VALUES(?,?,?,?)");
                pstmt.setInt(1, joueur.getCodeJoueur().getValue());
                pstmt.setString(2, joueur.getPrenom());
                pstmt.setString(3, joueur.getNom());
                pstmt.setString(4, joueur.getAdresse());

                pstmt.executeQuery();

                pstmt.close();
                conn.close();

                System.out.println("Enregistrement du joueur " + joueur.getCodeJoueur().getValue() + " effectué");

            } catch (SQLException ex) {//si la transaction echoue
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("creerJoueur Raised SQLException during the connection\n" + ex.getMessage());
        }
    }

    public void MAJBD(Joueur joueur) throws BDAccessEx {//remplace les données du joueur de code joueur.codeJoueur par celles de joueur

        int codeJoueur = joueur.getCodeJoueur().getValue();
        String requete = "UPDATE joueurs Set nom = ?, prenom = ?, adresse = ? WHERE codeJoueur = ?";
        int champsModif;
        // Connexion à la BD
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }
            try {
                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete);
                pstmt.setString(1, joueur.getNom());
                pstmt.setString(2, joueur.getPrenom());
                pstmt.setString(3, joueur.getAdresse());
                pstmt.setInt(3, codeJoueur);

                champsModif = pstmt.executeUpdate();
                if (champsModif != 3) {
                    throw new BDAccessEx("Problème lors de la jour de la BD : " + champsModif + " champs modifiés au lieu de 3");
                }

                pstmt.close();
                conn.close();

                System.out.println("MAJ du joueur " + joueur.getCodeJoueur().getValue() + "effectuée");
            } catch (SQLException ex) {//si la transaction echoue
                conn.close();
                System.out.println("MAJ du joueur " + joueur.getCodeJoueur().getValue() + "échouée" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("MAJJoueur Raised SQLException during the connection");
        }
    }

    public Joueur LoadFromBD(Code code) throws BDAccessEx {//remplace les données du joueur de code joueur.codeJoueur par celles de joueur
        Joueur J;
        int codeJoueur = code.getValue();
        String nom, prenom, adresse;
        Inscription inscript = new Inscription(false);
        int verif = inscript.getNbrRencontres();
        Code[] rencontresAJouer = new Code[verif];
        Code[] rencontresJouees = new Code[verif];
        int nbVictoires;

        String requete = "SELECT * FROM  Joueur  WHERE codeJoueur=?";
        String rRencontresAJouer = "SELECT codeRencontre From Rencontre WHERE (joueur1 = ? OR joueur2 = ?) AND vainqueur=?";
        String rRencontresJouees = "SELECT codeRencontre From Rencontre WHERE (joueur1 = ? OR joueur2 = ?) AND NOT(vainqueur =?)";
        String requete3 = "SELECT COUNT(vainqueur) FROM rencontre where vainqueur= ?";

        ResultSet resultat;

        // Connexion à la BD
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            try {

                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                
                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete);
                pstmt.setInt(1, codeJoueur);

                resultat = pstmt.executeQuery();
                resultat.next();
                nom = resultat.getString(2);
                prenom = resultat.getString(3);
                adresse = resultat.getString(4);

                pstmt.close();
                resultat.close();

                pstmt = conn.prepareStatement(rRencontresAJouer);
                pstmt.setInt(1, codeJoueur);
                pstmt.setInt(2, codeJoueur);
                pstmt.setInt(3, 0);

                resultat = pstmt.executeQuery();

                boolean resteResultat = resultat.next();
                int i =0;
                while (resteResultat) {
                    rencontresAJouer[i]= new Code(resultat.getInt(1));
                    resteResultat = resultat.next();
                    i++;
                }
                i=0;
                pstmt.close();
                resultat.close();
                
                pstmt = conn.prepareStatement(rRencontresJouees);
                pstmt.setInt(1, codeJoueur);
                pstmt.setInt(2, codeJoueur);
                pstmt.setInt(3, 0);

                resultat = pstmt.executeQuery();

                resteResultat = resultat.next();
                while (resteResultat) {
                    rencontresJouees[i] = new Code(resultat.getInt(1));
                    resteResultat = resultat.next();
                     i++;
                }
                pstmt.close();
                resultat.close();

                pstmt = conn.prepareStatement(requete3);
                pstmt.setInt(1, codeJoueur);

                resultat = pstmt.executeQuery();
                resultat.next();
                nbVictoires = resultat.getInt(1);
                pstmt.close();
                resultat.close();

                J = new Joueur(nom, prenom, code, adresse, rencontresJouees, rencontresAJouer, nbVictoires, this);

                resultat.close();
                pstmt.close();
                conn.commit();
                conn.close();

                System.out.println("LoadFromBD du joueur " + codeJoueur + "effectuée");
                return J;

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                throw new BDAccessEx("LoadFromBD Joueur Raised SQLException during the transaction" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("LoadFromBD Joueur Raised SQLException during the connection" + ex.getMessage());
        }
    }

    public Code lastCodeBD() throws BDAccessEx {//renvoie le dernier code joueur utilisé dans la base pour pouvoiren creer un nouveau
        Code code;
        ResultSet resultat;
        String requete = "SELECT MAX(codeJoueur) FROM Joueur";
        System.out.println("Recherche du dernier code Joueur");

//        try{// Chragement du Driver
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//        }catch( SQLException ex){
//            throw new BDAccessEx("creerJoueur Raised classNotFound exception during the driver loading" + ex.getMessage());
//        }
        // Connexion à la BD
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            try {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                PreparedStatement pstmt;

                System.out.println("statement  ok : " + requete);

                pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();
                resultat.next();

                System.out.println("requete ok");
                code = new Code();
                code.setValue(resultat.getInt(1));

                conn.commit();
                conn.close();

                System.out.println("Le plus grand codeJoueur Enregistré est " + code.getValue());
                return code;

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the transaction" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("lastCodeJoueur() Raised SQLException during the connection" + ex.getMessage());
        }
    }
}
