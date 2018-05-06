package pbdco.partie;

import pbdco.Code;
import pbdco.modele.Joueur;
import pbdco.vuejeu.JeuInterface;
import pbdco.vuejeu.VueJoueur;

/**
 * Created by ravenetq on 4/23/18.
 */
public class ControleurPartie {

    private Joueur adversaire;
    private Joueur joueur;

    private EtatsPartie etat;
    
    public void loadPositions(){
        Position[] pos = new Position[64];
        // creation de la table des positions
        for (int lig=0; lig<8;lig++){
            for (int col=0;col<8;col++){
                if(lig < 2 || lig >5){ //cases occupées initialement
                    pos[lig+col].setPosition(lig+1, col+1);
                    pos[lig+col].setState(true);
                }
                else { //cases libres
                    pos[lig+col].setPosition(lig+1, col+1);
                    pos[lig+col].setState(true);
                }
            }
        }      
    }
    
    public void procedureAbandon() {
        //Fait recommencer le joueur qui utilise cette vue : "joueur"
    }

    public void procedureRecommencer() {
        //Fait recommencer le joueur qui utilise cette vue : "joueur"
    }

    public void coupSuivant() { //Pour lire une partie
        //Joue le coup suivant de la partie en lecture
    }

    protected void informe() {
        //Informe ses observateurs, comme la vue
    }
    
    public static void main(String[] args) {
        ControleurPartie controleur = new ControleurPartie("Joueur 1", "Joueur 2", new Code(123456789), EtatsPartie.JOUER_RENCONTRE);
    }
    
    public ControleurPartie(String infoJoueur1, String infoJoueur2, Code codeRencontre, EtatsPartie affronterOuRejouer) {
        new JeuInterface().setVisible(true);
        etat = affronterOuRejouer;
        
        if(etat = EtatsPartie.REJOUER_PARTIE) System.out.println("Ce cas n'est pas traité");
        else if (etat = EtatsPartie.JOUER_RENCONTRE) {
            new VueJoueur(infoJoueur1, infoJoueur2).setVisible(true);
            etat = EtatsPartie.BLANC_JOUE;
        }
    }
}
