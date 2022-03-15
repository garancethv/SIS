/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_images;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Chloe
 */
class Zone extends JComponent {
   private BufferedImage image;
   public Zone(String chemin_image) throws IOException {
      BufferedImage source = ImageIO.read(new File(chemin_image));

      BufferedImage imageRetaillée = new BufferedImage(source.getWidth()/10, source.getHeight()/10, source.getType());
      AffineTransform retailler = AffineTransform.getScaleInstance(0.1, 0.1);
      int interpolation = AffineTransformOp.TYPE_BICUBIC;
      AffineTransformOp retaillerImage = new AffineTransformOp(retailler, interpolation);
      retaillerImage.filter(source, imageRetaillée);

      image = new BufferedImage(source.getHeight()/10, source.getWidth()/10, source.getType());
      double centreDeRotation = imageRetaillée.getHeight()/2;
      AffineTransform pivoter = AffineTransform.getRotateInstance(Math.toRadians(90), centreDeRotation, centreDeRotation);
      AffineTransformOp pivoterImage = new AffineTransformOp(pivoter, interpolation);
      pivoterImage.filter(imageRetaillée, image);      
   }
   protected void paintComponent(Graphics surface) {
      surface.drawImage(image, 0, 0, null);   
   }   
}
