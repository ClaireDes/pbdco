package pbdco.vueorga;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueCreationTournois extends JFrame {
    private JPanel panelMain;
    private JButton ajouterUnParticipantButton;
    private JButton commencerLeTournoisButton;
    private JLabel nbParticipants;

    public VueCreationTournois(VuesOrga ordonnanceur) {
        super("Organisation du tournois - Créer un tournois");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        ajouterUnParticipantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ordonnanceur.setFrame(new VueAjoutParticipant(ordonnanceur));
            }
        });
        commencerLeTournoisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ordonnanceur.setFrame(new VueQualifications(ordonnanceur));
            }
        });
    }
}
