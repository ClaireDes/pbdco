package pbdco.partie;

/**
 * Created by ravenetq on 4/23/18.
 */
public class EtatRejouer extends EtatPartie {

    //On est dans cet état lorsque l'on cherche à afficher une partie déjà jouée


    @Override
    public EtatPartie etatSuivant() {
        return new EtatBlancJoue();
    }
}
