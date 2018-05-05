/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.sql.*;
import pbdco.partie.*;
import pbdco.*;
import static pbdco.modele.FabriqueTransaction.*;

/**
 *
 * @author milcenan
 */
public class FabriqueDePiece {

    FabriqueDeCoups fabDeCoup;

    public void fabriqueTransaction(String operation, Piece piece) {
        switch (operation) {

            //déplacement d'une pièce dans la base de données à l'occasiond'un coup
            case "move":
                System.out.println("enregistrement d'une pièce \"" + piece.getNom() + "\" dans la base");
                break;
        }
    }

    //création d'une pièce correspondant à la pièce passée en parametre
    public void nouvellePiece(Piece piece, Code codeTour, Code codeRencontre) throws BDAccessEx {

        //ajouter codePiece ??
        String requete = "INSERT INTO Piece(ligneInit, colonneInit, "
                + "ligneFin, colonneFin, typePiece, couleur, codeRencontre, codeTour)"
                + "VALUES ?,?,?,?,?,?,?,?";

        try {// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException ex) {
            throw new BDAccessEx("nouvellePiece Raised classNotFound exception "
                    + "during the driver loading" + ex.getMessage());
        }
        System.out.println("Driver ok");

        // Connexion à la BD
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connection ok");
            try {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete);
                pstmt.setInt(1, piece.getPreviousPosition().getX());
                pstmt.setInt(2, piece.getPreviousPosition().getY());
                pstmt.setInt(3, piece.getCurrentPosition().getX());
                pstmt.setInt(4, piece.getCurrentPosition().getY());
                pstmt.setString(5, piece.getNom());
                pstmt.setString(6, piece.getCouleur());
                pstmt.setInt(7, codeRencontre.getValue());
                pstmt.setInt(8, codeTour.getValue());

                pstmt.executeUpdate();

                conn.commit();
                conn.close();

                System.out.println("enregistrement d'une pièce \"" + piece.getNom() + "\" dans la base");

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("nouvellePiece Raised SQLException during the connection\n" + ex.getMessage());
        }

    }

    // il manque la nouvelle position ?
    public void bougePiece(Piece piece, Coup coup, Code codeTour, Code codeRencontre) throws BDAccessEx {//création d'une pièce correspondant à la pièce passée en parametre

        String requete1 = "UPDATE Piece SET ligneInit=?, colonneInit=?, "
                + "ligneFin, colonneFin WHERE codePiece=?";
        String requete2 = "INSERT INTO Coup(codeCoup, ligneCoup, colonneCoup, "
                + "lignePrec, colonnePrec, codeRencontre, codeTour) VALUES ?,?,?,?,?,?,?";

        try {// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException ex) {
            throw new BDAccessEx("bougePiece Raised classNotFound exception "
                    + "during the driver loading" + ex.getMessage());
        }
        System.out.println("Driver ok");

        // Connexion à la BD
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connection ok");
            try {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                //préparation de la requète
                PreparedStatement pstmt = conn.prepareStatement(requete1);
                pstmt.setInt(1, coup.getPreviousX(piece));
                pstmt.setInt(2, coup.getPreviousY(piece));
                //pstmt.setInt(3, )
                pstmt.executeUpdate();

                pstmt = conn.prepareStatement(requete2);
                pstmt.setInt(1, fabDeCoup.lastCodeBD().getValue());
            //pstmt.setInt(2,)
                //pstmt.setInt(3.)
                pstmt.setInt(4, coup.getPreviousX(piece));
                pstmt.setInt(5, coup.getPreviousY(piece));
                pstmt.setInt(6, codeRencontre.getValue());
                pstmt.setInt(7, codeTour.getValue());
                pstmt.executeUpdate();

                conn.commit();
                conn.close();

                System.out.println("enregistrement du coup \"" + piece.getNom() + "\" dans la base");

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                System.err.println(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("nouvellePiece Raised SQLException during the connection\n" + ex.getMessage());
        }

        System.out.println("enregistrement du déplacement de la pièce \"" + piece.getNom() + "\"  à partir de " + coup.getPreviousY(piece) + "," + coup.getPreviousX(piece));
    }

}
