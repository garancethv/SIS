/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Test3 {

    public void Test3() {
        final File dir = new File(System.getProperty("user.home") + "\\Dropbox\\projet_SIS\\PACS\\" + "dateExamen_nom_prenom");
        liste_files=dir.listFiles(IMAGE_FILTER);
        System.out.println("fgg");
         for ( File f : liste_files) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(f);
//you probably want something more involved here
//to display in your UI
                    System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());
                } catch ( IOException e) {
//handle errors here
                }
       
    }
    }
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
    

//    public static void main(String[] args) {
//        if (dir.isDirectory()) { //make sure it's a directory
//            for (final File f : dir.listFiles(IMAGE_FILTER)) {
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(f);
////you probably want something more involved here
////to display in your UI
//                    System.out.println("image: " + f.getName());
//                    System.out.println(" width : " + img.getWidth());
//                    System.out.println(" height: " + img.getHeight());
//                    System.out.println(" size  : " + f.length());
//                } catch (final IOException e) {
////handle errors here
//                }
//            }
//        }
//    }

    public File[] getFiles() {
//        for ( File f : liste_files) {
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(f);
////you probably want something more involved here
////to display in your UI
//                    System.out.println("image: " + f.getName());
//                    System.out.println(" width : " + img.getWidth());
//                    System.out.println(" height: " + img.getHeight());
//                    System.out.println(" size  : " + f.length());
//                } catch ( IOException e) {
////handle errors here
//                }
//       
//    } 
        return liste_files;
}}

