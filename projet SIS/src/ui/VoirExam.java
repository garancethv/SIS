/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import BD.requetesbd;
import gestion_images.IconDemoApp;
import gestion_images.ImageFileView;
import gestion_images.ImageFilter;
import gestion_images.ImagePreview;
import gestion_images.SliderDemo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import nf.DMR;
import nf.Examen;
import nf.Personnel;

/**
 *
 * @author Garance
 */
public class VoirExam extends javax.swing.JPanel {

    /**
     * Creates new form VoirExam
     */
    Examen ex;
    Personnel user;
    String chemin;

    /**
     *
     */
    public VoirExam() {
        initComponents();
    }

    /**
     * Constructeur de VoirExam (panel permettant de voir un examen)
     * @param dmr : le DMR auquel appartient l'exam
     * @param user : l'utilisateur connecté
     * @param ex : l'examen affiché
     */
    public VoirExam(DMR dmr, Personnel user, Examen ex) {
        initComponents();

        //le chemin du PACS
        this.chemin = System.getProperty("user.home") + "/Dropbox/projet_SIS/PACS/" + ex.getDate().getDay() + ex.getDate().getMonth() + ex.getDate().getYear() + ex.getDate().getTime();

        //création du dossier examen dans le PACS s'il n'existe pas déjà
        new File(chemin).mkdirs();

        this.user = user;

        fen_confirmer_imp.setLocationRelativeTo(null);

        this.ex = ex;

        print_button.setVisible(false);
        save_button.setVisible(false);

        String date = DMR.format_date(ex.getDate());

        jLabel5.setText("Examen du " + date);
        id_label.setText(String.valueOf(ex.getIdDMR()) + " (" + dmr.getPrenomPatient() + " " + dmr.getNomPatient() + ")"); //rajter nom/prénom correspondant
        type_label.setText(ex.getTypeExamen().toString());
        date_label.setText(date);
        try {
            Personnel p = requetesbd.utilisateur(requetesbd.connexionBD(), ex.getIdPhRespo());
            ph_label.setText("Dr " + p.getPrenom() + " " + p.getNom());
        } catch (Exception e) {
        }

        //compte-rendu éditable seulement si vide
        if (ex.getTexteCR() != null && !ex.getTexteCR().equals("")) {
            compte_rendu.setText(ex.getTexteCR());
            compte_rendu.setRequestFocusEnabled(false);
            print_button.setVisible(true);
        } else {
            compte_rendu.setEditable(true);
        }

        // Restrictions :
        // Seul PH peut ajouter / voir le cr
        if (!user.getClass().equals(nf.PH.class)) {
            jLabel10.setVisible(false);
            jScrollPane1.setVisible(false);
            print_button.setVisible(false);
        }
        // Secrétaire ne peut pas voir images (mais peut en ajouter)
        if (user.getClass().equals(nf.Secretaire.class)) {
            visualiserImagesSélectionnees.setVisible(false);
            visualisation3D.setVisible(false);
        }

        //Les boutons de visualisation sont seulement accessibles s'il y a des images dans le dossier d'examen du PACS
        boutonAjouterImages.setVisible(true);
        if (new File(chemin).listFiles().length != 0) {
            visualiserImagesSélectionnees.setVisible(true);
            visualisation3D.setVisible(true);
        } else {
            visualiserImagesSélectionnees.setVisible(false);
            visualisation3D.setVisible(false);
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

        fen_confirmer_imp = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        area_apercu = new javax.swing.JTextArea();
        button_imp_ok = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        visualisation3D1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        visualiserImagesSélectionnees = new javax.swing.JButton();
        visualisation3D = new javax.swing.JButton();
        boutonAjouterImages = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        type_label = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        ph_label = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        compte_rendu = new javax.swing.JTextPane();
        print_button = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        fen_confirmer_imp.setSize(new java.awt.Dimension(800, 750));

        area_apercu.setEditable(false);
        area_apercu.setLineWrap(true);
        area_apercu.setAutoscrolls(false);
        area_apercu.setMaximumSize(new java.awt.Dimension(2, 2));
        area_apercu.setMinimumSize(new java.awt.Dimension(2, 2));
        jScrollPane3.setViewportView(area_apercu);

        button_imp_ok.setText("Confimer l'impression");
        button_imp_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_imp_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fen_confirmer_impLayout = new javax.swing.GroupLayout(fen_confirmer_imp.getContentPane());
        fen_confirmer_imp.getContentPane().setLayout(fen_confirmer_impLayout);
        fen_confirmer_impLayout.setHorizontalGroup(
            fen_confirmer_impLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fen_confirmer_impLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_imp_ok)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        fen_confirmer_impLayout.setVerticalGroup(
            fen_confirmer_impLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fen_confirmer_impLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fen_confirmer_impLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_imp_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        visualisation3D1.setText("visualisation 3D");
        visualisation3D1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualisation3DActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        visualiserImagesSélectionnees.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        visualiserImagesSélectionnees.setForeground(new java.awt.Color(3, 173, 161));
        visualiserImagesSélectionnees.setText("Visualiser images numérisées");
        visualiserImagesSélectionnees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualiserImagesSélectionneesActionPerformed(evt);
            }
        });

        visualisation3D.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        visualisation3D.setForeground(new java.awt.Color(3, 173, 161));
        visualisation3D.setText("Visualisation 3D");
        visualisation3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualisation3DActionPerformed(evt);
            }
        });

        boutonAjouterImages.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        boutonAjouterImages.setForeground(new java.awt.Color(3, 173, 161));
        boutonAjouterImages.setText("Ajouter images numérisées");
        boutonAjouterImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAjouterImagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visualisation3D, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(visualiserImagesSélectionnees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonAjouterImages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(boutonAjouterImages, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualiserImagesSélectionnees, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualisation3D, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        Label1.setBackground(new java.awt.Color(255, 255, 255));
        Label1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label1.setForeground(new java.awt.Color(3, 173, 161));
        Label1.setText("DMR :");

        id_label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        id_label.setText("id (Nom Prénom)");

        Label2.setBackground(new java.awt.Color(255, 255, 255));
        Label2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label2.setForeground(new java.awt.Color(3, 173, 161));
        Label2.setText("Type d'Examen :");

        type_label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        type_label.setText("type");

        Label3.setBackground(new java.awt.Color(255, 255, 255));
        Label3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label3.setForeground(new java.awt.Color(3, 173, 161));
        Label3.setText("Date :");

        date_label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        date_label.setText("date");

        Label4.setBackground(new java.awt.Color(255, 255, 255));
        Label4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label4.setForeground(new java.awt.Color(3, 173, 161));
        Label4.setText("PH responsable :");

        ph_label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ph_label.setText("Nom Prénom");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Label1)
                        .addGap(18, 18, 18)
                        .addComponent(id_label))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Label2)
                        .addGap(18, 18, 18)
                        .addComponent(type_label))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Label3)
                        .addGap(18, 18, 18)
                        .addComponent(date_label))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Label4)
                        .addGap(18, 18, 18)
                        .addComponent(ph_label)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(id_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(type_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label3)
                    .addComponent(date_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label4)
                    .addComponent(ph_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 173, 161));
        jLabel10.setText("Compte Rendu :");

        compte_rendu.setEditable(false);
        compte_rendu.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        compte_rendu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compte_renduMouseEntered(evt);
            }
        });
        compte_rendu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                compte_renduKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(compte_rendu);

        print_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-printer-32.png"))); // NOI18N
        print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_buttonActionPerformed(evt);
            }
        });

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-save-32.png"))); // NOI18N
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(print_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save_button))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(print_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 58)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(3, 173, 161));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/feuilleBV1.png"))); // NOI18N
        jLabel5.setText("Examen du date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1323, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compte_renduMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compte_renduMouseEntered
        //inutile
    }//GEN-LAST:event_compte_renduMouseEntered

    /**
     * Action listener du bouton "Sauvegarder le Compte Rendu".
     * Ajoute le Compte Rendu à l'examen dans la base de données.
     */
    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        //if (!compte_rendu.getText().equals("")){
        ex.setTexteCR(compte_rendu.getText());
        try {
            requetesbd.creationCR(requetesbd.connexionBD(), ex, ex.getDate().toLocaleString(), compte_rendu.getText());
        } catch (Exception e) {
            System.out.println("Echec du compte-rendu");
        }
        compte_rendu.setEditable(false);
        save_button.setVisible(false);
        print_button.setVisible(true);
        //}
    }//GEN-LAST:event_save_buttonActionPerformed

    /**
     * Action listener du JTextArea compte_rendu.
     * Fait apparaître le bouton permettant de sauvegarder le compte-rendu quand du texte est tapé.
     */
    private void compte_renduKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_compte_renduKeyTyped
        if (ex.getTexteCR() == null) {
            save_button.setVisible(true);
        }
    }//GEN-LAST:event_compte_renduKeyTyped

    /**
     * Action listener du bouton imprimer.
     * Fait apparaître une JDialog de confirmation d'impression.
     */
    private void print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_buttonActionPerformed
        if (!compte_rendu.isEditable()) {
            //ouvre la fenêtre de confirmation
            area_apercu.setText("                                                                                                                                                                                              Compte-rendu d'examen\n"
                    + "DMR : " + id_label.getText() + "\n"
                    + "Type d'examen : " + type_label.getText() + "\n"
                    + "Date : " + date_label.getText() + "\n"
                    + "PH responsable : " + ph_label.getText() + "\n"
                    + "      ------------------------------------------------------------------------------------------------\n"
                    + compte_rendu.getText());

            fen_confirmer_imp.setVisible(true);
        }
    }//GEN-LAST:event_print_buttonActionPerformed

    /**
     * Action listener du bouton confirmation d'impression.
     * Lance l'impression.
     */
    private void button_imp_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imp_okActionPerformed
        //imprimer
        boolean reussi = false;

        try {
            area_apercu.print();
            reussi = true;
        } catch (Exception e) {
        }

        if (reussi) {
            fen_confirmer_imp.setVisible(false);
        }
    }//GEN-LAST:event_button_imp_okActionPerformed

    /**
     * Action listener du bouton Ajouter Images.
     * Permet d'ajouter des images à l'Examen.
     */
    private void boutonAjouterImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAjouterImagesActionPerformed

        //Set up the file chooser.
        JFileChooser fc = new JFileChooser(System.getProperty("user.home") + "/Documents/IMAGES_SCANNEES");
        fc.setMultiSelectionEnabled(true);
        //Add a custom file filter and disable the default
        //(Accept All) file filter.
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //Add custom icons for file types.
        fc.setFileView(new ImageFileView());

        //Add the preview pane.
        fc.setAccessory(new ImagePreview(fc));

        //Show it.
        int returnVal = fc.showDialog(this,
                "Attach");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] liste_files = fc.getSelectedFiles();
            //Pour toutes les images sélectionnées on les déplace dans le dossier du PACS
            for (File file : liste_files) {

                try {
                    Path source = file.toPath();
                    Path dest = Paths.get(chemin + "/" + file.getName()); // nouveau path de l'image

                    Files.move(source, dest); // déplacement de l'image

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Attaching file: " + file.getPath()
                        + ".");

            }
            //si on a bien ajouter des images dans le dossier du PACS alors on peut les visualiser
            if (new File(chemin).listFiles().length != 0) {
                visualiserImagesSélectionnees.setVisible(true);
                visualisation3D.setVisible(true);
            }
        } else {
            System.out.println("Attachment cancelled by user.");
        }

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);

    }//GEN-LAST:event_boutonAjouterImagesActionPerformed

    /**
     * Action listener du bouton Visualiser Images.
     * Permet de visualiser les images sélectionnées parmi celles liées à l'examen.
     */
    private void visualiserImagesSélectionneesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualiserImagesSélectionneesActionPerformed

        //Set up the file chooser.
        JFileChooser fc = new JFileChooser(chemin);
        fc.setMultiSelectionEnabled(true);

        //Add a custom file filter and disable the default
        //(Accept All) file filter.
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //Add custom icons for file types.
        fc.setFileView(new ImageFileView());

        //Add the preview pane.
        fc.setAccessory(new ImagePreview(fc));

        //Show it.
        int returnVal = fc.showDialog(this,
                "Attach");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] liste_files = fc.getSelectedFiles();
            //On visualise les images sélectionnées pour les comparer
            IconDemoApp vision = new IconDemoApp(liste_files, jLabel5.getText());
            vision.setVisible(true);

        } else {
            System.out.println("Attachment cancelled by user.");
        }

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);

    }//GEN-LAST:event_visualiserImagesSélectionneesActionPerformed

    /**
     * Action listener du bouton Visualisation 3D.
     * Ouvre une fenêtre SliderDemo (voir package gestion_images).
     */
    private void visualisation3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualisation3DActionPerformed
        //on visualise les images en profondeur ==visualisation de toutes les images du dossier examen du PACS
        SliderDemo.createAndShowGUI(chemin);
    }//GEN-LAST:event_visualisation3DActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JTextArea area_apercu;
    private javax.swing.JButton boutonAjouterImages;
    private javax.swing.JButton button_imp_ok;
    private javax.swing.JTextPane compte_rendu;
    private javax.swing.JLabel date_label;
    private javax.swing.JDialog fen_confirmer_imp;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel ph_label;
    private javax.swing.JButton print_button;
    private javax.swing.JButton save_button;
    private javax.swing.JLabel type_label;
    private javax.swing.JButton visualisation3D;
    private javax.swing.JButton visualisation3D1;
    private javax.swing.JButton visualiserImagesSélectionnees;
    // End of variables declaration//GEN-END:variables
}
