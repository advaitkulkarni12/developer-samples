/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractListModel;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedImageListModel extends AbstractListModel<ProcessedImage> implements Observer {

    final private List<ProcessedImage> processedImages = new ArrayList<>();
    
    public ProcessedImageListModel() {
    }

    public void addProcessedImage(ProcessedImage anImage) {
        if (processedImages.add(anImage)) {
            anImage.addObserver(this);
            this.fireIntervalAdded(this, processedImages.size()-1, processedImages.size()-1);
        }
    }
    
    public void clear() {
        int size = processedImages.size();
        for (ProcessedImage img : processedImages)
        {
            img.deleteObserver(this);
        }
        if (size > 0) {
            this.fireIntervalRemoved(this, 0, size-1);
        }
        processedImages.clear();
    }
    
    @Override
    public int getSize() {
        return processedImages.size();
    }

    @Override
    public ProcessedImage getElementAt(int index) {
        return processedImages.get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
        ProcessedImage image = (ProcessedImage)o;
        int index = processedImages.indexOf(image);
        this.fireContentsChanged(this, index, index);
    }
    
}
