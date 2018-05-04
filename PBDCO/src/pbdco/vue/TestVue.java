package pbdco.vue;

/**
 * Created by ravenetq on 4/23/18.
 */
public class TestVue {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                VuePartie cb =
                        new VuePartie();

                JFrame f = new JFrame("ChessChamp");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

}
