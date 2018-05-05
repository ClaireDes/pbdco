/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.BDAccessEx;
import pbdco.vueorga.*;

/**
 *
 * @author grelliel
 */
public class Tournoi {
    
    public static void main(String[] args){
        //afficher vue ecran d'accueil
//        PremiereVue laFirst = new PremiereVue();
        VuesOrga vue = new VuesOrga();
    }

    public void creerTournoi() throws BDAccessEx{
        Inscription tourn = new Inscription(true);
    }
    
    public void ajoutParticipant(String nom, String prenom, String adresse) throws BDAccessEx{
        Inscription inscript = new Inscription(false);
        inscript.inscrit(nom, prenom, adresse);
    }

}
