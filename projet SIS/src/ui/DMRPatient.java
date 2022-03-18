/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import BD.requetesbd;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import nf.DMR;
import nf.Examen;
import nf.Genre;
import nf.Personnel;
import nf.Secretaire;

/**
 *
 * @author Garance
 */
public class DMRPatient extends javax.swing.JPanel {

    /**
     * Creates new form DMRPatient
     */
    JTabbedPane Onglets;
    Personnel user;
    private ArrayList<Examen> examens;
    int ligne = -1;
    DMR dmr;

    public DMRPatient() {
        initComponents();
    }

    public DMRPatient(JTabbedPane pane, Personnel user, DMR dmr) {
        initComponents();
        this.dmr = dmr;
        Onglets = pane;
        examens = dmr.getExamens();
        this.user = user;

        nom_patient.setText(dmr.getNomPatient());
        prenom_patient.setText(dmr.getPrenomPatient());

        Date date = dmr.getDateNaissance();
        date_naissance.setText(DMR.format_date(date));

        id.setText(String.valueOf(dmr.getId()));

        String genre = "";
        if (dmr.getGenre() == Genre.H) {
            genre = "Homme";
        } else if (dmr.getGenre() == Genre.F) {
            genre = "Femme";
        } else {
            genre = "Autre";
        }
        genre_patient.setText(genre);

        tel_label.setText("0" + String.valueOf(dmr.getTel()));
        adresse.setText(dmr.getAdresse());
        ville.setText(dmr.getCodePostal() + " " + dmr.getVille());

        erreur_exam.setVisible(false);

        DefaultTableModel model = (DefaultTableModel) table_exams.getModel();
        // examens triés du plus ancien ou plus récent dans la BD donc il suffit de parcourir la liste en sens inverse
        for (int i = examens.size() - 1; i >= 0; i--) {
            try {
                Personnel p = requetesbd.utilisateur(requetesbd.connexionBD(), examens.get(i).getIdPhRespo());
                String ph = "Dr " + p.getPrenom() + " " + p.getNom();
                model.insertRow(model.getRowCount(), new Object[]{DMR.format_date(examens.get(i).getDate()), examens.get(i).getTypeExamen(), ph});
            } catch (Exception e) {
            }
        }

        // Restrictions : secrétaire ne peut pas ajouter un examen
        if (user.getClass().equals(Secretaire.class)) {
            new_exam.setVisible(false);
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

        dmr_panel = new javax.swing.JPanel();
        id_patient_panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nom_patient = new javax.swing.JLabel();
        prenom_patient = new javax.swing.JLabel();
        date_naissance = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        genre_patient = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tel_label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        adresse = new javax.swing.JLabel();
        ville = new javax.swing.JLabel();
        exams = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_exams = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        new_exam = new javax.swing.JButton();
        selection_button = new javax.swing.JButton();
        erreur_exam = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        id_patient_panel.setBackground(new java.awt.Color(255, 255, 255));
        id_patient_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient"));

        jLabel8.setText("Nom -----------------------");

        jLabel9.setText("Prénom --------------------");

        jLabel10.setText("Date de naissance --------");

        jLabel14.setText("N° id -----------------------");

        nom_patient.setText("John");

        prenom_patient.setText("Doe");

        date_naissance.setText("01/01/1900");

        id.setText("JLabel");

        jLabel1.setText("Genre ----------------------");

        genre_patient.setText("Inconnu");

        jLabel2.setText("Téléphone -----------------");

        tel_label.setText("0781808779");

        jLabel4.setText("Adresse --------------------");

        adresse.setText("14, place du Conseil National de la Résistance");

        ville.setText("38400 Saint-Martin-d'Hères");

        javax.swing.GroupLayout id_patient_panelLayout = new javax.swing.GroupLayout(id_patient_panel);
        id_patient_panel.setLayout(id_patient_panelLayout);
        id_patient_panelLayout.setHorizontalGroup(
            id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(id_patient_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(id_patient_panelLayout.createSequentialGroup()
                                .addComponent(prenom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(56, 56, 56))
                            .addGroup(id_patient_panelLayout.createSequentialGroup()
                                .addComponent(nom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(id_patient_panelLayout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addComponent(date_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(269, 269, 269))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(genre_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(295, 295, 295))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(tel_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(263, 263, 263))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ville, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        id_patient_panelLayout.setVerticalGroup(
            id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(id_patient_panelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prenom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genre_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tel_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        exams.setBackground(new java.awt.Color(255, 255, 255));
        exams.setBorder(javax.swing.BorderFactory.createTitledBorder("Examens"));

        table_exams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type", "PH responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_exams.setToolTipText("");
        table_exams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_examsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_exams);

        javax.swing.GroupLayout examsLayout = new javax.swing.GroupLayout(exams);
        exams.setLayout(examsLayout);
        examsLayout.setHorizontalGroup(
            examsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        examsLayout.setVerticalGroup(
            examsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(examsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        new_exam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add (2).png"))); // NOI18N
        new_exam.setText("  Créer un nouvel examen");
        new_exam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_examActionPerformed(evt);
            }
        });

        selection_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-view-32.png"))); // NOI18N
        selection_button.setText("  Voir l'examen sélectionné");
        selection_button.setMaximumSize(new java.awt.Dimension(251, 41));
        selection_button.setMinimumSize(new java.awt.Dimension(251, 41));
        selection_button.setPreferredSize(new java.awt.Dimension(251, 41));
        selection_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selection_buttonActionPerformed(evt);
            }
        });

        erreur_exam.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        erreur_exam.setForeground(new java.awt.Color(149, 46, 46));
        erreur_exam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoInformation.png"))); // NOI18N
        erreur_exam.setText("Aucun examen n'est sélectionné.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(new_exam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selection_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(erreur_exam, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(new_exam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selection_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erreur_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dmr_panelLayout = new javax.swing.GroupLayout(dmr_panel);
        dmr_panel.setLayout(dmr_panelLayout);
        dmr_panelLayout.setHorizontalGroup(
            dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmr_panelLayout.createSequentialGroup()
                .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(id_patient_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(exams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dmr_panelLayout.setVerticalGroup(
            dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dmr_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addComponent(id_patient_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dmr_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dmr_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selection_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selection_buttonActionPerformed

        if (ligne > -1) {
            ouvreExam();
        } else {
            erreur_exam.setVisible(true);
        }
    }//GEN-LAST:event_selection_buttonActionPerformed

    private void ouvreExam() {
        // Besoin d'une fonction recherche d'un exam avec id patient & date exam

        Examen ex = examens.get(examens.size() - 1 - ligne);
        
        //si l'examen n'est pas déjà ouvert, on ouvre un nouvel onglet
        int index = Onglets.indexOfTab("           " + ex.getTypeExamen().toString() + " (" + ex.getDate() + ")        ");
        
        if (index == -1) {

            // Ouvre un nouvel onglet avec l'examen sélectionné
            javax.swing.JPanel exam_panel = new VoirExam(dmr, user, ex);

            // ajoute un nouvel onglet
            Onglets.insertTab("           " + ex.getTypeExamen().toString() + " (" + ex.getDate() + ")        ",null, exam_panel,null,Onglets.getSelectedIndex()+1);
            Onglets.setSelectedComponent(exam_panel);

            // création d'un bouton pour fermer l'onglet
            CloseButton close_button = new CloseButton(Onglets);

            // ajout du bouton
            Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);
        } 
        // sinon on va sur l'onglet de l'examen en question
        else {
            Onglets.setSelectedIndex(index);
        }
    }

    private void table_examsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_examsMouseClicked
        erreur_exam.setVisible(false);
        ligne = table_exams.getSelectedRow();
        //System.out.println(ligne);

        if (evt.getClickCount() == 2 && ligne > -1) {
            ouvreExam();
        }
    }//GEN-LAST:event_table_examsMouseClicked

    private void new_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_examActionPerformed
        erreur_exam.setVisible(false);

        // Ouvre un nouvel onglet ajout d'exam
        javax.swing.JPanel exam_panel = new NewExam(this, user);

        // on insert un nouvel onglet après le DMR auquel il faut ajouter l'examen
        Onglets.insertTab("        Ajouter un Examen      ",null, exam_panel, null, Onglets.getSelectedIndex()+1);
        Onglets.setSelectedComponent(exam_panel);

        // création d'un bouton pour fermer l'onglet
        CloseButton close_button = new CloseButton(Onglets);

        // ajout du bouton
        Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);
    }//GEN-LAST:event_new_examActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        erreur_exam.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    public void maj_exam(DMR maj) {
        examens = maj.getExamens();
        DefaultTableModel model = (DefaultTableModel) table_exams.getModel();
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (int i = examens.size() - 1; i >= 0; i--) {
            try {
                Personnel p = requetesbd.utilisateur(requetesbd.connexionBD(), examens.get(i).getIdPhRespo());
                String ph = "Dr " + p.getPrenom() + " " + p.getNom();
                model.insertRow(model.getRowCount(), new Object[]{DMR.format_date(examens.get(i).getDate()), examens.get(i).getTypeExamen(), ph});
            } catch (Exception e) {
                System.out.println("Erreur bd");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adresse;
    private javax.swing.JLabel date_naissance;
    private javax.swing.JPanel dmr_panel;
    private javax.swing.JLabel erreur_exam;
    private javax.swing.JPanel exams;
    private javax.swing.JLabel genre_patient;
    private javax.swing.JLabel id;
    private javax.swing.JPanel id_patient_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton new_exam;
    private javax.swing.JLabel nom_patient;
    private javax.swing.JLabel prenom_patient;
    private javax.swing.JButton selection_button;
    private javax.swing.JTable table_exams;
    private javax.swing.JLabel tel_label;
    private javax.swing.JLabel ville;
    // End of variables declaration//GEN-END:variables
}
