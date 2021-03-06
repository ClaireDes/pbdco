/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import static java.lang.String.valueOf;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.Joueur;
import pbdco.vueorga.VueAccueilOrganisation;
import pbdco.vueorga.VueCreation;


/**
 *
 * @author grelliel
 */
public class Tournoi {

    public static void main(String[] args){
        //afficher vue ecran d'accueil
//        PremiereVue laFirst = new PremiereVue();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueAccueilOrganisation().setVisible(true);
            }
        });
    }

    public void creerTournoi() throws BDAccessEx{
        Inscription tourn = new Inscription(true);
    }

    public Code ajoutParticipant(String nom, String prenom, String adresse) throws BDAccessEx{
        Inscription inscript = new Inscription(false);
        return inscript.inscrit(nom, prenom, adresse);
    }

    public int nbrInscrits() throws BDAccessEx{
        Inscription inscript = new Inscription(false);
        int nbr = inscript.getNbrParticipants();
        return nbr;
    }

    public void commencerLeTournoi() throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false);
        prep.creeRencontre();
    }

    public String[] recupererDetails(Code codeJoueur) throws BDAccessEx{
        String[] details;
        Inscription inscrit = new Inscription(false);
        System.out.println("le codeJoueur est "+ valueOf(codeJoueur.getValue()));
        Joueur j = inscrit.getFabriqueJoueur().LoadFromBD(codeJoueur);
        details = j.getDetails();
        return details;
    }

    public Code[] recupererLesCodesRencontresAJouer(Code codeJoueur) throws BDAccessEx{
        Inscription inscrit = new Inscription(false);
                System.out.println("le codeJoueur est "+ valueOf(codeJoueur.getValue()));

        Joueur j = inscrit.getFabriqueJoueur().LoadFromBD(codeJoueur);
        Code[] js = j.getRencontresAJouer();
        return js;
    }

    public Code[] recupererLesCodesRencontresDejaJouer(Code codeJoueur) throws BDAccessEx{
        Inscription inscrit = new Inscription(false);
                        System.out.println("le codeJoueur est "+ valueOf(codeJoueur.getValue()));

        Joueur j = inscrit.getFabriqueJoueur().LoadFromBD(codeJoueur);        
        Code[] js = j.getRencontresJouees();

        return js;
    }

    public String[][] recupRencontresAJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false);
        Code[] tabCode1 = this.recupererLesCodesRencontresAJouer(codeJoueur);

        String[][] recup = new String[tabCode1.length][3];
                
        if(tabCode1 != null){
            for(int i=0;i<tabCode1.length;i++){
                recup[i][0] = this.recupererDetails(tabCode1[i])[0];
                recup[i][1] = this.recupererDetails(tabCode1[i])[1];
                recup[i][2] = this.recupererDetails(tabCode1[i])[2];
            }
        }

        return recup;
    }

    public String[][] recupRencontresDejaJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false);
        Code[] tabCode1 = this.recupererLesCodesRencontresDejaJouer(codeJoueur);

        String[][] recup = new String[tabCode1.length][3];
        if(tabCode1 != null){
            for(int i=0;i<=tabCode1.length-1;i++){
                recup[i][0] = this.recupererDetails(tabCode1[i])[0];
                recup[i][1] = this.recupererDetails(tabCode1[i])[1];
                recup[i][2] = this.recupererDetails(tabCode1[i])[2];
            }
        }

        return recup;
    }
}
