/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import java.util.Map;
import java.util.Random;
import pbdco.BDAccessEx;
import pbdco.Code;

/**
 *
 * @author milcenan
 */
public class Rencontre implements Modele{

    Joueur[] joueurs;
    String codeTour;
    Code codeRencontre;
    Code codeJoueur1,codeJoueur2;
    int terminee; //0 = partie pas terminée,1= joueur[0] a gagné, 2= joueur[1]a gagné, 3=personne n'a gagné
    int blanc ; // 1 => joueur 1 blanc, 2 => joueur2 blanc
    int grille[][];
    FabriqueDeRencontre fabRencontre;
   
    
    /**
     * Constructeur de  Rencontre à partir d'un code rencontre : 
     * il renvoie une nouvelle rencontre chargée à partir de la base de données;
     * les codes joueurs sont à jour , blanc et terminé aussi 
     *  il faut ensuite lier l'instance de Joueur1 et de Joueur2 qui ont les bons codeJoueur
     * dans le tableau Joueurs[]
     * 
     * Dans l'organisation, il existera une liste de tous les joueurs présents dans la BD .
     * De telle sorte qu'il n'existe qu'une instance de Joueur par code joueur afin d'eviter des erreurs de mise à jour.
     * 
     * Il faut simplement passer cette liste en parametre
     * 
     * La gestion de la grille n'est pas gérée. 
     * Il est inutile d'utiliser une Map pour les pièces puisque les pièces ne peuvent exister que sur une seule partie à la fois
     * 
     * @param codeRencontre
     * @throws BDAccessEx 
     */
    public Rencontre( Code codeRencontre, Map<Integer,Joueur> listeDesJoueurs) throws BDAccessEx{//pour charger une rencontre depuis la base de données
        this.fabRencontre = new FabriqueDeRencontre();
        this.fabRencontre.LoadFromBD(this);
        this.joueurs[0]=listeDesJoueurs.get(codeJoueur1.getValue());
        this.joueurs[2]=listeDesJoueurs.get(codeJoueur2.getValue());
        
    }
    
    public Rencontre(Joueur joueur1, Joueur joueur2,String codeTour) throws BDAccessEx{//pour creer une nouvelle rencontre
        this.fabRencontre = new FabriqueDeRencontre();
        this.joueurs[0]=joueur1;
        this.joueurs[1]=joueur2;
        this.codeJoueur1=this.joueurs[0].codeJoueur;
        this.codeJoueur2=this.joueurs[1].codeJoueur;
        this.codeTour = codeTour;
        this.codeRencontre = new Code(0);
        genereCodeRencontre();
        this.grille= new int[8][8];
        this.terminee = 0;
       choisitNoirBlanc();
       enregistreNouvelleRencontre();
    }
    
    void enregistreNouvelleRencontre() throws BDAccessEx{
       fabRencontre.creerDansBD(this);
    }
    
    public void choisitNoirBlanc(){
        
               Random rand = new Random();
             
                    // Décision Blanc/Noir
            if(rand.nextInt(10000)%2==0){
                this.blanc=1;
            }else{
                this.blanc=2;
            }
    }
    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
 * 
 * @param code
 * @throws BDAccessEx 
 */
    public void chargementDepuisBd(int code) throws BDAccessEx {
        fabRencontre.LoadFromBD(this);
    }
    
      
    public void genereCodeRencontre() throws BDAccessEx {//génère un code joueur si le precedent code était 0 un nouveau code joueur est toujours supérieur au plus grand code joueur de la base
        
        if (this.codeRencontre.getValue() == 0){
            this.codeRencontre = this.fabRencontre.lastCodeBD();
            this.codeRencontre.setValue(this.codeRencontre.getValue()+1);  
        }else{
            System.out.println("tentative de modification du code de la rencontre " + this.codeRencontre.getValue());
        }
    }

    
}
