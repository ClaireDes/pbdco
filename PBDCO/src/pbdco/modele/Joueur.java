/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import pbdco.Code;

/**
 *
 * @author milcenan
 */
public class Joueur implements Modele{
    String nom;
    String prenom;
    Code codeJoueur;
    int[] rencontresCourantes;
    int victoiresTournoisCourant;
    int defaitesTournoisCourant;
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
            Code codeJoueur,
            int[] rencontresCourantes,
            int victoiresTournoisCourant,
            int defaitesTournoisCourant){
        
        this.nom = nom;
        this.prenom =prenom ;
        this.codeJoueur = codeJoueur;
        this.rencontresCourantes=rencontresCourantes;
        this.victoiresTournoisCourant=victoiresTournoisCourant;
        this.defaitesTournoisCourant=defaitesTournoisCourant;
        this.fabJoueur = new FabriqueDeJoueur();
 
       
    }
    

    /**
     * 
     * @param nom
     * @param prenom 
     Constructeur utilisé pour la création d'un nouveau joueur, l'ensemble des parties en cours est vide 
     * Aucune partie n'a encore été jouée
     
     */
    public Joueur (String nom,
                String prenom){
        
        this.nom = nom;
        this.prenom =prenom ;
        
  
        this.victoiresTournoisCourant = 0;
        this.defaitesTournoisCourant = 0;
        this.fabJoueur = new FabriqueDeJoueur();//
        this.codeJoueur=new Code(0);//
        genereCodeJoueur();//genere code joueur doit etre aappelé après la création de la fabrique
    }

    @Override
    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //fabJoueur.fabriqueTransaction("");
    }

    @Override
    public void chargementDepuisBd(int code) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void genereCodeJoueur(){

        fabJoueur.fabriqueTransaction("lastCodeJoueur",this);
        this.codeJoueur.setValue(this.codeJoueur.getValue()+1);
        
    }
    void setCodeJoueur(int i){
        this.codeJoueur.setValue(i);
    }
    
    public void enregistreNouveauJoueur(){
        fabJoueur.fabriqueTransaction("new", this);
    }
    
}
