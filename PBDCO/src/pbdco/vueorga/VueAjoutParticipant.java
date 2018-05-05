package vueorga;

import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjoutParticipant extends JFrame {
    private JPanel panelMain;
    private JLabel nameLabel;
    private JLabel prenomLabel;
    private JLabel adresseLabel;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldAdresse;
    private JButton termineButton;
    private JButton annulerButton;

    public VueAjoutParticipant(VuesOrga ordonnanceur) {
        super("Organisation du tournois - Ajouter un participant");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        termineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("C'est cliqué !");
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ordonnanceur.setFrame(new VueCreationTournois(ordonnanceur));
            }
        });
    }
}
