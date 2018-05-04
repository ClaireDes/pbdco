/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author deshayec
 */
public class TestAccesBD {
    
    static final String CONN_URL = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
    static final String USER = "grelliel"; // A remplacer pour votre compte
    static final String PASSWD = "grelliel";

    public static void main(String[] args) {
        try {
            // Enregistrement du driver Oracle
            System.out.print("Loading Oracle driver... ");
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("loaded");
            // Etablissement de la connection
            System.out.print("Connecting to the database... ");
            Connection conn = DriverManager.getConnection(CONN_URL, USER, PASSWD);
            System.out.println("connected");
            
            
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            
            // Creation de la requete
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(codeJoueur) from Joueur");

            ResultSet res;
            res = pstmt.executeQuery();
            res.next();
            System.out.println("max code joueur = "+res.getInt(1));
            
            conn.commit();

            // Fermeture 
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
    }

}

