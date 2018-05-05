package vueorga;

import javax.swing.*;

public class VuesOrga extends JFrame {

    private JFrame frame;

    public static void main(String[] args) {
        JFrame frame = new VuesOrga();
    }

    public VuesOrga() {
        this.frame = new VueAccueil(this);
    }

    public void setFrame(JFrame view) {
        frame = view;
    }
}
