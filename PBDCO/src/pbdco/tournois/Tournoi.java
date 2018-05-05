/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.Joueur;
import pbdco.vueorga.VuesOrga;

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
    
    public Code ajoutParticipant(String nom, String prenom, String adresse) throws BDAccessEx{
        Inscription inscript = new Inscription(false);
        return inscript.inscrit(nom, prenom, adresse);
    }
    
    public int nbrInscrits() throws BDAccessEx{
        Inscription inscript = new Inscription(false);
        return inscript.getNbrParticipants();
    }
    
    public void commencerLeTournoi() throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false);
        prep.creeRencontre();
    }
    
    public String[] recupererDetails(Code codeJoueur) throws BDAccessEx{
        String[] details = new String[3];
        Inscription inscrit = new Inscription(false);
        Joueur j = inscrit.getFabriqueJoueur().LoadFromBD(codeJoueur);
        details = j.getDetails();
        return details;
    }
    
    public Code[] recupererLesCodesRencontresAJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false); 
        Code[] js = new Code[0];
        
        return js;
    }
    
    public Code[] recupererLesCodesRencontresDejaJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false); 
        Code[] js = new Code[0];
        
        return js;
    }
    
    public String[][] recupRencontresAJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false); 
        Code[] tabCode1 = this.recupererLesCodesRencontresAJouer(codeJoueur);
        
        String[][] recup = new String[tabCode1.length][3];
        
        for(int i=0;i<=tabCode1.length-1;i++){
            recup[i][0] = this.recupererDetails(tabCode1[i])[0];
            recup[i][1] = this.recupererDetails(tabCode1[i])[1];
            recup[i][2] = this.recupererDetails(tabCode1[i])[2];
        }
        
        return recup;
    }
    
    public String[][] recupRencontresDejaJouer(Code codeJoueur) throws BDAccessEx{
        PreparationTour prep = new PreparationTour(false); 
        Code[] tabCode1 = this.recupererLesCodesRencontresDejaJouer(codeJoueur);
        
        String[][] recup = new String[tabCode1.length][3];
        
        for(int i=0;i<=tabCode1.length-1;i++){
            recup[i][0] = this.recupererDetails(tabCode1[i])[0];
            recup[i][1] = this.recupererDetails(tabCode1[i])[1];
            recup[i][2] = this.recupererDetails(tabCode1[i])[2];
        }
        
        return recup;
    }
}
