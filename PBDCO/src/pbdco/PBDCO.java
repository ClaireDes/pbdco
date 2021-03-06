/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.modele.FabriqueDeJoueur;
import pbdco.modele.*;
import pbdco.*;
import pbdco.partie.Fou;
import pbdco.partie.Piece;
import pbdco.partie.Position;

/**
 *
 * @author milcenan
 */
public class PBDCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //test création joueur + déclaration dans la BD

        try {// Chragement du Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException ex) {
            System.err.println("proleme diver");
        }
        System.out.println("Driver ok");

        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        FabriqueDePiece fabPiece = new FabriqueDePiece();
        FabriqueDeCoups fabCoups = new FabriqueDeCoups();
        FabriqueDeRencontre fabRencontre = new FabriqueDeRencontre(fabJoueur,fabPiece,fabCoups);
        ResultSet resultat;

        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1", "grelliel", "grelliel");
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        PreparedStatement pstmt = conn.prepareStatement("select * from  Joueur");

        System.out.println("1");
        if (conn == null) {
            System.out.println("c est la connexion le problème");
        }
        resultat = pstmt.executeQuery();

        System.out.println("2");
        conn.commit();
        resultat.next();
        System.out.println(resultat.getInt(1));
        System.out.println(resultat.getString(3));
        System.out.println(resultat.getString(4));

        resultat.close();
        pstmt.close();
        conn.close();

       
        try {
            Piece f = new Fou(new Position(1,1),true);
            fabPiece.nouvellePiece(f, new Code("qualif"), new Code(1));
            
            //test création controleur
            //test communication vue / controlleur
            //test communication vue / modèle
        } catch (BDAccessEx ex) {
            Logger.getLogger(PBDCO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
