/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pbdco.*;
import static pbdco.modele.FabriqueTransaction.*;

/**
 *
 * @author milcenan
 */
public class FabriqueDeOrganisation extends FabriqueTransaction {

    public FabriqueDeOrganisation() throws BDAccessEx {
        try {// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException ex) {
            throw new BDAccessEx(" exception " + "during the driver loading" + ex.getMessage());
        }
        System.out.println("Driver ok");
    }

    public int nbrDeJoueurs() throws BDAccessEx {
        //ici la requète pour
        //appel à la BD concernant la table TOUR
        //pour connaitre le nombre de joueurs dans le tournois
        String requete = "SELECT COUNT(codeJoueur) FROM Joueur WHERE codeJoueur>0";
        ResultSet resultat;
        int nbJoueurs = 0;

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
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt;

                pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();

                resultat.next();
                nbJoueurs = resultat.getInt(1);

                conn.commit();
                conn.close();
                System.out.println("Le nombre de participants au tournoi est : " + nbJoueurs);
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("nbrDeJoueurs Raised SQLException during the connection\n" + ex.getMessage());
        }
        return nbJoueurs;
    }

    public int quelTour() throws BDAccessEx {
        String requete = "SELECT Count(codeTour) FROM Tour";
        ResultSet resultat;
        String tour = "";
        int res = 0;

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

                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();
                resultat.next();

                res = resultat.getInt(1);
//            if (res==1)
//                tour = "qualif";
//            else if (res==2)
//                tour = "quart";
//            else if(res==3)
//                tour="demi";
//            else
//                tour="finale";
                conn.commit();
                conn.close();
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("quelTour Raised SQLException during the connection\n" + ex.getMessage());
        }
        return res;
    }

    /**
     *
     * Charge tous les joueurs de la BD dans la HashMap joueur Cette hashMap
     * permet d'avoir un acces rapide à tous les joueurs en ne connaissant que
     * leur code Afin d'assurer que deux instances du meme joueur ne soient
     * jamais créees en meme temps, il est recommandé de charger tous les
     * joueurs une fois avec cette methose puis d'utiliser la hashMap pour faire
     * les modifs dessus. Si un nouveau Joueur est ajouté à la BD, il faut
     * l'ajouter à la HashMap avec la methode put (int, Joueur) l'enregistrement
     * dans la BD se fait dans le constructeur de joueur
     *
     * @return
     * @throws BDAccessEx
     */
    public Map loadAllJoueurs() throws BDAccessEx {
        Map<Integer, Joueur> joueurs;
        joueurs = new HashMap<>();
        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        int codeJoueur;
        String requete = "SELECT codeJoueur FROM Joueur";
        ResultSet resultat;
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
                resultat = pstmt.executeQuery();

                while (resultat.next()) {//Ajoute les joueurs de la BD dans le Set avec la methode déjà écrite dans Fabrique de Joueur
                    joueurs.put(resultat.getInt("codeJoueur"), fabJoueur.LoadFromBD(new Code(resultat.getInt("codeJoueur"))));
                }

                resultat.close();
                pstmt.close();
                conn.close();
                return joueurs;

            } catch (SQLException ex) {//si la transaction echoue
                conn.close();
                System.out.println(ex.getMessage());
                throw new BDAccessEx("loadAllJoueur Raised SQLException during the Query" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("loadAllJoueur Raised SQLException during the connection");
        }
    }

    public Code[] loadJoueurs() throws BDAccessEx {
        Code[] joueurs = new Code[this.nbrDeJoueurs()];
        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        int codeJoueur;
        String requete = "SELECT codeJoueur FROM Joueur WHERE codeJoueur>0";
        ResultSet resultat;
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
                resultat = pstmt.executeQuery();
                while (resultat.next()) {//Ajoute les joueurs de la BD dans le Set avec la methode déjà écrite dans Fabrique de Joueur
                    joueurs[resultat.getInt("codeJoueur") - 1] = new Code(resultat.getInt("codeJoueur"));
                }

                resultat.close();
                pstmt.close();
                conn.close();
                return joueurs;

            } catch (SQLException ex) {//si la transaction echoue
                conn.close();
                System.out.println(ex.getMessage());
                throw new BDAccessEx("loadJoueur Raised SQLException during the Query" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("loadJoueur Raised SQLException during the connection");
        }
    }

    /**
     *
     * Met à jour tous les joueurs de la BD (et uniquement ceux qui sont encore
     * présents dedans, les vielles instances de joueur déjà supprimées ne
     * seront pas ajoutées) à partir de la hashMap Fournie qui doit etre à jour
     * en permanence puisqu'elle contient les instances uniques des Joueur
     *
     * Peut etre utile mais pas nécéssaire.
     *
     * @throws BDAccessEx
     */
    public void UpdateAllJoueurs(Map<Integer, Joueur> joueurs) throws BDAccessEx {

        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        int codeJoueur;
        String requete = "SELECT codeJoueur FROM Joueur";
        ResultSet resultat;
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

                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();

                while (resultat.next()) {//Mets à jour les joueurs de la BD avec la methode de FabriqueDeJoueur
                    fabJoueur.MAJBD(joueurs.get(resultat.getInt(1)));
                }
                resultat.close();
                pstmt.close();
                conn.commit();
                conn.close();
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.out.println(ex.getMessage());
                throw new BDAccessEx("loadAllJoueur Raised SQLException during the Query" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("loadAllJoueur Raised SQLException during the connection");
        }
    }

    public Map loadAllRencontres(String codeTour) {
        // construite sur le meme principe que load all joueurs pour garantir que les rencontres ne sont créees qu'une seule fois 
        //pas forcement necessaire mais peut etre utile
        throw new UnsupportedOperationException("not supported yet");
    }

    public int nbrRencontres(String codeTour) throws BDAccessEx {
        String requete = "SELECT COUNT(codeRencontre) FROM Rencontre WHERE codeTour='" + codeTour + "'";
        ResultSet resultat;
        int nbRencontres = 0;

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
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt;
                pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();

                resultat.next();

                nbRencontres = resultat.getInt(1);

                conn.commit();
                conn.close();
                System.out.println("Le nombre de rencontres dans le tour " + codeTour + " est : " + nbRencontres);
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("nbrRencontres Raised SQLException during the connection\n" + ex.getMessage());
        }
        return nbRencontres;
    }

    public void creerTournois() throws BDAccessEx {
        Code codeTournois = new Code("qualif");
        // doit supprimer tous les elements dans les tables (peut se faire en recreant les tables)
        //insert ... crée un tour qualif
        String rViderCoup = "DELETE FROM Coup";
        String rViderJoueur = "DELETE FROM Joueur WHERE codeJoueur>0";
        String rViderPiece = "DELETE FROM Piece";
        String rViderTour = "DELETE FROM Tour";
        String rViderRencontre = "DELETE FROM Rencontre";
        String rCreerQualif = "INSERT INTO TOUR VALUES('qualif')";

        try {
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }
            try {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(rViderCoup);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(rViderPiece);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(rViderRencontre);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(rViderJoueur);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(rViderTour);
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(rCreerQualif);
                pstmt.executeUpdate();

                pstmt.close();
                conn.commit();
                conn.close();
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.out.println(ex.getMessage());
                throw new BDAccessEx("loadAllJoueur Raised SQLException during the Query" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("loadAllJoueur Raised SQLException during the connection");
        }
    }

    //Pour l'instanciation dans organisation
    /*fabrique = new fabriqueDeOrganisation()
     fabrique.nbrDeJoueurs()*/
}
