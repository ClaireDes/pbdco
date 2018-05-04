/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuinterface;
import javax.swing.JButton;
import javax.swing.ImageIcon

/**
 *
 * @author ravenetq
 */
public class BoutonCase extends JButton{
    ImageIcon roiN, roiB, reineN, reineB; //Compléter
    
    public BoutonCase() {
        X = new ImageIcon(this.getClass().getResource("roiN.png"))
    }
}
