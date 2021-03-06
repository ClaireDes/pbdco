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
public class FabriqueDeRencontre extends FabriqueTransaction {

    FabriqueDeJoueur fabDeJoueur;
    FabriqueDePiece fabDePiece;
    FabriqueDeCoups fabDeCoups;

    public FabriqueDeRencontre(FabriqueDeJoueur fabJ, FabriqueDePiece fabP, FabriqueDeCoups fabC) {
        this.fabDeCoups = fabC;
        this.fabDeJoueur = fabJ;
        this.fabDePiece = fabP;
    }

    public Code lastCodeBD() throws BDAccessEx {//renvoie le dernier code rencontre utilisé dans la base pour pouvoir en creer un nouveau
        Code code;
        ResultSet resultat;
        String requete = "SELECT MAX(codeRencontre) FROM Rencontre";
        System.out.println("Recherche du dernier code rencontre");

        // Connexion à la BD
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            try {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                PreparedStatement pstmt = conn.prepareStatement(requete);
                resultat = pstmt.executeQuery();

                resultat.next();

                code = new Code(resultat.getInt(1));

                pstmt.close();
                resultat.close();
                conn.commit();
                conn.close();

                System.out.println("Le plus grand codeRencontre enregistré est " + code.getValue());
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

    public void LoadFromBD(Rencontre rencontre) throws BDAccessEx {

        String requete1 = "SELECT * from Rencontre Where codeRencontre = ?";
        ResultSet resultat;
        Code codeJoueur1, codeJoueur2;
        // String codeTour;

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

                PreparedStatement pstmt = conn.prepareStatement(requete1);
                pstmt.setInt(1, rencontre.getCodeRencontre().getValue());

                resultat = pstmt.executeQuery();

                rencontre.setCodeJoueur1( new Code(resultat.getInt("Joueur1")) );
                rencontre.setCodeJoueur2( new Code(resultat.getInt("Joueur2")) );

                rencontre.setCodeTour(resultat.getString("codeTour"));
                rencontre.setTerminee(resultat.getInt("Vainqueur"));
                rencontre.setBlanc(resultat.getInt("Blanc"));

                pstmt.close();
                conn.commit();
                conn.close();

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                throw new BDAccessEx("loadFromBD Raised SQLException during the transaction");
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("loadFromBD Raised SQLException during the connection");
        }
    }

    public void MAJBD(Rencontre rencontre) throws BDAccessEx { //utilisé pour mettre à jour le vainqueur uniquement 

        String requete = "UPDATE Rencontre SET Vainqueur=? WHERE codeTour=? AND codeRencontre=?";

        //Connexion bd
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }

            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            try {
                PreparedStatement pstmt = conn.prepareStatement(requete);
                if (rencontre.getTerminee() == 1) {
                    pstmt.setInt(1, rencontre.getJoueurs()[0].getCode().getValue());
                }
                if (rencontre.getTerminee() == 2) {
                    pstmt.setInt(1, rencontre.getJoueurs()[1].getCode().getValue());
                }
                pstmt.setString(2, rencontre.getCodeTour());
                pstmt.setInt(3, rencontre.getCodeRencontre().getValue());
                pstmt.executeUpdate();

                pstmt.close();
                conn.commit();
                conn.close();

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                throw new BDAccessEx("majBD() Raised SQLException during the transaction" + ex.getLocalizedMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("majBD() Raised SQLException during the connection" + ex.getMessage());
        }
    }

    public void creerDansBD(Rencontre rencontre) throws BDAccessEx {

        String requete = "INSERT INTO Rencontre(codeRencontre, codeTour,joueur1,joueur2,blanc,noir, vainqueur) VALUES(?,?,?,?,?,?,?)";
        int nbModif;
        // Connexion à la BD
        try {
            Connection conn = null;
            conn = DriverManager.getConnection(URL, USER, PASSWD);
            if (conn == null) {
                throw new BDAccessEx("connexion échouée");
            } else {
                System.out.println("Connection ok");
            }
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            try {

                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete);
                pstmt.setInt(1, rencontre.getCodeRencontre().getValue());
                pstmt.setString(2, rencontre.getCodeTour());
                pstmt.setInt(3, rencontre.getJoueurs()[0].getCode().getValue());
                pstmt.setInt(4, rencontre.getJoueurs()[1].getCode().getValue());
                if (rencontre.getBlanc() == 1) {
                    pstmt.setInt(5, rencontre.getJoueurs()[0].getCode().getValue());
                    pstmt.setInt(6, rencontre.getJoueurs()[1].getCode().getValue());
                }
                else if (rencontre.getBlanc() == 2) {
                    pstmt.setInt(5, rencontre.getJoueurs()[1].getCode().getValue());
                    pstmt.setInt(6, rencontre.getJoueurs()[0].getCode().getValue());
                } else {
                    throw new BDAccessEx("erreur lors de l'insertion d'une rencontre ");
                }
                pstmt.setInt(7, 0);

                System.out.println("Mise a jour de la bd...");
                pstmt.executeUpdate();
                System.out.print("..faite!");
                conn.commit();

                pstmt.close();
                conn.close();
                System.out.println("Enregistrement de la rencontre " + rencontre.getCodeRencontre().getValue() + "effectué");
            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("creerREncontre Raised SQLException during the connection\n" + ex.getMessage());
        }
    }


}
