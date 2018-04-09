/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco;

/**
 *
 * @author milcenan
 */
public class Joueur implements Modele{
    String nom;
    String prenom;
    int[] rencontresCourantes;
    int victoiresTournoisCourant;
    int defaitesTournoisCourant;
    
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param rencontresCourantes
     * @param victoiresTournoisCourant
     * @param defaitesTournoisCourant 
     *
     * Constructeur utilisé pour le chargement d'un joueur depuis la base de données
     * 
     * 
     * */
    public Joueur (String nom,
            String prenom,
            int[] rencontresCourantes,
            int victoiresTournoisCourant,
            int defaitesTournoisCourant){
        
        this.nom = nom;
        this.prenom =prenom ;
        this.rencontresCourantes=rencontresCourantes;
        this.victoiresTournoisCourant=victoiresTournoisCourant;
        this.defaitesTournoisCourant=defaitesTournoisCourant;
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
    }

    @Override
    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void chargementDepuisBd(int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
