/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.modele;

import sun.awt.X11.XConstants;

/**
 *
 * @author milcenan
 */
public class FabriqueDeJoueur /*extends FabriqueTransaction*/{

    public  void fabriqueTransaction(String operation,Joueur joueur){
        switch (operation) {
            case "new"://création d'un joueur (uniquement dans inscription)
                    System.out.println("enregistrement d'un nouveau joueur dans la base");
                break;
            case "nom"://modification du nom d'un joueur (existant)
                    System.out.println("modification du nom d'un joueur");
                break;
            case "prenom"://modification du prénom d'un joueur (existant)
                    System.out.println("modificatio du prenom d'un joueur");
                break;     
            case "update":// mise à jour du joueur avec les données dans joueur actuellement
                    System.out.println("modification d'un joueur ");
                break;
            case "lastCodeJoueur"://trouver le dernier code joueur utilisé(pour en creer un nouveau)
                    System.out.println("Recherche du dernier code Joueur");
                    int lastCode = 0;
                    //#########acces au dernier code joueur utilisé
                    
                    joueur.setCodeJoueur(lastCode);
                break;
            case "load": //charge un joueur depuis un code joueur
                    System.out.println("chargement d'un joueur depuis la base de donnees");
                break;                
        }
        
      
    };
    
    
    public  void fabriqueRequete(){
        throw new UnsupportedOperationException("Not supported yet.");
    };    


    
}
