/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Date;
import javax.swing.JFrame;
import nf.DMR;
import nf.Examen;
import nf.Genre;
import nf.PH;
import nf.TypeExamen;

/**
 *
 * @author Garance
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil() {
        //initialiser les composants
        initComponents();
        
        //mettre la fenêtre en plein écran
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_jdialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        error_panel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Onglets = new javax.swing.JTabbedPane();
        Fond = new javax.swing.JPanel();
        top_Pane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        search_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search_button = new javax.swing.JButton();
        logout_panel = new javax.swing.JPanel();
        logout_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        newdmr_panel = new javax.swing.JPanel();
        newdmr_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        search_jdialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        search_jdialog.setTitle("Rechercher un DMR");
        search_jdialog.setAlwaysOnTop(true);
        search_jdialog.setResizable(false);
        search_jdialog.setSize(new java.awt.Dimension(524, 190));

        jLabel9.setText("Rentrer un n° d'id :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 150, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoAttention.png"))); // NOI18N
        jLabel10.setText("Identifiant incorrect");

        javax.swing.GroupLayout error_panelLayout = new javax.swing.GroupLayout(error_panel);
        error_panel.setLayout(error_panelLayout);
        error_panelLayout.setHorizontalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_panelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        error_panelLayout.setVerticalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(error_panelLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout search_jdialogLayout = new javax.swing.GroupLayout(search_jdialog.getContentPane());
        search_jdialog.getContentPane().setLayout(search_jdialogLayout);
        search_jdialogLayout.setHorizontalGroup(
            search_jdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_jdialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(error_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(search_jdialogLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        search_jdialogLayout.setVerticalGroup(
            search_jdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_jdialogLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1650, 1080));

        top_Pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Source Serif Pro Black", 0, 58)); // NOI18N
        jLabel2.setText("Bienvenue X");
        top_Pane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 531, 66));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (encore).png"))); // NOI18N
        top_Pane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 0, 580, 170));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (encore).png"))); // NOI18N
        top_Pane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 170));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (encore).png"))); // NOI18N
        top_Pane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 580, 170));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo (encore).png"))); // NOI18N
        top_Pane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 580, 170));
        top_Pane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rechercher un DMR :");
        jLabel1.setToolTipText("");

        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search-32.png"))); // NOI18N
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout search_panelLayout = new javax.swing.GroupLayout(search_panel);
        search_panel.setLayout(search_panelLayout);
        search_panelLayout.setHorizontalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_button)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        search_panelLayout.setVerticalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        logout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-log-out-32.png"))); // NOI18N
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Se déconnecter :");

        javax.swing.GroupLayout logout_panelLayout = new javax.swing.GroupLayout(logout_panel);
        logout_panel.setLayout(logout_panelLayout);
        logout_panelLayout.setHorizontalGroup(
            logout_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logout_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_button)
                    .addComponent(jLabel3))
                .addContainerGap(822, Short.MAX_VALUE))
        );
        logout_panelLayout.setVerticalGroup(
            logout_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logout_panelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        newdmr_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-pencil-32.png"))); // NOI18N
        newdmr_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newdmr_buttonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Créer un nouveau DMR :");

        javax.swing.GroupLayout newdmr_panelLayout = new javax.swing.GroupLayout(newdmr_panel);
        newdmr_panel.setLayout(newdmr_panelLayout);
        newdmr_panelLayout.setHorizontalGroup(
            newdmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newdmr_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newdmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newdmr_button)
                    .addComponent(jLabel8))
                .addContainerGap(822, Short.MAX_VALUE))
        );
        newdmr_panelLayout.setVerticalGroup(
            newdmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newdmr_panelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newdmr_button, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout FondLayout = new javax.swing.GroupLayout(Fond);
        Fond.setLayout(FondLayout);
        FondLayout.setHorizontalGroup(
            FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FondLayout.createSequentialGroup()
                        .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newdmr_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logout_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FondLayout.setVerticalGroup(
            FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondLayout.createSequentialGroup()
                .addComponent(top_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newdmr_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logout_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(433, Short.MAX_VALUE))))
        );

        Onglets.addTab("             Accueil             ", Fond);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Onglets)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Onglets)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // récupère infos du champs recherche & ouvre un nouvel onglet
        //open_dmr();
        search_jdialog.setLocationRelativeTo(null);
        jLabel10.setVisible(false);
        jTextField1.setText("");
        search_jdialog.setVisible(true);
        jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_search_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id=jTextField1.getText();
        if (id.equals("")) {
            jTextField1.setText("");
            jTextField1.requestFocusInWindow();
            jLabel10.setVisible(true);
        }
        else {
            search_jdialog.setVisible(false);
            
            // il faudra chercher DMR avec le bon n° id
            DMR dmr_test= new DMR("Thoviste", "Garance", new Date(2001,4,4), Genre.F, 11804526);
            PH ph_test= new PH("Deblouze", "Agathe", 222, "mdp", 1);
            
            Examen ex1 = new Examen(11804526, new Date(2022,1,9), ph_test, TypeExamen.IRM);
            Examen ex2 = new Examen(11804526, new Date(2022,0,3), ph_test, TypeExamen.SCANNER);
            
            dmr_test.ajouterExamen(ex1);
            dmr_test.ajouterExamen(ex2);
            
            open_dmr(dmr_test);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newdmr_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newdmr_buttonActionPerformed
        // Ouvre un nouvel onglet permettant de créer un DMR
        // A faire : vérifier format date de naissance
        // Vérifier que tous les champs ont été remplis avant de valider sinon message d'erreur
        
        javax.swing.JPanel dmrpanel=new NewDMR(Onglets);
        
        // ajoute un nouvel onglet
        Onglets.addTab("    Création DMR    ",dmrpanel);
        Onglets.setSelectedComponent(dmrpanel);
        
        // création d'un bouton pour fermer l'onglet
        CloseButton close_button = new CloseButton(Onglets);
        
        // ajout du bouton
        Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);
    }//GEN-LAST:event_newdmr_buttonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        AccueilConnexion ac = new AccueilConnexion();
        ac.setVisible(true);
        dispose();
    }//GEN-LAST:event_logout_buttonActionPerformed
  
    private void open_dmr(DMR dmr) {
        // Ouvre un nouvel onglet avec le DMR correspondant au n° d'id rentré dans le champ de recherche
        // A faire une fois lien nf établi :
        // vérifier si n° id est correct
        // si oui, initialiser les composants pour qu'ils correspondent au patient
        
        javax.swing.JPanel dmrpanel=new DMRPatient(dmr);
        
        // ajoute un nouvel onglet
        Onglets.addTab("             DMR         ",dmrpanel);
        Onglets.setSelectedComponent(dmrpanel);
        
        // création d'un bouton pour fermer l'onglet
        CloseButton close_button = new CloseButton(Onglets);
        
        // ajout du bouton
        Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);        
    }
    
    
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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fond;
    private javax.swing.JTabbedPane Onglets;
    private javax.swing.JPanel error_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logout_button;
    private javax.swing.JPanel logout_panel;
    private javax.swing.JButton newdmr_button;
    private javax.swing.JPanel newdmr_panel;
    private javax.swing.JButton search_button;
    private javax.swing.JDialog search_jdialog;
    private javax.swing.JPanel search_panel;
    private javax.swing.JPanel top_Pane;
    // End of variables declaration//GEN-END:variables
}
