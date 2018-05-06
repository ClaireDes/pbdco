package pbdco.vuejeu;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import pbdco.partie.ControleurPartie;


/**
 *
 * @author ravenetq
 */
public class BoutonCase extends JButton implements ActionListener {
    ImageIcon roiN, roiB, reineN, reineB; //Compléter
    int posX, posY;
    ControleurPartie controleurPartie;
    
    public BoutonCase(ControleurPartie controleur) {
        addActionListener(this);
        this.controleurPartie = controleur;
    }
    
    public BoutonCase(int posX, int posY) {
        addActionListener(this);
        this.posX = posX;
        this.posY = posY;
    }
    
    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pushed : "+ posX+" "+ posY);
        //controleurPartie.pieceABouger();
        //TODO
    }
}
