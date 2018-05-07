package pbdco.vuejeu;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import pbdco.partie.ControleurPartie;

/**
 *
 * @author ravenetq
 */
public class JeuInterface extends JFrame {
    
    JPanel p = new JPanel();
    BoutonCase boutons[] = new BoutonCase[64];
    ControleurPartie controleurPartie;
    
    public static void main(String args[]) {
        //new JeuInterface();
    }
    
    public JeuInterface(ControleurPartie controleur) {
        super("Jeu d'échecs");
        this.controleurPartie = controleur;
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(8,8));
        for(int i=0; i<64; i++) {int ligne = i/8+1;
        int colonne = i%8;
            boutons[i] = new BoutonCase(controleurPartie, i);
            boutons[i].setFont(new Font("Arial", Font.PLAIN, 50));
            if ((ligne+colonne)%2==0) boutons[i].setBackground(Color.GRAY);
            boutons[i].setPosition(i%8+1, 8-(i/8+1)+1);
            p.add(boutons[i]);
        }

        initPlateau();

        add(p);
        setVisible(true);
    }

    private void initPlateau() {
        for (int i = 0; i<64; i++) {
            switch (i) {
                case 0: //TOUR BLANCHE
                    boutons[i].setText(UnicodePieces.TOURB);
                    break;
                case 7:
                    boutons[i].setText(UnicodePieces.TOURB);
                    break;

                case 1: //FOU BLANC
                    boutons[i].setText(UnicodePieces.FOUB);
                    break;
                case 6:
                    boutons[i].setText(UnicodePieces.FOUB);
                    break;

                case 2: //CAVALIER BLANC
                    boutons[i].setText(UnicodePieces.CAVALIERB);
                    break;
                case 5:
                    boutons[i].setText(UnicodePieces.CAVALIERB);
                    break;

                case 3: //ROI BLANC
                    boutons[i].setText(UnicodePieces.ROIB);
                    break;
                case 4: //REINE BLANCHE
                    boutons[i].setText(UnicodePieces.REINEB);
                    break;
            }
            if (7<i && i<16) { boutons[i].setText(UnicodePieces.PIONB); } //PIONS BLANCS
            if (47<i && i<56) { boutons[i].setText(UnicodePieces.PIONN); } //PIONS NOIRS

            switch (i) {
                case 56: //TOUR NOIRE
                    boutons[i].setText(UnicodePieces.TOURN);
                    break;
                case 63:
                    boutons[i].setText(UnicodePieces.TOURN);
                    break;

                case 57: //FOU NOIR
                    boutons[i].setText(UnicodePieces.FOUN);
                    break;
                case 62:
                    boutons[i].setText(UnicodePieces.FOUN);
                    break;

                case 58: //CAVALIER NOIR
                    boutons[i].setText(UnicodePieces.CAVALIERN);
                    break;
                case 61:
                    boutons[i].setText(UnicodePieces.CAVALIERN);
                    break;

                case 59: //ROI NOIR
                    boutons[i].setText(UnicodePieces.ROIN);
                    break;
                case 60: //REINE NOIRE
                    boutons[i].setText(UnicodePieces.REINEN);
                    break;
            }

        }
    }
    
}
