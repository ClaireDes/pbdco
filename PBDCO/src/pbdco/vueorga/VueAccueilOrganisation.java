/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.vueorga;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pbdco.BDAccessEx;
import pbdco.tournois.*;

/**
 *
 * @author livingstonehgs
 */
public class VueAccueilOrganisation extends javax.swing.JFrame {

    /**
     * Creates new form VueAccueilOrganisation
     */


    public VueAccueilOrganisation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        continuerTournois = new javax.swing.JButton();
        creerTournois = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        continuerTournois.setText("Continuer le tournois");
        continuerTournois.setActionCommand("continuerTournois");
        continuerTournois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuerTournoisActionPerformed(evt);
            }
        });

        creerTournois.setText("Créer un tournois");
        creerTournois.setActionCommand("creerTournois");
        creerTournois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerTournoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(continuerTournois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creerTournois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(continuerTournois)
                .addGap(18, 18, 18)
                .addComponent(creerTournois)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continuerTournoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuerTournoisActionPerformed
        
        dispose();
        try {
            new VueMatchsJoueur().setVisible(true);
        } catch (BDAccessEx ex) {
            Logger.getLogger(VueAccueilOrganisation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_continuerTournoisActionPerformed

    private void creerTournoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerTournoisActionPerformed
        try {
            Tournoi tourn = new Tournoi();
            tourn.creerTournoi();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new VueCreation().setVisible(true);
                    } catch (BDAccessEx ex) {
                        Logger.getLogger(VueCreation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (BDAccessEx ex) {
            Logger.getLogger(VueAccueilOrganisation.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Tournoi tourn = new Tournoi();
        try {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VueCreation().setVisible(true);
                } catch (BDAccessEx ex) {
                    Logger.getLogger(VueCreation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            tourn.creerTournoi();

        } catch (BDAccessEx ex) {
            Logger.getLogger(VueAccueilOrganisation.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        dispose();
    }//GEN-LAST:event_creerTournoisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueAccueilOrganisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueAccueilOrganisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueAccueilOrganisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueAccueilOrganisation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueAccueilOrganisation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuerTournois;
    private javax.swing.JButton creerTournois;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
