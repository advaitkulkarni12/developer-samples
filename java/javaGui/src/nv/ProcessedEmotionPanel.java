/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import org.json.JSONException;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedEmotionPanel extends JScrollPane implements Observer {

    private static int LABEL_ZONE_HEIGHT = 50;
    private static JTextArea jsonText = new JTextArea();
    ProcessedImage processedImage = null;
    
    /*private static Color[] BAR_COLORS = {
        new Color(129,129,8),
        new Color(45,19,204),
        new Color(173,218,29),
        new Color(200,2,1),
        new Color(252,108,16),
        new Color(11,139,204),
        new Color(203,9,108),
    };*/
       
    public ProcessedEmotionPanel() {
    	super(jsonText,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
                );
    	
    	this.setSize(new Dimension(300,300));
    	UIManager.getLookAndFeelDefaults().put("ScrollBar.minimumThumbSize", new Dimension(30, 30));
    	//this.put("ScrollBar.minimumThumbSize", new Dimension(29, 1));
    	
    	//jsonText.setSize(200, 300);
    	//jsonText.setText("No file processed");
    	jsonText.setLineWrap(true);
    	jsonText.setWrapStyleWord(true);
        jsonText.setOpaque(false);
        jsonText.setEditable(false);
        
        //this.setMaximumSize(new Dimension(800, 240));
        //System.out.println(this.getSize());
        
        //this.setVisible(true);
        //this.add(jsonText);
        //this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
         /*scrollPane =  new JScrollPane(jsonText,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
                );
         scrollPane.setSize(200, 300);
        this.add(scrollPane);*/
        
    	//this.add(jsonText);
    }
    
    public void setProcessedImage(ProcessedImage img) {
        if (processedImage != null) {
            processedImage.deleteObserver(this);
        }
        processedImage = img;
        processedImage.addObserver(this);
        if(processedImage.getJson() != null) {
	        try {
				jsonText.setText(processedImage.getJson().toString(3));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        this.repaint();
    }
    
    public void setProcessedImage(ProcessedVideo video, int frame) {
    	if (processedImage != null) {
            processedImage.deleteObserver(this);
        }
    	if (video.getImages().size() != 0) {
        	processedImage = video.getImages().get(frame);
        }
        else {
        	processedImage = new ProcessedImage(null);
        }
    	processedImage.addObserver(this);
        this.repaint();
	}
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        // This call will paint the label and the focus rectangle.
        /*if (processedImage != null) {
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
        }*/
        if (processedImage != null && processedImage.getJson() == null) {
        	jsonText.setText("Image not processed");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

	
}
