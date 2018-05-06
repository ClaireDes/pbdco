package pbdco.vueorga;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAccueil extends JFrame {
    private JButton creerTournoisButton;
    private JButton continuerTournoisButton;
    private JPanel panelMain;

    public VueAccueil(VuesOrga ordonnanceur) {
        super("Organisation du tournois - Accueil");
    setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        creerTournoisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ordonnanceur.setFrame(new VueCreationTournois(ordonnanceur));
                System.out.println("Action performed !");

            }
        });

        continuerTournoisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ordonnanceur.setFrame(new VueQualifications(ordonnanceur));
            }
        });
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Orga Tournois");
        //frame.setContentPane(new VueAccueil().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
}
