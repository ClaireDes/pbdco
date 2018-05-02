package pbdco.partie;

/**
 * Created by ravenetq on 4/23/18.
 */
public class EtatJoue extends EtatPartie {
    @Override
    public EtatPartie etatSuivant() {
        return new EtatPartieTerminee();
    }
}
