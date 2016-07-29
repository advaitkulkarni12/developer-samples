/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedImage extends Observable{
    
    public enum State {
        NotProcessed, Processing, Processed
    }
    
    private File imagePath;
    private ArrayList<ProcessedFace> faces = new ArrayList<>();
    private String processingStatusCode = "";
    private String processingStatusMessage = "";
    
    private State state = State.NotProcessed;
    
    public ProcessedImage(File anImagePath) {
        imagePath = anImagePath;
    }
    
    public File getImagePath() {
        return imagePath;
    }

    public ArrayList<ProcessedFace> getFaces() {
        return faces;
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
        faces.clear();
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
        String res = imagePath.getName() + " (";
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
    
    synchronized public void fromJSON(JSONObject json) throws JSONException {
        /*// Reset
        faces.clear();
        processingStatusCode = "";
        processingStatusMessage = "";
        
        // Check the error
        JSONObject status = json.getJSONObject("status");
        processingStatusCode = status.getString("code");
        processingStatusMessage = status.getString("message");
        
        if (processingStatusCode.equals("success")) {
            // Get all faces
            JSONArray images = json.getJSONArray("images");
            if (images.length() != 1) {
                throw new JSONException("Image count should be one");
            }
            JSONObject image = images.getJSONObject(0);
            JSONObject imageStatus = image.getJSONObject("status");
            processingStatusCode = imageStatus.getString("code");
            processingStatusMessage = imageStatus.getString("message");
            if (processingStatusCode.equals("success")) {
                JSONArray jsonfaces = image.getJSONArray("faces");
                for (int fi = 0; fi < jsonfaces.length(); fi++) {
                    ProcessedFace pf = new ProcessedFace();
                    pf.fromJSON(jsonfaces.getJSONObject(fi));
                    faces.add(pf);
                }
            }
        }
        */
    	faces.clear();
    	JSONArray images = json.getJSONArray("images");
    	JSONObject image = images.getJSONObject(0);
    	JSONArray jsonfaces = image.getJSONArray("faces");
    	if (jsonfaces.length() != 0){
    		processingStatusCode = "success";
            for (int fi = 0; fi < jsonfaces.length(); fi++) {
                ProcessedFace pf = new ProcessedFace();
                pf.fromJSON(jsonfaces.getJSONObject(fi));
                faces.add(pf);
            }
    	}
    	
    }
}
