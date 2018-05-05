/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import pbdco.*;
import pbdco.partie.*;
import java.sql.*;
import javax.sql.*;
import static pbdco.modele.FabriqueTransaction.*;

/**
 *
 * @author milcenan
 */
public class FabriqueDeCoups/* extends FabriqueTransaction*/ {

    public Code lastCodeBD() throws BDAccessEx {
        Code code;
        ResultSet resultat;
        String requete = "SELECT MAX(codeCoup) FROM Coup";
        System.out.println("Recherche du dernier code Coup");

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

                System.out.println("Le plus grand codeCoup Enregistré est " + code.getValue());
                return code;

            } catch (SQLException ex) {//si la transaction echoue
                conn.rollback();
                conn.close();
                throw new BDAccessEx("lastCodeCoup() Raised SQLException during the transaction" + ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new BDAccessEx("lastCodeCoup() Raised SQLException during the connection" + ex.getMessage());
        }

    }

    public void fabriqueRequete(String operation, Coup coup) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    ;    


    public void fabriqueTransaction(String operation, Coup coup) {
        switch (operation) {
            case "new"://création d'un coup 
                System.out.println("enregistrement d'un nouveau joueur dans la base");
                break;

        }

    }

}
