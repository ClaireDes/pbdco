/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.util.ArrayList;
import java.util.List;
import pbdco.Code;

/**
 *
 * @author milcenan
 */
public class Joueur implements Modele{
    String nom;
    String prenom;
    String adresse;
    Code codeJoueur;
    List rencontresCourantes;
    int victoiresTournoisCourant;
    FabriqueDeJoueur fabJoueur;
    
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param rencontresCourantes
     * @param victoiresTournoisCourant
     * @param defaitesTournoisCourant 
     *
     * Constructeur utilisé pour le chargement d'un joueur depuis la base de données à partir d'un code
     * 
     * 
     * */
    public Joueur (String nom,
            String prenom,
            Code codeJoueur, String adresse,
            List rencontresCourantes,
            int victoiresTournoisCourant ){
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse=adresse;
        this.codeJoueur = codeJoueur;
        this.rencontresCourantes=rencontresCourantes;
        this.victoiresTournoisCourant=victoiresTournoisCourant;
        this.fabJoueur = new FabriqueDeJoueur();
    }
    

    /**
     * 
     * @param nom
     * @param prenom 
     * @param adresse
     Constructeur utilisé pour la création d'un nouveau joueur, l'ensemble des parties en cours est vide 
     * Aucune partie n'a encore été jouée
     
     */
    public Joueur (String nom,
                String prenom, String adresse){
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse = adresse;
        this.rencontresCourantes = new ArrayList();
        this.victoiresTournoisCourant = 0;

        this.fabJoueur = new FabriqueDeJoueur();//
        this.codeJoueur=new Code(0);//
        genereCodeJoueur();//genere code joueur doit etre aappelé après la création de la fabrique
    }
    
    

    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //fabJoueur.fabriqueTransaction("");
    }

    public void chargementDepuisBd(int code) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void genereCodeJoueur(){

        //fabJoueur.fabriqueTransaction("lastCodeJoueur",this);
        this.codeJoueur.setValue(this.codeJoueur.getValue()+1);
        
    }
    void setCodeJoueur(int i){
        this.codeJoueur.setValue(i);
    }
    

    public void enregistreNouveauJoueur(){
        fabJoueur.fabriqueTransaction("new", this);
    }
    
}
