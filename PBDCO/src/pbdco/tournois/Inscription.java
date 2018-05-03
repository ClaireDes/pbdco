/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.Code;
import pbdco.modele.Joueur;

/**
 *
 * @author milcenan
 */
public class Inscription extends Organisation{

    public Inscription(Code tournoi){
        super(tournoi);
    }
    
    public void inscrit(String nom, String prenom, String adresse){
        Joueur nouvJoueur;
        nouvJoueur = new Joueur(nom, prenom, adresse);
    }
}
