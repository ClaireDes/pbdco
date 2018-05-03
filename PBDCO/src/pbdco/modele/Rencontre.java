/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import pbdco.BDAccessEx;
import pbdco.Code;

/**
 *
 * @author milcenan
 */
public class Rencontre implements Modele{

    Joueur[] joueurs;
    Code codeTour;
    Code codeRencontre;
    int terminee; //0 = partie pas terminée,1= joueur[0] a gagné, 2= joueur[1]a gagné, 3=personne n'a gagné
    int grille[][];
    FabriqueDeRencontre fabRencontre;
   
    public Rencontre(Joueur[] joueurs,
                        Code codeTour,
                        Code codeRencontre,
                        int terminee, 
                        int grille[][],
                        FabriqueDeRencontre fabRencontre){//pour charger une rencontre depuis la base de données
        
        this.joueurs =  joueurs;
        this.codeRencontre =  codeRencontre;
        this.codeTour = codeTour;
        this.terminee = terminee;
        this.grille = grille;
        this.fabRencontre = fabRencontre;  
    }
    
    public Rencontre(Joueur joueur1, Joueur joueur2, Code codeTour,FabriqueDeRencontre fab) throws BDAccessEx{//pour creer une nouvelle rencontre
   
        this.joueurs[0]=joueur1;
        this.joueurs[1]=joueur2;
        this.codeTour = codeTour;
        this.codeRencontre = new Code(0);
        genereCodeRencontre();
        this.grille= new int[8][8];
        this.terminee = 0;
        this.fabRencontre = fab;
    }
    
    void enregistreNouvelleRencontre(){
        //fabRencontre.fabriqueTransaction("new", this);
    }
    
    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void chargementDepuisBd(int code) {
        
      //fabRencontre.fabriqueTransaction("load",null);
        
    }
    
      
    public void genereCodeRencontre() throws BDAccessEx {//génère un code joueur si le precedent code était 0 un nouveau code joueur est toujours supérieur au plus grand code joueur de la base
        
        if (this.codeRencontre.getValue() == 0){
            this.codeRencontre = fabRencontre.lastCodeBD();
            this.codeRencontre.setValue(this.codeRencontre.getValue()+1);  
        }else{
            System.out.println("tentative de modification du code de la rencontre " + this.codeRencontre.getValue());
        }
    }

    
}
