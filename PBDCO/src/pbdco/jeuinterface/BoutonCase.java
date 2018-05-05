/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuinterface;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author ravenetq
 */
public class BoutonCase extends JButton implements ActionListener {
    ImageIcon roiN, roiB, reineN, reineB; //Compléter
    
    public BoutonCase() {
        //ImageIcon icon = new ImageIcon(this.getClass().getResource("chessicons.png"));
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed !!");
    }
}
