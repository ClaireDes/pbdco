
package pbdco.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.Code;


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
     *
     * Constructeur utilisé pour le chargement d'un joueur depuis la base de données à partir d'un code
     * 
     * 
     * */
    public Joueur (String nom,
            String prenom,
            Code codeJoueur, 
            String adresse,
            List rencontresCourantes,
            int victoiresTournoisCourant,
            FabriqueDeJoueur fab){
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse=adresse;
        this.codeJoueur = codeJoueur;
        this.rencontresCourantes=rencontresCourantes;
        this.victoiresTournoisCourant=victoiresTournoisCourant;
        this.fabJoueur = fab;
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
                String prenom, String adresse, FabriqueDeJoueur fab) throws BDAccessEx{
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse = adresse;
        this.rencontresCourantes = new ArrayList();
        this.victoiresTournoisCourant = 0;

        this.fabJoueur = fab;//
        this.codeJoueur= new Code(fab.lastCodeBD().getValue()+1);//
        /*try {
            genereCodeJoueur();
        } catch (BDAccessEx ex) {
            System.err.println("erreur lors de la génération du code joueur de "+ this.nom + this.prenom + ex.getMessage());
        }*/
        enregistreNouveauJoueur();
        //this.fabJoueur.fabriqueTransaction("new",this);
    }
    
    

    public void majBD() {
        try {
            fabJoueur.MAJBD(this);
        } catch (BDAccessEx ex) {
            System.err.println("Erreur lors de la mise à jour de la BD pour le joueur numero " + this.codeJoueur.getValue());
        }
    }

    private void genereCodeJoueur() throws BDAccessEx {//génère un code joueur si le precedent code était 0 un nouveau code joueur est toujours supérieur au plus grand code joueur de la base
        
        if (this.codeJoueur.getValue() == 0){
            this.codeJoueur = fabJoueur.lastCodeBD();
            this.codeJoueur.setValue(this.codeJoueur.getValue()+1);  
        }else{
            System.out.println("tentative de modification du code du joueur " + this.codeJoueur.getValue());
        }
    }

    
    public void enregistreNouveauJoueur() throws BDAccessEx{
      
            fabJoueur.creerDansBD(this);
       
            //System.err.println("erreur lors de la création dans la BD de "+ this.nom + this.prenom);
        
    }
}
