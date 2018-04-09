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
    boolean terminee;
    int grille[][];
   
    public Rencontre(int code){
        chargementDepuisBd(code);
    }
    
    public Rencontre(Joueur joueur1, Joueur joueur2){
   
        this.joueurs[0]=joueur1;
        this.joueurs[1]=joueur2;
        this.code = genereCodeRencontre();
        this.grille= new int[8][8];
        this.terminee = false;
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
