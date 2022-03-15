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

import static gestion_images.Test3.IMAGE_FILTER;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.*;
import javax.swing.event.*;

/*
 * SliderDemo.java requires all the files in the images/doggy
 * directory.
 */
public class SliderDemo extends JPanel
       
        {// implements        WindowListener,ActionListener,PropertyChangeListener ChangeListener 
    //Set up animation parameters.

//    private int FPS_MIN = 0;
    private int FPS_MAX;
//    private int FPS_INIT = 0;    //initial frames per second
    int frameNumber = 0;
    int NUM_FRAMES;
    ImageIcon[] images;
//    File[] liste_images;
//    int delay;
//    Timer timer;
//    boolean frozen = false;
//File representing the folder that you select using a FileChooser

//    static File dir ;
    File[] liste_files;
//array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp","jpg" //and other formats you need
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

    public SliderDemo(String chemin) {
        final File dir = new File(chemin);
        liste_files=dir.listFiles(IMAGE_FILTER);
//         Test3 recup_images = new Test3();
//        this.liste_images=recup_images.getFiles();
//        FPS_MAX =liste_images.length;
        NUM_FRAMES=liste_files.length;
        System.out.println(liste_files.length);
         images = new ImageIcon[NUM_FRAMES];
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
       
//        delay = 1000 / FPS_INIT;
        //Create the label.
        JLabel sliderLabel = new JLabel("Frames Per Second", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create the slider.
        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                0, liste_files.length, 0);

//        framesPerSecond.addChangeListener(this);

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

        framesPerSecond.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {

                    int fps = (int) framesPerSecond.getValue();
                    frameNumber = fps;
                    updatePicture(fps);

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

        add(picture);

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//        //Set up a timer that calls this object's action handler.
//        timer = new Timer(delay, this);
//        timer.setInitialDelay(delay * 7); //We pause animation twice per cycle
//                                          //by restarting the timer
//        timer.setCoalesce(true);
    }

//    /**
//     * Add a listener for window events.
//     */
//    void addWindowListener(Window w
//    ) {
//        w.addWindowListener(this);
//    }
//
//    //React to window events.
//
//    public void windowIconified(WindowEvent e) {
////        stopAnimation();
//    }
//
//    public void windowDeiconified(WindowEvent e) {
////        startAnimation();
//    }
//
//    public void windowOpened(WindowEvent e) {
//    }
//
//    public void windowClosing(WindowEvent e) {
//    }
//
//    public void windowClosed(WindowEvent e) {
//    }
//
//    public void windowActivated(WindowEvent e) {
//    }
//
//    public void windowDeactivated(WindowEvent e) {
//    }

    /**
     * Listen to the slider.
     */
//    public void stateChanged(ChangeEvent e) {
//        JSlider source = (JSlider) e.getSource();
//        if (!source.getValueIsAdjusting()) {
//            int fps = (int) source.getValue();
//            frameNumber = fps;
//            updatePicture(fps); //display the next picture
////            startAnimation(fps);
//            System.out.println(fps);
////            changeImage();
////            if (fps == 0) {
////                if (!frozen) stopAnimation();
////            } else {
////                delay = 1000 / fps;
////                timer.setDelay(delay);
////                timer.setInitialDelay(delay * 10);
////                if (frozen) startAnimation();
////            }
//        }
//    }

//    public void startAnimation(int fps) {
//        //Start (or restart) animating!
////        timer.start();
////        frozen = false;
//        //Advance the animation frame.
////        if (frameNumber == (NUM_FRAMES - 1)) {
////            frameNumber = 0;
////        } else {
////            frameNumber++;
////        }
//        
////        updatePicture(frameNumber); //display the next picture
//    }
//    public void stopAnimation() {
//        //Stop the animating thread.
//        timer.stop();
//        frozen = true;
//    }
    /**
     * Update the label to display the image for the current frame.
     */
    protected void updatePicture(int frameNum) {
        //Get the image if we haven't already.
        if (images[frameNumber] == null) {
            images[frameNumber] = createImageIcon(liste_files[frameNum].getPath());
//        ("images/doggy/T"
//                    + frameNumber
//                    + ".gif");
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
     */
    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = SliderDemo.class.getResource(path);
//        if (imgURL != null) {
            return new ImageIcon(path);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    public static void createAndShowGUI(String chemin) {
        //Create and set up the window.
        JFrame frame = new JFrame("SliderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SliderDemo animator = new SliderDemo(chemin);

        //Add content to the window.
        frame.add(animator, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
//        animator.startAnimation(); 
    }

//    public static void main(String[] args) {
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }

//    @Override
//    public void propertyChange(PropertyChangeEvent e) {
//        JSlider source = (JSlider) e.getSource();
//        if (!source.getValueIsAdjusting()) {
//            int fps = (int) source.getValue();
//            frameNumber = fps;
//            updatePicture(fps); //display the next picture
////            startAnimation(fps);
//            System.out.println(fps);
//        }
//    }
}
