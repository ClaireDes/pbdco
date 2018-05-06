package pbdco.partie;

import pbdco.modele.Joueur;

/**
 * Created by ravenetq on 4/23/18.
 */
public class ControleurPartie {

    private Joueur adversaire;
    private Joueur joueur;

    private EtatPartie etat;

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
        
    }
}
