/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import BD.requetesbd;
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
    
    public VoirExam() {
        initComponents();
    }
    
    public VoirExam(DMR dmr,Examen ex) {
        initComponents();
        this.ex=ex;
        
        save_button.setVisible(false);
        
        String date=DMR.format_date(ex.getDate());
        
        title_label.setText(ex.getTypeExamen().toString()+" du "+date);
        id_label.setText(String.valueOf(ex.getIdDMR())+" ("+dmr.getPrenomPatient()+" "+dmr.getNomPatient()+")"); //rajter nom/prénom correspondant
        type_label.setText(ex.getTypeExamen().toString());
        date_label.setText(date);
        try {
            Personnel p = requetesbd.utilisateur(requetesbd.connexionBD(), ex.getIdPhRespo());
            ph_label.setText("Dr "+p.getPrenom()+" "+p.getNom());
        }
        catch(Exception e) {}
        
        if(ex.getNumPACS()==0) {
            pacs_label_1.setText("DMR Papier");
            pacs_label.setText("");
        }
        
        else {
            pacs_label_1.setText("N° PACS :");
            pacs_label.setText(String.valueOf(ex.getNumPACS()));
        }
        
        //compte-rendu éditable seulement si vide
        if(ex.getTexteCR()!=null && !ex.getTexteCR().equals("")) {
            compte_rendu.setText(ex.getTexteCR());
            compte_rendu.setRequestFocusEnabled(false);
        }
        else {
            compte_rendu.setEditable(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        pacs_label_1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        compte_rendu = new javax.swing.JTextPane();
        id_label = new javax.swing.JLabel();
        type_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        ph_label = new javax.swing.JLabel();
        pacs_label = new javax.swing.JLabel();
        save_button = new javax.swing.JButton();

        title_label.setFont(new java.awt.Font("Source Serif Pro Black", 0, 58)); // NOI18N
        title_label.setText("Examen du JJ/MM/AAAA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(title_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Label1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label1.setForeground(new java.awt.Color(170, 0, 0));
        Label1.setText("DMR :");

        Label2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label2.setForeground(new java.awt.Color(170, 0, 0));
        Label2.setText("Type d'Examen :");

        Label4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label4.setForeground(new java.awt.Color(170, 0, 0));
        Label4.setText("PH responsable :");

        Label3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Label3.setForeground(new java.awt.Color(170, 0, 0));
        Label3.setText("Date :");

        pacs_label_1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pacs_label_1.setText("N° PACS : / DMR Papier");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(170, 0, 0));
        jLabel10.setText("Compte Rendu :");

        compte_rendu.setEditable(false);
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

        id_label.setText("id (Nom Prénom)");

        type_label.setText("type");

        date_label.setText("date");

        ph_label.setText("Nom Prénom");

        pacs_label.setText("jLabel1");

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-save-32.png"))); // NOI18N
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(pacs_label_1)
                            .addGap(18, 18, 18)
                            .addComponent(pacs_label))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Label3)
                            .addGap(18, 18, 18)
                            .addComponent(date_label))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Label4)
                            .addGap(18, 18, 18)
                            .addComponent(ph_label))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Label2)
                            .addGap(18, 18, 18)
                            .addComponent(type_label))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Label1)
                            .addGap(18, 18, 18)
                            .addComponent(id_label))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(save_button, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(id_label))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(type_label))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label3)
                    .addComponent(date_label))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label4)
                    .addComponent(ph_label))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacs_label_1)
                    .addComponent(pacs_label))
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(169, 169, 169))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compte_renduMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compte_renduMouseEntered

    }//GEN-LAST:event_compte_renduMouseEntered

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        //ex.setTexteCR(compte_rendu.getText());
        try {
            requetesbd.creationCR(requetesbd.connexionBD(), ex, compte_rendu.getText());
        }
        catch (Exception e) {
            System.out.println("Echec du compte-rendu");
        }
    }//GEN-LAST:event_save_buttonActionPerformed

    private void compte_renduKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_compte_renduKeyTyped
        if (ex.getTexteCR()==null) {
            save_button.setVisible(true);
        }
    }//GEN-LAST:event_compte_renduKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JTextPane compte_rendu;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pacs_label;
    private javax.swing.JLabel pacs_label_1;
    private javax.swing.JLabel ph_label;
    private javax.swing.JButton save_button;
    private javax.swing.JLabel title_label;
    private javax.swing.JLabel type_label;
    // End of variables declaration//GEN-END:variables
}
