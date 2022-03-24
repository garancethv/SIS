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
import nf.Personnel;
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
    Personnel user;
    
    /**
     * Constructeur de la classe NewExam (panel permettant la création d'un nouvel examen).
     * S'ouvre à partir de DMRPatient.
     * @param dmr_pane : le JTabbedPane Onglets
     * @param user : l'utilisateur connecté (si c'est un PH, le champ id prend pour valeur son identifiant mais peut être modifié)
     */
    public NewExam(DMRPatient dmr_pane, Personnel user) {
        initComponents();
        
        this.user=user;
        
        this.dmr_pane=dmr_pane;
        this.Onglets=dmr_pane.Onglets;
        this.dmr=dmr_pane.dmr;
        
        erreur_ph.setVisible(false);
        save_button.setVisible(false);
        loading.setVisible(false);
        
        // Restrictions :
        // si PH : idPH déjà renseigné
        // si manip radio : ne peut pas rajouter CR
        
        if (user.getClass().equals(nf.PH.class) || user.getClass().equals(nf.Interne.class)) {
            ph_field.setText(String.valueOf(user.getId()));
        }
        else {
            add_cr_button.setVisible(false);
        }
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
        jPanel2 = new javax.swing.JPanel();
        valider_button = new javax.swing.JButton();
        add_cr_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ph_field = new javax.swing.JTextField();
        erreur_ph = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        type_field = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        loading = new javax.swing.JLabel();

        cr_jdialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        cr_jdialog.setModal(true);
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

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(190, 236, 254));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 191, 252), 2, true));

        valider_button.setBackground(new java.awt.Color(255, 255, 255));
        valider_button.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        valider_button.setText("Valider");
        valider_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 191, 252), 2));
        valider_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                valider_buttonMousePressed(evt);
            }
        });
        valider_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider_buttonActionPerformed(evt);
            }
        });

        add_cr_button.setBackground(new java.awt.Color(255, 255, 255));
        add_cr_button.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        add_cr_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add (2).png"))); // NOI18N
        add_cr_button.setText("Ajouter un compte-rendu");
        add_cr_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_cr_buttonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("ID du PH responsable :");

        ph_field.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ph_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ph_fieldMouseExited(evt);
            }
        });

        erreur_ph.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        erreur_ph.setForeground(new java.awt.Color(149, 46, 46));
        erreur_ph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoInformation.png"))); // NOI18N
        erreur_ph.setText("Cet ID ne correspond à aucun PH");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Type d'examen :");

        type_field.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        type_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IRM", "RADIOGRAPHIE", "SCANNER" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valider_button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(type_field, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(ph_field, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(erreur_ph)
                                        .addGap(20, 20, 20))
                                    .addComponent(add_cr_button))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ph_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erreur_ph)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(add_cr_button)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(type_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valider_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 58)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 191, 252));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/feuilleBC1.png"))); // NOI18N
        jLabel2.setText("Création d'un examen");

        loading.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        loading.setForeground(new java.awt.Color(153, 204, 0));
        loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-chargement-en-cours-48.png"))); // NOI18N
        loading.setText("Chargement en cours");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(703, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action listener du bouton "Création d'Examen".
     * Vérifie que l'identifiant rentré dans le champ ph_field correspond bien à un PH, sinon affiche un message d'erreur.
     * Si pas d'erreur crée l'examen, met à jour l'onglet DMRPatient avec la fonction maj_exam et ouvre l'examen crée dans un nouvel onglet (placé après le DMR auquel il correspond).
     */
    private void valider_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider_buttonActionPerformed
        // Conditions avant de valider :
        // Tous les champs sont remplis
        // idPH est bien un entier et correspond bien à un PH
        
        String idPH= ph_field.getText();
        String type_ex= type_field.getSelectedItem().toString();
        TypeExamen type= TypeExamen.valueOf(type_ex);

        // vérifier que id correspond à un PH
        try {
            int id=Integer.valueOf(idPH);
            if (requetesbd.PhExiste(requetesbd.connexionBD(), idPH)) {
                erreur_ph.setVisible(false);
            }
            else {
                erreur_ph.setVisible(false);
                System.out.println("N'existe pas");
            }
        }
        catch(Exception e) {
            erreur_ph.setVisible(true);
        }

        if (!erreur_ph.isVisible()) {
            try {
                DMR ajout_exam=requetesbd.creationExamen(requetesbd.connexionBD(), dmr, Integer.valueOf(idPH), type, 0, cr);
                
                //met à jour DMR Patient
                dmr_pane.maj_exam(ajout_exam);
                
                //ouvre l'examen crée - premier dans la liste car plus récent
                Examen ex=ajout_exam.getExamens().get(0);
                javax.swing.JPanel exam_panel=new VoirExam(ajout_exam,user,ex);

                // insertion d'un nouvel onglet après la page de l'examen 
                Onglets.insertTab("           " + ex.getTypeExamen().toString() + " (" + ex.getDate() + ")        ",null,exam_panel,null,Onglets.getSelectedIndex()+1);
                Onglets.setSelectedComponent(exam_panel);
                
                // ferme l'onglet
                Onglets.remove(this);

                // création d'un bouton pour fermer l'onglet
                CloseButton close_button = new CloseButton(Onglets);

                // ajout du bouton
                Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);
            }
            catch (Exception e) {
                erreur_ph.setVisible(true);
            }
        }
        loading.setVisible(false);
    }//GEN-LAST:event_valider_buttonActionPerformed

    /**
     * Action listener du bouton "Sauvegarder le Compte Rendu".
     * Le bouton devient "Modifier le compte-rendu" si du texte a été rentré.
     * Le compte-rendu peut être modifié tant que l'examen n'est pas créé.
     */
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

    /**
     * Action listener du bouton "Ajouter un Compte Rendu".
     * Ouvre une JDialog dans laquelle le PH peut taper le Compte Rendu de l'examen.
     */
    private void add_cr_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_cr_buttonActionPerformed
        cr_field.setText(cr);
        cr_jdialog.setLocationRelativeTo(null);
        cr_jdialog.setVisible(true);
    }//GEN-LAST:event_add_cr_buttonActionPerformed

    /**
     * Action listener du JTextArea cr_field.
     * Fait apparaître le bouton permettant de sauvegarder le compte-rendu quand du texte est tapé.
     */
    private void cr_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cr_fieldKeyTyped
        save_button.setVisible(true);
    }//GEN-LAST:event_cr_fieldKeyTyped

    private void ph_fieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ph_fieldMouseExited
        // inutile
    }//GEN-LAST:event_ph_fieldMouseExited

    /**
     * Action listener du bouton "Créer l'Examen".
     * Si on appuie sur le bouton, un logo de chargement s'affiche.
     */
    private void valider_buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valider_buttonMousePressed
        loading.setVisible(true);
    }//GEN-LAST:event_valider_buttonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_cr_button;
    private javax.swing.JTextArea cr_field;
    private javax.swing.JDialog cr_jdialog;
    private javax.swing.JLabel erreur_ph;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loading;
    private javax.swing.JTextField ph_field;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox<String> type_field;
    private javax.swing.JButton valider_button;
    // End of variables declaration//GEN-END:variables
}
