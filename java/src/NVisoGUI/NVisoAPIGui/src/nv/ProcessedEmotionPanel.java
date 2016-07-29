/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedEmotionPanel extends JPanel implements Observer {

    private static int LABEL_ZONE_HEIGHT = 50;
    
    private static Color[] BAR_COLORS = {
        new Color(129,129,8),
        new Color(45,19,204),
        new Color(173,218,29),
        new Color(200,2,1),
        new Color(252,108,16),
        new Color(11,139,204),
        new Color(203,9,108),
    };
            
    private ProcessedImage processedImage = null;
    
    public void setProcessedImage(ProcessedImage img) {
        if (processedImage != null) {
            processedImage.deleteObserver(this);
        }
        processedImage = img;
        processedImage.addObserver(this);
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        // This call will paint the label and the focus rectangle.
        if (processedImage != null) {
            if (processedImage.getFaces().size() > 0) {
                ProcessedFace face = processedImage.getFaces().get(0);
                for (int i = 0; i < ProcessedFace.ALL_EMOTIONS.length; i++) {
                    g.setColor(BAR_COLORS[i]);
                    int totalHeight = this.getHeight() - LABEL_ZONE_HEIGHT;
                    int x = (int)((float)i * (float)this.getWidth() / (float)ProcessedFace.ALL_EMOTIONS.length);
                    int w = (int)((float)(i+1) * (float)this.getWidth() / (float)ProcessedFace.ALL_EMOTIONS.length) - x;
                    int h = (int)((float)totalHeight * face.getEmotionProfile().get(ProcessedFace.ALL_EMOTIONS[i]));
                    int y = totalHeight - h;
                    g.fillRect(x, y, w, h);
                    g.setColor(Color.BLACK);
                    g.drawString(ProcessedFace.ALL_EMOTIONS[i], x, totalHeight + LABEL_ZONE_HEIGHT / 2);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
