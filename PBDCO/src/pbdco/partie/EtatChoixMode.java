package pbdco.partie;

/**
 * Created by ravenetq on 4/23/18.
 */
public class EtatChoixMode extends EtatPartie {
    public EtatChoixMode() {

    }

    @Override
    public EtatPartie etatSuivant() {
        return new EtatJoue();
    }
}
