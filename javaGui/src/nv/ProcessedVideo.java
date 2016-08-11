package nv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import org.jcodec.api.JCodecException;
import org.jcodec.api.awt.FrameGrab;
import org.jcodec.common.FileChannelWrapper;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.Size;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import com.googlecode.javacv.FFmpegFrameGrabber;

import io.swagger.client.ApiException;
import nv.ProcessedVideo.State;

public class ProcessedVideo extends Observable {
    
    public enum State {
        NotProcessed, Processing, Processed
    }
    
    private FrameGrab grab;
    private int videoFrame = 0;
    private int jsonFrame = 0; // refers to the processed images in images.
    private File videoPath;
    private ArrayList<ProcessedImage> images = new ArrayList<ProcessedImage>();
    private String processingStatusCode = "";
    private String processingStatusMessage = "";
    
    private State state = State.NotProcessed;
    
    public ProcessedVideo(File aVideoPath) {
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        videoPath = aVideoPath;
        
        FileChannelWrapper ch;
		try {
			ch = NIOUtils.readableFileChannel(aVideoPath);
			grab = new FrameGrab(ch);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JCodecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*VideoCapture vc = new VideoCapture();//aVideoPath.getPath());
		vc.open(aVideoPath.getPath());
		double fps = vc.get(CAP_PROP_FPS); // FPS
		double frameCount = vc.get(7); // FRAME_COUNT
		double width = vc.get(3);
		double height = vc.get(3);
		System.out.println("fps : " + fps);
		System.out.println("frame count : " + frameCount);
		System.out.println("Width : " + width);
		System.out.println("Height : " + height);
		
		for(int i = 0; i <= 37; ++i){
			System.out.println(vc.get(i));
		}*/
        
		/*
		images.add(new ProcessedImage(null));*/
        
        //FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(aVideoPath.getName());
        /*images = new ArrayList<ProcessedImage>(frameGrabber.getNumBuffers());
        System.out.println(Integer.toString(images.size()));*/
    }
    
    public void addImage(ProcessedImage image) {
    	images.add(image);
    }
    
    public BufferedImage getFrame(int frame) throws IOException, JCodecException {
    	System.out.println("Get frame " + Integer.toString(frame));
    	//grab.
    	return ((FrameGrab) grab.seekToFramePrecise(frame)).getFrame();
    }
    
    public int getVideoFrame() {
    	return videoFrame;
    }
    
    public int getJsonFrame() {
    	return jsonFrame;
    }
    
    public void increaseFrame() {
    	/*if(!(jsonFrame == 0 && videoFrame == 0)) {
    		jsonFrame = 0;
    		videoFrame = 0;
    		return;
    	}*/
    	if (images.size() != 0) {
    		if (jsonFrame < images.size() -1) {
    			++jsonFrame;
    			while (images.get(jsonFrame).sameDotsAs(images.get(jsonFrame-1))){
    				++jsonFrame;
    				System.out.println("Skip json frame");
    			}
    		}
    		else jsonFrame = 0;
    	}
    	if (jsonFrame == 0) videoFrame = 0;
    	else ++videoFrame;
    	/*if (videoFrame == 0) videoFrame = 1;
    	else videoFrame = 0;
    	if (jsonFrame == 0) jsonFrame = 1;
    	else jsonFrame = 0;*/
    }
    
    public void resetFrameIndices() {
    	videoFrame = 0;
    	jsonFrame = 0;
    }
    
    public File getVideoPath() {
        return videoPath;
    }

    public ArrayList<ProcessedImage> getImages() {
        return images;
    }

    public String getProcessingStatusCode() {
        return processingStatusCode;
    }

    public String getProcessingStatusMessage() {
        return processingStatusMessage;
    }

    public void setProcessingStatusCode(String processingStatusCode) {
        this.processingStatusCode = processingStatusCode;
    }

    public void setProcessingStatusMessage(String processingStatusMessage) {
        this.processingStatusMessage = processingStatusMessage;
    }

    synchronized public void setNotProcessed() {
        state = State.NotProcessed;
        images.clear();
        processingStatusCode = "";
        processingStatusMessage = "";
        changed();
    }
    
    synchronized public void setProcessing() {
        state = State.Processing;
        changed();
    }
    
    synchronized public void setProcessed() {
        state = State.Processed;
        changed();
    }
    
    synchronized public State getState() {
        return state;
    }
    
    public void changed()
    {
        setChanged();
        notifyObservers();
    }
    
    @Override
    public String toString(){
        String res = videoPath.getName() + " (";
        if (state == State.Processed) {
            if (processingStatusCode.equals("success")){
                res += "Processing OK";
            } else {
                res += "Processing failed : "+processingStatusMessage;
            }
        } else if (state == State.Processing) {
            res += "Processing ...";
        } else {
            res += "Not processed";
        }
        res += ")";
        return res;
    }
    
    synchronized public void fromJSON(JSONArray jsonArray) throws JSONException {
    	processingStatusCode = "success";
    	try {
			for(int i=0; i < jsonArray.length(); ++i){
				System.out.println("Frame : " + Integer.toString(i));
				JSONObject json = jsonArray.getJSONObject(i);
				//ProcessedImage image = processedVideo.getImages().get(i);
				ProcessedImage image = new ProcessedImage(null);
				image.fromJSON(json, "v1-Compact");
				this.addImage(image);
				image.setProcessed();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	/*images.clear();
    	JSONArray images = json.getJSONArray("images");
    	JSONObject image = images.getJSONObject(0);
    	JSONArray jsonfaces = image.getJSONArray("faces");
    	if (jsonfaces.length() != 0){
    		processingStatusCode = "success";
            for (int fi = 0; fi < jsonfaces.length(); fi++) {
                ProcessedFace pf = new ProcessedFace();
                pf.fromJSON(jsonfaces.getJSONObject(fi));
                images.add(pf);
            }
    	}
    	*/
    }
}
