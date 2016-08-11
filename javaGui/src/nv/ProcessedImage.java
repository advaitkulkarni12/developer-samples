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
    private JSONObject json;
    
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
    
    public JSONObject getJson() {
    	return json;
    }
    
    public void changed()
    {
        setChanged();
        notifyObservers();
    }
    
    public String getStatus() {
    	if (state == State.Processed) {
            if (processingStatusCode.equals("success")){
                return "Processing OK";
            } else {
                return "Processing failed : "+processingStatusMessage;
            }
        } else if (state == State.Processing) {
            return "Processing ...";
        } else {
            return "Not processed";
        }
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
    
    synchronized public void fromJSON(JSONObject json, String format) throws JSONException {
    	faces.clear();
    	if (format == "v1-Compact"){
	    	JSONArray images = json.getJSONArray("images");
	    	JSONObject image = images.getJSONObject(0);
	    	JSONArray jsonfaces = image.getJSONArray("faces");
	    	if (jsonfaces.length() != 0){
	    		processingStatusCode = "success";
	            for (int fi = 0; fi < jsonfaces.length(); fi++) {
	                ProcessedFace pf = new ProcessedFace();
	                pf.fromJSON(jsonfaces.getJSONObject(fi), format);
	                faces.add(pf);
	            }
	    	}
    	}
    	else if(format == "v2-Full") {
    		JSONArray jsonfaces = json.getJSONArray("FaceData");
    		if(jsonfaces.length() != 0){
    			processingStatusCode = "success";
	    		for(int fi = 0; fi < jsonfaces.length(); ++fi) {
	    			ProcessedFace pf = new ProcessedFace();
	    			pf.fromJSON(jsonfaces.getJSONObject(fi), format);
	    			faces.add(pf);
	    		}
    		}
    	}
    }
    
    synchronized public void fromJSON(JSONObject json) throws JSONException {
    	fromJSON(json, "v1-Compact");
    }
    
    public Boolean sameDotsAs(ProcessedImage other) {
    	if (faces.size() != other.getFaces().size())
    		return false;
    	Boolean same = true;
    	for (int i = 0; i < faces.size(); ++i) {
    		same = same && faces.get(i).sameDotsAs(other.getFaces().get(i));
    		/*if (!faces.get(i).sameDotsAs(other.getFaces().get(i))) {
    			System.out.println("Faces " + Integer.toString(i) + " are not the same.");
    		}*/
    	}
    	return same;
    }

	public void setJSON(JSONObject json) {
		this.json = json;
	}
}
