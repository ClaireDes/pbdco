/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuinterface;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 *
 * @author ravenetq
 */
public class JeuInterface extends JFrame {
    
    JPanel p = new JPanel();
    BoutonCase boutons[] = new BoutonCase[64];
    
    public static void main(String args[]) {
        new JeuInterface();
    }
    
    public JeuInterface() {
        super("Jeu d'échecs");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(8,8));
        for(int i=0; i<64; i++) {
            boutons[i] = new BoutonCase();
            p.add(boutons[i]);
        }
        
        setVisible(true);
    }
    
}
