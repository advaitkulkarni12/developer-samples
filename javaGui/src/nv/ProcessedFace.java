/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nv;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kevin Georgy
 */
public class ProcessedFace {
    
    public final static String EMOTION_NEUTRAL   = "neutral";
    public final static String EMOTION_SADNESS   = "sadness";
    public final static String EMOTION_DISGUST   = "disgust";
    public final static String EMOTION_ANGER     = "anger";
    public final static String EMOTION_SURPRISE  = "surprise";
    public final static String EMOTION_FEAR      = "fear";
    public final static String EMOTION_HAPPINESS = "happiness";
    public final static String[] ALL_EMOTIONS = {
        EMOTION_NEUTRAL,
        EMOTION_SADNESS,
        EMOTION_DISGUST,
        EMOTION_ANGER,
        EMOTION_SURPRISE,
        EMOTION_FEAR,
        EMOTION_HAPPINESS,
    };
    
    public final static String FACE_POINT_GROUP_EYE_LEFT   = "eye_left";
    public final static int FACE_POINT_GROUP_EYE_LEFT_COUNT   = 4;
    public final static String FACE_POINT_GROUP_EYE_BROW_RIGHT  = "eye_brow_right";
    public final static int FACE_POINT_GROUP_EYE_BROW_RIGHT_COUNT  = 3;
    public final static String FACE_POINT_GROUP_FORHEAD  = "forehead";
    public final static int FACE_POINT_GROUP_FORHEAD_COUNT  = 3;
    public final static String FACE_POINT_GROUP_MOUTH  = "mouth";
    public final static int FACE_POINT_GROUP_MOUTH_COUNT  = 4;
    public final static String FACE_POINT_GROUP_EYE_BROW_LEFT  = "eye_brow_left";
    public final static int FACE_POINT_GROUP_EYE_BROW_LEFT_COUNT  = 3;
    public final static String FACE_POINT_GROUP_CHIN  = "chin";
    public final static int FACE_POINT_GROUP_CHIN_COUNT  = 5;
    public final static String FACE_POINT_GROUP_NOSE  = "nose";
    public final static int FACE_POINT_GROUP_NOSE_COUNT  = 3;
    public final static String FACE_POINT_GROUP_EYE_RIGHT  = "eye_right";
    public final static int FACE_POINT_GROUP_EYE_RIGHT_COUNT  = 4;
    public final static String[] ALL_POINT_GROUPS = {
        FACE_POINT_GROUP_EYE_LEFT,
        FACE_POINT_GROUP_EYE_BROW_RIGHT,
        FACE_POINT_GROUP_FORHEAD,
        FACE_POINT_GROUP_MOUTH,
        FACE_POINT_GROUP_EYE_BROW_LEFT,
        FACE_POINT_GROUP_CHIN,
        FACE_POINT_GROUP_NOSE,
        FACE_POINT_GROUP_EYE_RIGHT,
    };
    public final static int[] ALL_POINT_COUNT = {
        FACE_POINT_GROUP_EYE_LEFT_COUNT,
        FACE_POINT_GROUP_EYE_BROW_RIGHT_COUNT,
        FACE_POINT_GROUP_FORHEAD_COUNT,
        FACE_POINT_GROUP_MOUTH_COUNT,
        FACE_POINT_GROUP_EYE_BROW_LEFT_COUNT,
        FACE_POINT_GROUP_CHIN_COUNT,
        FACE_POINT_GROUP_NOSE_COUNT,
        FACE_POINT_GROUP_EYE_RIGHT_COUNT,
    };
    
    private HashMap<String,Double> emotionProfile;
    private double width;
    private double height;
    private double centerX;
    private double centerY;
    private ArrayList<Double[] > points;
    
    public ProcessedFace() {
        points = new ArrayList<>();
        emotionProfile = new HashMap<>();
        emotionProfile.put(EMOTION_NEUTRAL, Double.NaN);
        emotionProfile.put(EMOTION_SADNESS, Double.NaN);
        emotionProfile.put(EMOTION_DISGUST, Double.NaN);
        emotionProfile.put(EMOTION_ANGER, Double.NaN);
        emotionProfile.put(EMOTION_SURPRISE, Double.NaN);
        emotionProfile.put(EMOTION_FEAR, Double.NaN);
        emotionProfile.put(EMOTION_HAPPINESS, Double.NaN);
    }

    public HashMap<String, Double> getEmotionProfile() {
        return emotionProfile;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public ArrayList<Double[]> getPoints() {
        return points;
    }
    
    public void fromJSON(JSONObject json, String format) throws JSONException {
        // Load the emotion profile
    	if(format == "v1-Compact") {
	        JSONObject attribute = json.getJSONObject("attribute");
	        JSONObject emotion = attribute.getJSONObject("emotion");
	        emotionProfile.put(EMOTION_NEUTRAL, emotion.getDouble(EMOTION_NEUTRAL));
	        emotionProfile.put(EMOTION_SADNESS, emotion.getDouble(EMOTION_SADNESS));
	        emotionProfile.put(EMOTION_DISGUST, emotion.getDouble(EMOTION_DISGUST));
	        emotionProfile.put(EMOTION_ANGER, emotion.getDouble(EMOTION_ANGER));
	        emotionProfile.put(EMOTION_SURPRISE, emotion.getDouble(EMOTION_SURPRISE));
	        emotionProfile.put(EMOTION_FEAR, emotion.getDouble(EMOTION_FEAR));
	        emotionProfile.put(EMOTION_HAPPINESS, emotion.getDouble(EMOTION_HAPPINESS));
	        // load the face rect
	        width = json.getDouble("width");
	        height = json.getDouble("height");
	        JSONObject centerjson = json.getJSONObject("center");
	        centerX = centerjson.getDouble("x");
	        centerY = centerjson.getDouble("y");
	        // Load points
	        points.clear();
	        for (int gi = 0; gi < ALL_POINT_GROUPS.length; gi++) {
	            JSONObject groupjson = json.getJSONObject(ALL_POINT_GROUPS[gi]);
	            int count = ALL_POINT_COUNT[gi];
	            for (int pi = 1; pi <= count; pi++) {
	                Double[] point = new Double[2];
	                point[0] = groupjson.getDouble("x"+Integer.toString(pi));
	                point[1] = groupjson.getDouble("y"+Integer.toString(pi));
	                points.add(point);
	            }
	        }
    	}
    	else if (format == "v2-Full") {
    		JSONObject emotion = json.getJSONObject("Emotion");
    		emotionProfile.put(EMOTION_NEUTRAL, emotion.getJSONObject("Neutral").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_SADNESS, emotion.getJSONObject("Sadness").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_DISGUST, emotion.getJSONObject("Disgust").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_ANGER, emotion.getJSONObject("Anger").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_SURPRISE, emotion.getJSONObject("Surprise").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_FEAR, emotion.getJSONObject("Fear").getJSONObject("Intensity").getDouble("Value"));
	        emotionProfile.put(EMOTION_HAPPINESS, emotion.getJSONObject("Happiness").getJSONObject("Intensity").getDouble("Value"));
	        
	        width = json.getJSONObject("Location").getDouble("Width");
	        height = json.getJSONObject("Location").getDouble("Height");
	        centerX = json.getJSONObject("Location").getDouble("X");
	        centerY = json.getJSONObject("Location").getDouble("Y");
	        
	        points.clear();
	        JSONObject groupjson = json.getJSONObject("Landmark170");
	        for (int gi = 0; gi < 170; ++gi) {
	        	Double[] point = new Double[2];
	        	String n;
	        	if (gi < 10) n = "00" + Integer.toString(gi);
	        	else if(gi >= 10 && gi < 100) n = "0" + Integer.toString(gi);
	        	else n = Integer.toString(gi);
	        	point[0] = groupjson.getJSONObject("Pt_" + n).getDouble("X");
	        	point[1] = groupjson.getJSONObject("Pt_" + n).getDouble("Y");
	        	points.add(point);
	        }
	        // should add the points in this format ...
    	}
    }
    
    public void fromJSON(JSONObject json) throws JSONException {
    	fromJSON(json, "v1-Compact");
    }

	public boolean sameDotsAs(ProcessedFace processedFace) {
		//return points.equals(processedFace.getPoints());
		Boolean same = true;
		for (int i = 0; i < points.size(); ++i) {
			same = same && (points.get(i)[0].equals(processedFace.getPoints().get(i)[0])) && (points.get(i)[1].equals(processedFace.getPoints().get(i)[1]));
			/*if (!(points.get(i)[0].equals(processedFace.getPoints().get(i)[0]))){
				System.out.println(points.get(i)[0] + "!=" + processedFace.getPoints().get(i)[0]);
			}
			if (!(points.get(i)[1].equals(processedFace.getPoints().get(i)[1]))){
				System.out.println(points.get(i)[1] + "!=" + processedFace.getPoints().get(i)[1]);
			}*/
		}
		return same;
	}
}
