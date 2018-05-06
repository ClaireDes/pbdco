package pbdco.vueorga;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueQualifications extends JFrame {
    private JLabel nameLabel;
    private JList list1;
    private JList list2;
    private JButton affronterButton;
    private JButton revoirLaPartieButton;
    private JPanel panelMain;

    public VueQualifications(VuesOrga ordonnanceur) {
        super("Organisation du tournois - Créer un tournois");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

        affronterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Vous allez affronter ce joueur !");
            }
        });
        revoirLaPartieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Vous allez revoir cette partie!");

            }
        });
    }
}
