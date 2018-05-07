/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.modele.FabriqueDeOrganisation;
import pbdco.modele.Joueur;
import pbdco.modele.Rencontre;
import pbdco.vueorga.VueAccueilOrganisation;

/**
 *
 * @author grelliel
 */
public class MainTest {
    
        public static void main(String[] args) throws SQLException, BDAccessEx {
            try {
                FabriqueDeOrganisation fabO = new FabriqueDeOrganisation();
                int n = fabO.nbrDeJoueurs();
                System.out.println("Nombre de joueurs : "+n);
            } catch (BDAccessEx ex) {
                Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            System.out.println("Deuxième Test");
            System.out.println("");
            
            Inscription tournoi = new Inscription(false);
            tournoi.getFabriqueOrga().nbrRencontres(tournoi.getTour());
            
            System.out.println("Deuxième Test");
            System.out.println("");
            
            Joueur j1 = new Joueur("raton", "laveur", "foret", tournoi.getFabriqueJoueur());
            Joueur j2 = new Joueur("renard", "futer", "poulailler", tournoi.getFabriqueJoueur());
            
            
            System.out.println("Deuxième Test");
            System.out.println("");
            
            Rencontre renc = new Rencontre(j1, j2, tournoi.getTour(), tournoi.getFabriqueRencontre());
            
            
            
            
        }
    
}
