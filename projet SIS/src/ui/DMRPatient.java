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

/**
 *
 * @author Garance
 */
public class DMRPatient extends javax.swing.JPanel {

    /**
     * Creates new form DMRPatient
     */
    JTabbedPane Onglets;
    private ArrayList<Examen> examens;
    int ligne=-1;
    DMR dmr;
    
    public DMRPatient() {
        initComponents();
    }
    
    public DMRPatient(JTabbedPane pane, DMR dmr) {
        initComponents();  
        this.dmr=dmr;
        Onglets=pane;
        examens=dmr.getExamens();
        
        nom_patient.setText(dmr.getNomPatient());
        prenom_patient.setText(dmr.getPrenomPatient());
        
        Date date = dmr.getDateNaissance();
        date_naissance.setText(DMR.format_date(date));
        
        id.setText(String.valueOf(dmr.getId()));
        
        String genre="";
        if (dmr.getGenre()==Genre.H) {
            genre="Homme";
        }
        else if (dmr.getGenre()==Genre.F) {
            genre="Femme";
        }
        else {
            genre="Autre";
        }
        genre_patient.setText(genre);
        
        tel_label.setText("0"+String.valueOf(dmr.getTel()));
        adresse.setText(dmr.getAdresse());
        ville.setText(dmr.getCodePostal()+" "+dmr.getVille());
        
        erreur_exam.setVisible(false);
           
        DefaultTableModel model = (DefaultTableModel) table_exams.getModel();
        // examens triés du plus ancien ou plus récent dans la BD donc il suffit de parcourir la liste en sens inverse
        for (int i=examens.size()-1; i>=0; i--) {
            try {
                Personnel p = requetesbd.utilisateur(requetesbd.connexionBD(), examens.get(i).getIdPhRespo());
                String ph="Dr "+p.getPrenom()+" "+p.getNom();
                model.insertRow(model.getRowCount(), new Object[]{DMR.format_date(examens.get(i).getDate()),examens.get(i).getTypeExamen(),ph});
            }
            catch(Exception e) {
            }
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

        jLabel8.setText("Nom :");

        jLabel9.setText("Prénom :");

        jLabel10.setText("Date de naissance :");

        jLabel14.setText("N° Identifiant :");

        nom_patient.setText("John");

        prenom_patient.setText("Doe");

        date_naissance.setText("01/01/1900");

        id.setText("JLabel");

        jLabel1.setText("Genre :");

        genre_patient.setText("Inconnu");

        jLabel2.setText("Téléphone :");

        tel_label.setText("0781808779");

        jLabel4.setText("Adresse :");

        adresse.setText("14, place du Conseil National de la Résistance");

        ville.setText("38400 Saint-Martin-d'Hères");

        javax.swing.GroupLayout id_patient_panelLayout = new javax.swing.GroupLayout(id_patient_panel);
        id_patient_panel.setLayout(id_patient_panelLayout);
        id_patient_panelLayout.setHorizontalGroup(
            id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(id_patient_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(date_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(169, 169, 169))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(prenom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(296, 296, 296))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nom_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(311, 311, 311))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(242, 242, 242))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(genre_patient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tel_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(215, 215, 215))
                    .addGroup(id_patient_panelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(id_patient_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(id_patient_panelLayout.createSequentialGroup()
                                .addComponent(ville, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(130, 130, 130))
                            .addComponent(adresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(73, 73, 73))
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
                .addGap(6, 6, 6)
                .addComponent(ville, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
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

        javax.swing.GroupLayout dmr_panelLayout = new javax.swing.GroupLayout(dmr_panel);
        dmr_panel.setLayout(dmr_panelLayout);
        dmr_panelLayout.setHorizontalGroup(
            dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmr_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(id_patient_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140)
                .addComponent(exams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(new_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selection_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(erreur_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
        );
        dmr_panelLayout.setVerticalGroup(
            dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmr_panelLayout.createSequentialGroup()
                .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(dmr_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(dmr_panelLayout.createSequentialGroup()
                                .addComponent(id_patient_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136))))
                    .addGroup(dmr_panelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(new_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(selection_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erreur_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(332, 332, 332)))
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dmr_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dmr_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void selection_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selection_buttonActionPerformed
        
       if (ligne>-1) {
            ouvreExam();
       }
       else {
           erreur_exam.setVisible(true);
       }
    }//GEN-LAST:event_selection_buttonActionPerformed

    private void ouvreExam() {
            // Besoin d'une fction recherche d'un exam avec id patient & date exam
            Examen ex = examens.get(examens.size()-1-ligne);
            // Ouvre un nouvel onglet avec l'examen sélectionné

            javax.swing.JPanel exam_panel=new VoirExam(dmr,ex);

            // ajoute un nouvel onglet
            Onglets.addTab("           "+ex.getTypeExamen().toString()+"        ",exam_panel);
            Onglets.setSelectedComponent(exam_panel);

            // création d'un bouton pour fermer l'onglet
            CloseButton close_button = new CloseButton(Onglets);

            // ajout du bouton
            Onglets.setTabComponentAt(Onglets.getSelectedIndex(), close_button);
    }
    
    private void table_examsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_examsMouseClicked
        erreur_exam.setVisible(false);
        ligne = table_exams.getSelectedRow();
        //System.out.println(ligne);
                
        if(evt.getClickCount()==2 && ligne>-1){
            ouvreExam();
        }
    }//GEN-LAST:event_table_examsMouseClicked

    private void new_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_examActionPerformed
            erreur_exam.setVisible(false);
            
            // Ouvre un nouvel onglet ajout d'exam
            javax.swing.JPanel exam_panel=new NewExam(this);

            // ajoute un nouvel onglet
            Onglets.addTab("        Ajouter un Examen      ",exam_panel);
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
        examens=maj.getExamens();
        DefaultTableModel model = (DefaultTableModel)table_exams.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--){
            model.removeRow(i); 
        }
        for (int i=examens.size()-1; i>=0; i--) {
            model.insertRow(model.getRowCount(), new Object[]{DMR.format_date(examens.get(i).getDate()),examens.get(i).getTypeExamen(),String.valueOf(examens.get(i).getIdPhRespo())});
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
