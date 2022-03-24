/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gestion_images;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

/*
 * Permet de visualiser toutes les images d'un dossier
 */
public class SliderDemo extends JPanel {
    //Set up animation parameters.

    int frameNumber = 0;
    int NUM_FRAMES;
    ImageIcon[] images;
    // toutes les valeurs de contraste par image
//    int[] valeurs_contraste;
    int valeurContraste = 100;

//File representing the folder that you select using a FileChooser
    File[] liste_files;
//array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "jpg" //and other formats you need
    };
//filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    //This label uses ImageIcon to show the doggy pictures.
    JLabel picture;

    int faireRotation = 0;

    boolean imageMiroir = false;

    /**
     * Constructeur de la classe SliderDemo
     * @param chemin
     */
    public SliderDemo(String chemin) {
        //on définit le dossier où il y a les images
        final File dir = new File(chemin);

        //on récupère les images du dossier
        liste_files = dir.listFiles(IMAGE_FILTER);

        //nombre d'images
        NUM_FRAMES = liste_files.length;

        //initialisation de la liste d'ImageIcon
        images = new ImageIcon[NUM_FRAMES];

//        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Create the label.
        JLabel sliderLabel = new JLabel("Image Affichée", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create the slider.
        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                0, liste_files.length - 1, 0);

        //Turn on labels at major tick marks.
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        framesPerSecond.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 10, 0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        framesPerSecond.setFont(font);
        framesPerSecond.setAutoscrolls(true);
        framesPerSecond.setValueIsAdjusting(true);

        //on ajoute un listener au slider : quand il bouge avec la souris, les images changent
        framesPerSecond.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {

                int fps = (int) framesPerSecond.getValue();
                frameNumber = fps;
//                updatePicture(fps);
                contraste();

            }
        }
        );

//Create the label.
        JLabel sliderLabelbis = new JLabel("Niveau de Contraste", JLabel.CENTER);
        sliderLabelbis.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Create the slider.
        JSlider framesPerSecondbis = new JSlider(JSlider.HORIZONTAL,
                0, 200, 100);

//        framesPerSecond.addChangeListener(this);
        //Turn on labels at major tick marks.
        framesPerSecondbis.setMajorTickSpacing(10);
        framesPerSecondbis.setMinorTickSpacing(1);
        framesPerSecondbis.setPaintTicks(true);
        framesPerSecondbis.setPaintLabels(true);
        framesPerSecondbis.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 10, 0));

        framesPerSecondbis.setFont(font);
        framesPerSecondbis.setAutoscrolls(true);
        framesPerSecondbis.setValueIsAdjusting(true);

        framesPerSecondbis.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                valeurContraste = framesPerSecondbis.getValue();
                contraste();
//               
            }
        }
        );

        //Create the label that displays the animation.
        picture = new JLabel();

        picture.setHorizontalAlignment(JLabel.CENTER);

        picture.setAlignmentX(Component.CENTER_ALIGNMENT);

        picture.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        updatePicture(
                0); //display first frame

        //Put everything together.
        add(sliderLabel);

        add(framesPerSecond);

        add(sliderLabelbis);

        add(framesPerSecondbis);

        add(picture);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton boutonMiroir = new JButton("Miroir");
        boutonMiroir.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                imageMiroir = !imageMiroir;

                contraste();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(boutonMiroir);

        JButton rotation = new JButton("Rotation");
        rotation.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                faireRotation++;
                if (faireRotation == 4) {
                    faireRotation = 0;
                }
                contraste();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(rotation);

    }

    /**
     * Tourne l'image de 90° puis utilise la fonction miroir
     *
     * @param source
     */
    protected void rotation(BufferedImage source) {

        int i = 0;
        while (i < faireRotation) {
            BufferedImage image = new BufferedImage(source.getHeight(), source.getWidth(), source.getType());
            double centreDeRotation = source.getHeight() / 2;
            int interpolation = AffineTransformOp.TYPE_BICUBIC;
            AffineTransform pivoter = AffineTransform.getRotateInstance(Math.toRadians(90), centreDeRotation, centreDeRotation);
            AffineTransformOp pivoterImage = new AffineTransformOp(pivoter, interpolation);
            pivoterImage.filter(source, image);
            source = image;
            i++;
        }

        miroir(source);
    }

    /**
     * Update the label to display the image for the current frame.
     *
     * @param frameNum
     */
    protected void updatePicture(int frameNum) {
        //Get the image if we haven't already.
        if (images[frameNumber] == null) {
            images[frameNumber] = createImageIcon(liste_files[frameNum].getPath());

        }

        //Set the image.
        if (images[frameNumber] != null) {
            picture.setIcon(images[frameNumber]);

        } else { //image not found
            picture.setText("image #" + frameNumber + " not found");
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     *
     * @param path
     * @return ImageIcon
     */
    protected static ImageIcon createImageIcon(String path) {

        return new ImageIcon(path);

    }

    /**
     * Met du contraste sur l'image selon la valeur du slider de contraste puis
     * fait la rotation de l'image
     */
    protected void contraste() {
        float brightenFactor = (float) valeurContraste / 100;
        RescaleOp op = new RescaleOp(brightenFactor, 0, null);
        BufferedImage image;
        try {

            image = ImageIO.read(liste_files[frameNumber]);

            op.filter(image, image);
            rotation(image);

        } catch (IOException ex) {
            Logger.getLogger(SliderDemo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prend l'image miroir de l'image en paramètre et utilise la fonction
     * updatePicture pour l'afficher
     *
     * @param image
     */
    protected void miroir(BufferedImage image) {

        if (imageMiroir) {
            int w = image.getWidth();
            int h = image.getHeight();
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            int[] r = new int[w * h];
            image.getRGB(0, 0, w, h, r, 0, w);
            img.getRaster().setDataElements(0, 0, w, h, r);
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    img.setRGB(w - i - 1, j, image.getRGB(i, j));
                }
            }
            image = img;
        }
        images[frameNumber] = new ImageIcon(image);
        updatePicture(frameNumber);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     *
     * @param chemin
     */
    public static void createAndShowGUI(String chemin) {
        //Create and set up the window.
        JFrame frame = new JFrame("Visionneuse d'images");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SliderDemo animator = new SliderDemo(chemin);

        //Add content to the window.
        frame.add(animator, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
