/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pbdco;

import java.util.logging.Level;
import java.util.logging.Logger;
import pbdco.modele.FabriqueDeJoueur;
import pbdco.modele.Joueur;

/**
 *
 * @author milcenan
 */
public class PBDCO {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //test création joueur + déclaration dans la BD
        FabriqueDeJoueur fabJoueur = new FabriqueDeJoueur();
        try {
            Joueur J = new Joueur("Jean","Michel","jean.michel@gmail.com",fabJoueur);
            
            
            //test création controleur
            
            
            
            
            //test communication vue / controlleur
            
            
            
            
            
            //test communication vue / modèle
        } catch (BDAccessEx ex) {
            Logger.getLogger(PBDCO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
}
    
}
