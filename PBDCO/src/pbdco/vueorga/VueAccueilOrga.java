/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbdco.vueorga;

import javax.swing.JFrame;

/**
 *
 * @author livingstonehgs
 */
public class VueAccueilOrga extends javax.swing.JFrame {

    /**
     * Creates new form VueAccueilOrga
     */
    VuesOrga ordonnanceur;
    
    public VueAccueilOrga(VuesOrga ordonnanceur) {
        super("Organisation du tournois - Accueil");
        initComponents();
        //setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //pack();
        setVisible(true);
        this.ordonnanceur = ordonnanceur;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        creerTournois = new javax.swing.JButton();
        continuerTournois = new javax.swing.JButton();

        creerTournois.setText("Créer Tournois");
        creerTournois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerTournoisActionPerformed(evt);
            }
        });

        continuerTournois.setText("Continuer Tournois");
        continuerTournois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuerTournoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(continuerTournois)
                .addGap(18, 18, 18)
                .addComponent(creerTournois)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creerTournois)
                    .addComponent(continuerTournois))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void creerTournoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerTournoisActionPerformed
        dispose();
        ordonnanceur.setFrame(new VueCreationTournois(ordonnanceur));
    }//GEN-LAST:event_creerTournoisActionPerformed

    private void continuerTournoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuerTournoisActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_continuerTournoisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuerTournois;
    private javax.swing.JButton creerTournois;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
