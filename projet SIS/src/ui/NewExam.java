/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import BD.requetesbd;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import nf.DMR;
import nf.Examen;
import nf.Genre;
import nf.PH;
import nf.TypeExamen;

/**
 *
 * @author Garance
 */
public class NewExam extends javax.swing.JPanel {

    /**
     * Creates new form NewExam
     */
    String cr="";
    DMR dmr;
    DMRPatient dmr_pane;
    JTabbedPane Onglets;
    
    public NewExam(DMRPatient dmr_pane) {
        initComponents();
        
        this.dmr_pane=dmr_pane;
        this.Onglets=dmr_pane.Onglets;
        this.dmr=dmr_pane.dmr;
        
        erreur_ph.setVisible(false);
        save_button.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cr_jdialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        cr_field = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        save_button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ph_field = new javax.swing.JTextField();
        erreur_ph = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        type_field = new javax.swing.JComboBox<>();
        valider_button = new javax.swing.JButton();
        add_cr_button = new javax.swing.JButton();

        cr_jdialog.setResizable(false);
        cr_jdialog.setSize(new java.awt.Dimension(747, 540));

        cr_field.setColumns(20);
        cr_field.setRows(5);
        cr_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cr_fieldKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(cr_field);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(170, 0, 0));
        jLabel10.setText("Compte Rendu :");

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-save-32.png"))); // NOI18N
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cr_jdialogLayout = new javax.swing.GroupLayout(cr_jdialog.getContentPane());
        cr_jdialog.getContentPane().setLayout(cr_jdialogLayout);
        cr_jdialogLayout.setHorizontalGroup(
            cr_jdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cr_jdialogLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel10)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(cr_jdialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cr_jdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cr_jdialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(save_button)))
                .addContainerGap())
        );
        cr_jdialogLayout.setVerticalGroup(
            cr_jdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cr_jdialogLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Source Serif Pro Black", 0, 58)); // NOI18N
        jLabel2.setText("Nouvel Examen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(170, 0, 0));
        jLabel6.setText("Id du PH responsable :");

        erreur_ph.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        erreur_ph.setForeground(new java.awt.Color(149, 46, 46));
        erreur_ph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoInformation.png"))); // NOI18N
        erreur_ph.setText("Cet id ne correspond à aucun PH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(ph_field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(erreur_ph)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ph_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(erreur_ph)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(170, 0, 0));
        jLabel7.setText("Type d'examen :");

        type_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IRM", "RADIOGRAPHIE", "SCANNER" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(type_field, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(type_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        valider_button.setText("Valider");
        valider_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider_buttonActionPerformed(evt);
            }
        });

        add_cr_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add (2).png"))); // NOI18N
        add_cr_button.setText("Ajouter un compte-rendu");
        add_cr_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_cr_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(add_cr_button)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(valider_button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(add_cr_button)
                .addGap(18, 18, 18)
                .addComponent(valider_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void valider_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider_buttonActionPerformed
        // Conditions avant de valider :
        // Tous les champs sont remplis
        // idPH est bien un entier et correspond bien à un PH (à faire)
        // numPacs est bien un entier et correspond bien à un num pacs (à faire)
        
        String idPH= ph_field.getText();
        String type_ex= type_field.getSelectedItem().toString();
        TypeExamen type= TypeExamen.valueOf(type_ex);

        // vérifier que id correspond à un PH
        try {
            int id=Integer.valueOf(idPH);
            erreur_ph.setVisible(false);
        }
        catch(Exception e) {
            erreur_ph.setVisible(true);
        }

        if (!erreur_ph.isVisible()) {
            // à faire : récupérer Date et Heure avec la base de données
            // fonction recherche ph à partir de son id
            
            try {
                int id=Integer.valueOf(idPH);
                DMR ajout_exam=requetesbd.creationExamen(requetesbd.connexionBD(), dmr, Integer.valueOf(idPH), type, 0, cr);
                
                
                //met à jour DMR Patient
                dmr_pane.maj_exam(ajout_exam);

                // ferme l'onglet
                Onglets.remove(this);
            }
            catch (Exception e) {
                erreur_ph.setVisible(true);
            }
        }
    }//GEN-LAST:event_valider_buttonActionPerformed

    
    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        if(!cr_field.getText().equals("")) {
            add_cr_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-pencil-32.png")));
            add_cr_button.setText("Modifier le compte-rendu");
        }
        else {
            add_cr_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add (2).png")));
            add_cr_button.setText("Ajouter un compte-rendu");
        }
        cr=cr_field.getText();
        cr_jdialog.dispose();
    }//GEN-LAST:event_save_buttonActionPerformed

    private void add_cr_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_cr_buttonActionPerformed
        cr_field.setText(cr);
        cr_jdialog.setLocationRelativeTo(null);
        cr_jdialog.setVisible(true);
    }//GEN-LAST:event_add_cr_buttonActionPerformed

    private void cr_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cr_fieldKeyTyped
        save_button.setVisible(true);
    }//GEN-LAST:event_cr_fieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_cr_button;
    private javax.swing.JTextArea cr_field;
    private javax.swing.JDialog cr_jdialog;
    private javax.swing.JLabel erreur_ph;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ph_field;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox<String> type_field;
    private javax.swing.JButton valider_button;
    // End of variables declaration//GEN-END:variables
}
