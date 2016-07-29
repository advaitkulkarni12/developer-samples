/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedImagePanel extends JPanel implements Observer {

    private ProcessedImage processedImage = null;
    private BufferedImage  image = null;
    private Image  scaledImage = null;
    private float scaleFactor = 1.0f;
    
    public void setProcessedImage(ProcessedImage img) {
        if (processedImage != null) {
            processedImage.deleteObserver(this);
        }
        processedImage = img;
        processedImage.addObserver(this);
        try {
            image = ImageIO.read(processedImage.getImagePath());
        } catch (IOException ex) {
            Logger.getLogger(ProcessedImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.repaint();
    }
    
    private void setScaledImage() {
        if ( image != null ) {

            //use floats so division below won't round
            float iw = image.getWidth();
            float ih = image.getHeight();
            float pw = this.getWidth();   //panel width
            float ph = this.getHeight();  //panel height
            
            
            if ( pw < iw || ph < ih ) {
                
                /* compare some ratios and then decide which side of image to anchor to panel
                   and scale the other side
                   (this is all based on empirical observations and not at all grounded in theory)*/
                
                //System.out.println("pw/ph=" + pw/ph + ", iw/ih=" + iw/ih);

                if ( (pw / ph) > (iw / ih) ) {
                    scaleFactor = (float)ph/(float)ih;
                    iw = -1;
                    ih = ph;
                    
                } else {
                    scaleFactor = (float)pw/(float)iw;
                    iw = pw;
                    ih = -1;
                }
                
                //prevent errors if panel is 0 wide or high
                if (iw == 0) {
                    iw = -1;
                }
                if (ih == 0) {
                    ih = -1;
                }
                
                scaledImage = image.getScaledInstance(
                            new Float(iw).intValue(), new Float(ih).intValue(), Image.SCALE_DEFAULT);
                
            } else {
                scaledImage = image;
                scaleFactor = 1.0f;
            }
            //System.out.println("iw = " + iw + ", ih = " + ih + ", pw = " + pw + ", ph = " + ph);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        setScaledImage();
        // This call will paint the label and the focus rectangle.
        if (scaledImage != null) {
            g.drawImage(scaledImage, 0, 0, this);
            if (processedImage.getFaces().size() > 0) {
                ProcessedFace face = processedImage.getFaces().get(0);
                
                // Draw center + face rect
                float scaledCenterX = (float) (face.getCenterX() * scaleFactor);
                float scaledCenterY = (float) (face.getCenterY() * scaleFactor);
                g.setColor(Color.red);
                g.fillRect((int)scaledCenterX - 2, (int)scaledCenterY -2, 5, 5);
                float scaledWidth = (float) (face.getWidth() * scaleFactor);
                float scaledHeight = (float) (face.getHeight() * scaleFactor);
               
                g.drawRect(
                        (int)(scaledCenterX - (scaledWidth/2.0)), 
                        (int)(scaledCenterY - (scaledHeight/2.0)), 
                        (int)scaledWidth, (int)scaledHeight);
                
                // Draw points
                for (Double[] p : face.getPoints()) {
                    float scaledPX = (float) (p[0] * scaleFactor);
                    float scaledPY = (float) (p[1] * scaleFactor);
                    g.setColor(Color.red);
                    g.fillRect((int)scaledPX - 2, (int)scaledPY -2, 5, 5);
                }
            }  
        }
        //super.paintComponent(g);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
