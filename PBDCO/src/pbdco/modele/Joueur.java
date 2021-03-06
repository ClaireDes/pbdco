
package pbdco.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.BDAccessEx;
import pbdco.Code;


public class Joueur implements Modele{
    private String nom;
    private String prenom;
    private String adresse;
    private Code codeJoueur;
    private Code[] rencontresAJouer;
    private Code[] rencontresJouees;
    int victoiresTournoisCourant;
    FabriqueDeJoueur fabJoueur;
    
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param codeJoueur
     * @param adresse
     * @param victoiresTournoisCourant
     *
     * Constructeur utilisé pour le chargement d'un joueur depuis la base de données à partir d'un code
     * @param rencontresJouees
     * @param fab
     * @param rencontresAJouer
     * 
     * 
     * */
    public Joueur (String nom,
            String prenom,
            Code codeJoueur, 
            String adresse,
            Code[] rencontresJouees, Code[] rencontresAJouer,
            int victoiresTournoisCourant,
            FabriqueDeJoueur fab){
        this.rencontresJouees = new Code[]{};
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse=adresse;
        this.codeJoueur = codeJoueur;
        this.rencontresJouees=rencontresJouees;
        this.rencontresAJouer = rencontresAJouer;
        this.victoiresTournoisCourant=victoiresTournoisCourant;
        this.fabJoueur = fab;
    }
    
    public Code getCode(){
        return this.codeJoueur;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getAdresse(){
        return this.adresse;
    }
    
    public Code[] getRencontresJouees(){
        return this.rencontresJouees;
    }
    
    public Code[] getRencontresAJouer(){
        return this.rencontresAJouer;
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
        this.rencontresJouees = new Code[]{};
        
        this.nom = nom;
        this.prenom =prenom ;
        this.adresse = adresse;
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
    
    public Code getCodeJoueur(){
        return this.codeJoueur;
    }
    
    public String[] getDetails(){
        String[] det = new String[3];
        det[0] = this.nom;
        det[1] = this.prenom;
        det[2] = this.adresse;
        return det;
    }
}
