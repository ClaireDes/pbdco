/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.tournois;

import pbdco.BDAccessEx;
import pbdco.Code;
import pbdco.modele.FabriqueDeJoueur;
import pbdco.modele.Joueur;

/**
 *
 * @author milcenan
 */
public class Inscription extends Organisation{
    
    public Inscription(boolean bool) throws BDAccessEx{
        super(bool);
    }
    
    public void inscrit(String nom, String prenom, String adresse) throws BDAccessEx{
        Joueur nouvJoueur;
        nouvJoueur = new Joueur(nom, prenom, adresse, this.getFabriqueJoueur());
        this.setNbrParticipants(this.getNbrParticipants()+1);
    }
}
