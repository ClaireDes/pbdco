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
public class Rencontre implements Modele{

    Joueur[] joueurs;
    int code;
    int terminee; //0 = partie pas terminée,1= joueur[0] a gagné, 2= joueur[1]a gagné, 3=personne n'a gagné
    int grille[][];
    FabriqueDeRencontre fabRencontre;
   
    public Rencontre(int code){//pour charger une rencontre depuis la base de données
        fabRencontre = new FabriqueDeRencontre();
        chargementDepuisBd(code);
        
    }
    
    public Rencontre(Joueur joueur1, Joueur joueur2){//pour creer une nouvelle rencontre
   
        this.joueurs[0]=joueur1;
        this.joueurs[1]=joueur2;
        this.code = genereCodeRencontre();
        this.grille= new int[8][8];
        this.terminee = 0;
        this.fabRencontre = new FabriqueDeRencontre();
        
    }
    
    void enregistreNouvelleRencontre(){
           fabRencontre.fabriqueTransaction("new", this);
    }
    
    private int genereCodeRencontre(){
        
       // Genere un nouveau code supeireur au dernier enrgistré dans la base de données
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return getLastCodeRencontre() + 1;
    }
    
    
    
    @Override
    public void majBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void chargementDepuisBd(int code) {
        
        fabRencontre.fabriqueTransaction("load",null);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
