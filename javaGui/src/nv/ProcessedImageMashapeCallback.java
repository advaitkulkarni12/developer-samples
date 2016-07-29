/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import com.mashape.client.http.MashapeCallback;
import com.mashape.client.http.MashapeResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedImageMashapeCallback implements MashapeCallback<JSONObject> {
    
    private ProcessedImage processedImage;
    
    public ProcessedImageMashapeCallback(ProcessedImage anImage) {
        processedImage = anImage;
    }

    @Override
    public void requestCompleted(MashapeResponse<JSONObject> mr) {
        if (mr.getCode() == 200) {
            try {
                processedImage.fromJSON(mr.getBody());
                processedImage.setProcessed(); // -> changed() -> notifyObservers() which is and event !
                //processedImage.changed();
            } catch (JSONException ex) {
                Logger.getLogger(ProcessedImageMashapeCallback.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            processedImage.setProcessingStatusCode("error");
            try {
                processedImage.setProcessingStatusMessage(mr.getBody().getString("message"));
            } catch (JSONException ex) {
                Logger.getLogger(ProcessedImageMashapeCallback.class.getName()).log(Level.SEVERE, null, ex);
            }
            processedImage.setProcessed();
            //processedImage.changed();
        }
    }

    @Override
    public void errorOccurred(Exception excptn) {
        processedImage.setProcessingStatusCode("error");
        processedImage.setProcessingStatusMessage("Server error");
        processedImage.setProcessed();
        //processedImage.changed();
    }
}
