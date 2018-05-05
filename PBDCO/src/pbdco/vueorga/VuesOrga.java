package pbdco.vueorga;

import javax.swing.*;

public class VuesOrga extends JFrame {

    private JFrame frame;

    public static void main(String[] args) {
        JFrame frame = new VuesOrga();
    }

    public VuesOrga() {
        this.frame = new VueAccueilOrganisation();
    }

    public void setFrame(JFrame view) {
        frame = view;
    }
}
