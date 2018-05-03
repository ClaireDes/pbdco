/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.partie;

/**
 *
 * @author belinbr
 */
public class TourDeJouer {
    
    public void verifyState(Coup coup){
        if(coup.getMisEnEchec()){
            System.out.println("Vous êtes en échec, vous devez protéger votre roi !");
            // A FAIRE
            // INTERDIRE AUTRES MOUVEMENTS QUE CEUX QUI PROTEGENT LE ROI
        }
        else{
            System.out.println("Veuillez jouer svp, le temps défile et vous pouvez encore gagner !");
            // A FAIRE 
            // Lancer le coup classique pour bouger pièces
        }
    }
}
