/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_images;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import static javax.swing.Action.LARGE_ICON_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

/**
 *
 * @author Chloe
 */
public class Visionneuse extends javax.swing.JFrame {

    private String imagedir = System.getProperty("user.home") + "\\Dropbox\\projet_SIS\\PACS\\" + "dateExamen_nom_prenom";
    private File[] files;
    private MissingIcon placeholderIcon = new MissingIcon();
    private File main_image;
    private BufferedImage source;

    private SwingWorker<Void, Visionneuse.ThumbnailAction> loadimages = new SwingWorker<Void, Visionneuse.ThumbnailAction>() {

        /**
         * Creates full size and thumbnail versions of the target image files.
         */
        @Override
        protected Void doInBackground() throws Exception {
            for (File file : files) {
                String description = file.getName();
                ImageIcon icon;
                icon = createImageIcon(file.getPath(), description);
                main_image = file;

                Visionneuse.ThumbnailAction thumbAction;
                if (icon != null) {

                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));

                    thumbAction = new Visionneuse.ThumbnailAction(icon, thumbnailIcon, description);

                    thumbAction.addPropertyChangeListener(null);

                } else {
                    // the image failed to load for some reason
                    // so load a placeholder instead
                    thumbAction = new Visionneuse.ThumbnailAction(placeholderIcon, placeholderIcon, description);
                }
                publish(thumbAction);
            }
            // unfortunately we must return something, and only null is valid to
            // return when the return type is void.
            return null;
        }

        /**
         * Process all loaded images.
         */
        @Override
        protected void process(List<Visionneuse.ThumbnailAction> chunks) {
            for (Visionneuse.ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                // add the new button BEFORE the last glue
                // this centers the buttons in the toolbar
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };

    protected ImageIcon createImageIcon(String path,
            String description) {
//        java.net.URL imgURL = getClass().getResource(path);
//        if (imgURL != null) {
        return new ImageIcon(path, description);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
    }

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     *
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
    

//    private Image zone(String chemin_image) throws IOException {
//        BufferedImage source = ImageIO.read(new File(chemin_image));
//
////        BufferedImage imageRetaillée = new BufferedImage(source.getWidth() / 10, source.getHeight() / 10, source.getType());
////        AffineTransform retailler = AffineTransform.getScaleInstance(0.1, 0.1);
//        int interpolation = AffineTransformOp.TYPE_BICUBIC;
////        AffineTransformOp retaillerImage = new AffineTransformOp(retailler, interpolation);
////        retaillerImage.filter(source, imageRetaillée);
//
//        BufferedImage image = new BufferedImage(source.getHeight() / 10, source.getWidth() / 10, source.getType());
//        double centreDeRotation = source.getHeight() / 2;
//        AffineTransform pivoter = AffineTransform.getRotateInstance(Math.toRadians(90), centreDeRotation, centreDeRotation);
//        AffineTransformOp pivoterImage = new AffineTransformOp(pivoter, interpolation);
//        pivoterImage.filter(source, image);
//        
//        return image;
//    }
//   protected void paintComponent(Graphics surface) {
//      surface.drawImage(image, 0, 0, null);   
//   } 
    /**
     * Action class that shows the image specified in it's constructor.
     */
    private class ThumbnailAction extends AbstractAction {

        /**
         * The icon if the full image we want to display.
         */
        private Icon displayPhoto;

        /**
         * @param Icon - The full size photo to show in the button.
         * @param Icon - The thumbnail to show in the button.
         * @param String - The descriptioon of the icon.
         */
        public ThumbnailAction(Icon photo, Icon thumb, String desc) {
            displayPhoto = photo;

            // The short description becomes the tooltip of a button.
            putValue(SHORT_DESCRIPTION, desc);

            // The LARGE_ICON_KEY is the key for setting the
            // icon when an Action is applied to a button.
            putValue(LARGE_ICON_KEY, thumb);
        }

        /**
         * Shows the full image in the main area and sets the application title.
         */
        public void actionPerformed(ActionEvent e) {
            imageP.getGraphics().drawImage(displayPhoto, WIDTH, WIDTH, rootPane);
            setTitle("Icon Demo: " + getValue(SHORT_DESCRIPTION).toString());
        }

    }

    /**
     * Creates new form Visionneuse
     */
    public Visionneuse(File[] files) {
        initComponents();
        this.files = files;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Examen du dateExamen");
        main_image = files[0];
        source = ImageIO.read(main_image);
        BufferedImage imageRetaillée = new BufferedImage(source.getWidth() / 10, source.getHeight() / 10, source.getType());

        // this centers the frame on the screen
        setLocationRelativeTo(null);

        // start the image loading SwingWorker in a background thread
        loadimages.execute();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBar = new javax.swing.JToolBar();
        bouton_rotation = new javax.swing.JButton();
        imageP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });

        buttonBar.setRollover(true);

        bouton_rotation.setText("rotation");
        bouton_rotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton_rotationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagePLayout = new javax.swing.GroupLayout(imageP);
        imageP.setLayout(imagePLayout);
        imagePLayout.setHorizontalGroup(
            imagePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        imagePLayout.setVerticalGroup(
            imagePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonBar, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bouton_rotation)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(imageP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(bouton_rotation)
                .addGap(188, 188, 188)
                .addComponent(imageP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(buttonBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved


    }//GEN-LAST:event_formMouseWheelMoved

    private void bouton_rotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_rotationActionPerformed
      
    }//GEN-LAST:event_bouton_rotationActionPerformed

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
            java.util.logging.Logger.getLogger(Visionneuse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visionneuse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visionneuse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visionneuse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Visionneuse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouton_rotation;
    private javax.swing.JToolBar buttonBar;
    private javax.swing.JPanel imageP;
    // End of variables declaration//GEN-END:variables
}
