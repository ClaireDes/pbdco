
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.modele.FabriqueDeOrganisation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claire
 */
public class TestNbJoueurs {
    
        public static void main(String[] args) throws SQLException {
            try {
                FabriqueDeOrganisation fabO = new FabriqueDeOrganisation();
                int n = fabO.nbrDeJoueurs();
                System.out.println("Nombre de joueurs : "+n);
            } catch (BDAccessEx ex) {
                Logger.getLogger(TestNbJoueurs.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
