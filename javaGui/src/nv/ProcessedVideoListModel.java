package nv;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

public class ProcessedVideoListModel extends AbstractListModel<ProcessedVideo> implements Observer {

    final private List<ProcessedVideo> processedVideos = new ArrayList<>();
    
    public ProcessedVideoListModel() {
    }

    public void addProcessedVideo(ProcessedVideo aVideo) {
        if (processedVideos.add(aVideo)) {
            aVideo.addObserver(this);
            this.fireIntervalAdded(this, processedVideos.size()-1, processedVideos.size()-1);
        }
    }
    
    public void clear() {
        int size = processedVideos.size();
        for (ProcessedVideo img : processedVideos)
        {
            img.deleteObserver(this);
        }
        if (size > 0) {
            this.fireIntervalRemoved(this, 0, size-1);
        }
        processedVideos.clear();
    }
    
    @Override
    public int getSize() {
        return processedVideos.size();
    }

    @Override
    public ProcessedVideo getElementAt(int index) {
        return processedVideos.get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
        ProcessedVideo video = (ProcessedVideo)o;
        int index = processedVideos.indexOf(video);
        this.fireContentsChanged(this, index, index);
    }

}
