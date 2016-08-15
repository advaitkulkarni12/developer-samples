package com.nviso;


import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;
import org.json.JSONArray;
//import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.client.authentication.Authentication;
import com.mashape.client.authentication.AuthenticationParameter;
import com.mashape.client.authentication.QueryAuthentication;
import com.mashape.client.http.ContentType;
import com.mashape.client.http.HttpClient;
import com.mashape.client.http.HttpMethod;
import com.mashape.client.http.MashapeCallback;
import com.mashape.client.http.MashapeResponse;
import com.mashape.client.http.ResponseType;

import io.swagger.client.ApiException;
import io.swagger.client.api.PhotoApi;
import io.swagger.client.api.StreamApi;
import io.swagger.client.api.VideoApi;
import io.swagger.client.model.Key;
import nv.ProcessedImage;
import nv.ProcessedStream;
import nv.ProcessedVideo;



public class nViso3DFIHttpClient {

    private final static String PUBLIC_DNS = "3dfi.nviso.net/api/v1/";
    private List<Authentication> authenticationHandlers;

    public nViso3DFIHttpClient (String appid, String appkey) {
        authenticationHandlers = new LinkedList<Authentication>();
        authenticationHandlers.add(new QueryAuthentication(new AuthenticationParameter("app_id", appid), new AuthenticationParameter("app_key", appkey)));
        
    }
    
    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> analyticsSessionCount(String sessionid, String faceid) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (sessionid != null && !sessionid.equals("")) {
	parameters.put("session_id", sessionid);
        }
        
        
        
        if (faceid != null && !faceid.equals("")) {
	parameters.put("face_id", faceid);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/analytics/session/count/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Asynchronous call with optional parameters.
     */
    public Thread analyticsSessionCount(String sessionid, String faceid, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (sessionid != null && !sessionid.equals("")) {
        
            parameters.put("session_id", sessionid);
        }
        
        
        
        if (faceid != null && !faceid.equals("")) {
        
            parameters.put("face_id", faceid);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/analytics/session/count/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> analyticsSessionEmotionProfile(String sessionid, String faceid, String interpolation, String measure) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (sessionid != null && !sessionid.equals("")) {
	parameters.put("session_id", sessionid);
        }
        
        
        
        if (faceid != null && !faceid.equals("")) {
	parameters.put("face_id", faceid);
        }
        
        
        
        if (interpolation != null && !interpolation.equals("")) {
	parameters.put("interpolation", interpolation);
        }
        
        
        
        if (measure != null && !measure.equals("")) {
	parameters.put("measure", measure);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/analytics/session/emotion/profile/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Synchronous call without optional parameters.
     */
    public MashapeResponse<JSONObject> analyticsSessionEmotionProfile(String sessionid, String faceid) {
        return analyticsSessionEmotionProfile(sessionid, faceid, "", "");
    }


    /**
     * Asynchronous call with optional parameters.
     */
    public Thread analyticsSessionEmotionProfile(String sessionid, String faceid, String interpolation, String measure, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (sessionid != null && !sessionid.equals("")) {
        
            parameters.put("session_id", sessionid);
        }
        
        
        
        if (faceid != null && !faceid.equals("")) {
        
            parameters.put("face_id", faceid);
        }
        
        
        
        if (interpolation != null && !interpolation.equals("")) {
        
            parameters.put("interpolation", interpolation);
        }
        
        
        
        if (measure != null && !measure.equals("")) {
        
            parameters.put("measure", measure);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/analytics/session/emotion/profile/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Asynchronous call without optional parameters.
     */
    public Thread analyticsSessionEmotionProfile(String sessionid, String faceid, MashapeCallback<JSONObject> callback) {
        return analyticsSessionEmotionProfile(sessionid, faceid, "", "", callback);
    }

    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> processEmotionImageByUpload(File image, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format) {
    	PhotoApi api = new PhotoApi();
		String distance = "near";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
        String appId = "AppId";
        String appKey = "AppKey";
        JSONObject json = new JSONObject();
		try {
			String stringResponse = api.photoProcessUpload(image, "v1-Compact", distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
			System.out.println(stringResponse);
			json = new JSONObject(stringResponse);
			// add info to the face in ImageProcess
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// Create response
		//DefaultHttpResponse httpResp = new DefaultHttpResponse();
		HttpResponseFactory factory = new DefaultHttpResponseFactory();
		HttpResponse httpResponse = factory.newHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, null), null);
		MashapeResponse<JSONObject> response = new MashapeResponse<JSONObject>(httpResponse, null, json);
		
		return response;
    }
    
    
    /**
     * Synchronous call without optional parameters.
     */
    public MashapeResponse<JSONObject> processEmotionImageByUpload(File image) {
        return processEmotionImageByUpload(image, "", "", "", "", "", "");
    }

    /**
     * Asynchronous call with optional parameters.
     */
    /*
    public void processEmotionImageByUpload(File image, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format, MashapeCallback<JSONObject> callback, String distance, Boolean multipleFaces) {
        
        // New call to API

		PhotoApi api = new PhotoApi();
		if (distance == null) distance = "near";
        if (multipleFaces == null) multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
        String appId = "AppId";
        String appKey = "AppKey";
        JSONObject json = new JSONObject();
		try {
			String stringResponse = api.photoProcessUpload(image, "v1-Compact", distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
			System.out.println(stringResponse);
			json = new JSONObject(stringResponse);
			// add info to the face in ImageProcess
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// Create response
		//DefaultHttpResponse httpResp = new DefaultHttpResponse();
		HttpResponseFactory factory = new DefaultHttpResponseFactory();
		HttpResponse httpResponse = factory.newHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, null), null);
		MashapeResponse<JSONObject> response = new MashapeResponse<JSONObject>(httpResponse, null, json);
        
        // Call callback
		callback.requestCompleted(response);
    }
    
    public void processEmotionImageByUpload(File image, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format, MashapeCallback<JSONObject> callback) {
    	processEmotionImageByUpload(image, sessionid, sessionseqnumber, sessionmetadata, priority, consent, format, callback, null, null);
    }*/
    
public void processEmotionImageByUpload(ProcessedImage processedImage) {
        
        // New call to API

		PhotoApi api = new PhotoApi();
		String distance = "near";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
        String appId = "AppId";
        String appKey = "AppKey";
        JSONObject jsonFull = new JSONObject();
        String jsonStringCompact;
        String stringResponse = "response";
		try {
			stringResponse = api.photoProcessUpload(processedImage.getImagePath(), "v2-Full", distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
			//System.out.println("Json response : " + stringResponse + "!");
			if (!stringResponse.isEmpty()) {
				jsonFull = new JSONObject(stringResponse);
				jsonStringCompact = formatResponse(stringResponse, "v1-Compact", null, null, null);
				processedImage.fromJSON(new JSONObject(jsonStringCompact));
				processedImage.setJSON(jsonFull);
				processedImage.setProcessed();
			}
			else {
				processedImage.setProcessingStatusCode("failed");
				processedImage.setProcessed();
			}
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
    
    public void processEmotionStreamByUpload(ProcessedStream processedStream) {
    	
    	StreamApi api = new StreamApi();
    	
    	String id = "sessionId";
        String data = "{\"info\": \"Test for example\"}";
        String appId = "AppId";
        String appKey = "AppKey";
		Key sessionKey;
		String key = "";
		try {
			sessionKey = api.streamStart(id, data, appId, appKey);
			key = sessionKey.getSessionKey();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = "v1-Compact";
        String distance = "far";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
		Boolean enableFooter = true;
		Boolean dimSecFaces = true;
    	
    	for (int i=0; i < processedStream.getImages().getSize(); ++i){
    		ProcessedImage current = processedStream.getImages().getElementAt(i);
    		try {
				String response = api.streamProcessUpload(current.getImagePath(), key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, enableFooter, dimSecFaces, appId, appKey);
				JSONObject json = new JSONObject(response);
				current.fromJSON(json, format);
                current.setProcessed();
			} catch (ApiException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	}
    	try {
			api.streamEnd(key, appId, appKey);
		} catch (ApiException e) {
			e.printStackTrace();
		}
    	
    	/*String dataFormat = "v2-Full";
        String sortBy = "timestamp";
        String limitBy = "timestamp";
        Double startLimit = 0.0;
        Double endLimit = 2000000000.0;
        String order = "ascending";
        try {
			String response = api.streamSessionQuery(key, dataFormat, sortBy, limitBy, startLimit, endLimit, order, appId, appKey);
		} catch (ApiException e) {
			e.printStackTrace();
		}*/
    	
    }
    
    public void processEmotionVideoByUpload(ProcessedVideo processedVideo) {
    	VideoApi api = new VideoApi();
    	
    	Integer fps = 24;
    	Integer width = 1280;
        Integer height = 720;
    	Boolean enableFaceId = false;
        String distance = "far";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
        String appId = "AppId";
        String appKey = "AppKey";
    	
        processedVideo.resetFrameIndices();
        
        String response;
		try {
			System.out.println("Start video processing.");
			response = api.videoProcessUpload(processedVideo.getVideoPath(), fps, width, height, enableFaceId, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
			System.out.println("End video processing.");
			String responseCompact = formatResponseArray(response, "v1-Compact");
			JSONArray responseJSON = new JSONArray(responseCompact);
			processedVideo.fromJSON(responseJSON);
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		processedVideo.setProcessed();
		System.out.println("Video processing finished");
    }

    /**
     * Asynchronous call without optional parameters.
     */
    /*public void processEmotionImageByUpload(File image, MashapeCallback<JSONObject> callback) {
        processEmotionImageByUpload(image, "", "", "", "", "", "", callback);
    }*/

    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> processEmotionImageByUrls(String url, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (url != null && !url.equals("")) {
	parameters.put("url", url);
        }
        
        
        
        if (sessionid != null && !sessionid.equals("")) {
	parameters.put("session_id", sessionid);
        }
        
        
        
        if (sessionseqnumber != null && !sessionseqnumber.equals("")) {
	parameters.put("session_seqnumber", sessionseqnumber);
        }
        
        
        
        if (sessionmetadata != null && !sessionmetadata.equals("")) {
	parameters.put("session_metadata", sessionmetadata);
        }
        
        
        
        if (priority != null && !priority.equals("")) {
	parameters.put("priority", priority);
        }
        
        
        
        if (consent != null && !consent.equals("")) {
	parameters.put("consent", consent);
        }
        
        
        
        if (format != null && !format.equals("")) {
	parameters.put("format", format);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/process/emotion/image/url/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Synchronous call without optional parameters.
     */
    public MashapeResponse<JSONObject> processEmotionImageByUrls(String url) {
        return processEmotionImageByUrls(url, "", "", "", "", "", "");
    }


    /**
     * Asynchronous call with optional parameters.
     */
    public Thread processEmotionImageByUrls(String url, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (url != null && !url.equals("")) {
        
            parameters.put("url", url);
        }
        
        
        
        if (sessionid != null && !sessionid.equals("")) {
        
            parameters.put("session_id", sessionid);
        }
        
        
        
        if (sessionseqnumber != null && !sessionseqnumber.equals("")) {
        
            parameters.put("session_seqnumber", sessionseqnumber);
        }
        
        
        
        if (sessionmetadata != null && !sessionmetadata.equals("")) {
        
            parameters.put("session_metadata", sessionmetadata);
        }
        
        
        
        if (priority != null && !priority.equals("")) {
        
            parameters.put("priority", priority);
        }
        
        
        
        if (consent != null && !consent.equals("")) {
        
            parameters.put("consent", consent);
        }
        
        
        
        if (format != null && !format.equals("")) {
        
            parameters.put("format", format);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/process/emotion/image/url/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Asynchronous call without optional parameters.
     */
    public Thread processEmotionImageByUrls(String url, MashapeCallback<JSONObject> callback) {
        return processEmotionImageByUrls(url, "", "", "", "", "", "", callback);
    }

    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> processImageByUrl(String url, String appsession, String seqnumber, String format) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (appsession != null && !appsession.equals("")) {
	parameters.put("app_session", appsession);
        }
        
        
        
        if (seqnumber != null && !seqnumber.equals("")) {
	parameters.put("seq_number", seqnumber);
        }
        
        
        
        if (url != null && !url.equals("")) {
	parameters.put("url", url);
        }
        
        
        
        if (format != null && !format.equals("")) {
	parameters.put("format", format);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/process/image/url/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Synchronous call without optional parameters.
     */
    public MashapeResponse<JSONObject> processImageByUrl(String url) {
        return processImageByUrl(url, "", "", "");
    }


    /**
     * Asynchronous call with optional parameters.
     */
    public Thread processImageByUrl(String url, String appsession, String seqnumber, String format, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (appsession != null && !appsession.equals("")) {
        
            parameters.put("app_session", appsession);
        }
        
        
        
        if (seqnumber != null && !seqnumber.equals("")) {
        
            parameters.put("seq_number", seqnumber);
        }
        
        
        
        if (url != null && !url.equals("")) {
        
            parameters.put("url", url);
        }
        
        
        
        if (format != null && !format.equals("")) {
        
            parameters.put("format", format);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/process/image/url/",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Asynchronous call without optional parameters.
     */
    public Thread processImageByUrl(String url, MashapeCallback<JSONObject> callback) {
        return processImageByUrl(url, "", "", "", callback);
    }

    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> processImageByUpload(File image, String appsession, String seqnumber, String format) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (image != null && !image.equals("")) {
	parameters.put("image", image);
        }
        
        
        
        if (appsession != null && !appsession.equals("")) {
	parameters.put("app_session", appsession);
        }
        
        
        
        if (seqnumber != null && !seqnumber.equals("")) {
	parameters.put("seq_number", seqnumber);
        }
        
        
        
        if (format != null && !format.equals("")) {
	parameters.put("format", format);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.POST,
                    "https://" + PUBLIC_DNS + "/process/image/upload/",
                    parameters,
                    ContentType.BINARY,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Synchronous call without optional parameters.
     */
    public MashapeResponse<JSONObject> processImageByUpload(File image) {
        return processImageByUpload(image, "", "", "");
    }


    /**
     * Asynchronous call with optional parameters.
     */
    public Thread processImageByUpload(File image, String appsession, String seqnumber, String format, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (image != null && !image.equals("")) {
        
            parameters.put("image", image);
        }
        
        
        
        if (appsession != null && !appsession.equals("")) {
        
            parameters.put("app_session", appsession);
        }
        
        
        
        if (seqnumber != null && !seqnumber.equals("")) {
        
            parameters.put("seq_number", seqnumber);
        }
        
        
        
        if (format != null && !format.equals("")) {
        
            parameters.put("format", format);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.POST,
                    "https://" + PUBLIC_DNS + "/process/image/upload/",
                    parameters,
                    ContentType.BINARY,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Asynchronous call without optional parameters.
     */
    public Thread processImageByUpload(File image, MashapeCallback<JSONObject> callback) {
        return processImageByUpload(image, "", "", "", callback);
    }
    
    public static String formatResponseArray(String response, String queryFormat) throws JSONException {
        String formattedResponse = "";

        // Default is the full (directly returned by the API)
        // Therefore, we just have to return it
        if(queryFormat == null || queryFormat.equals("v2-Full")) {
          formattedResponse = response;
        } else if(queryFormat.equals("v1-Compact")) {
          JSONArray resp = new JSONArray(response);
          JSONArray formattedResponseJson = new JSONArray();

          for(int i=0; i<resp.length(); i++){
            JSONObject elem = resp.getJSONObject(i);

            Double score = (double) i;
            Double relativeTime = (double) i;
            Long processTime = Long.valueOf(elem.getJSONObject("Frame").get("MilliSecond").toString());

            JSONObject returnedElem = new JSONObject(formatResponse(resp.getJSONObject(i).toString(), queryFormat, score, relativeTime, processTime));

            formattedResponseJson.put(returnedElem);
          }
          formattedResponse = formattedResponseJson.toString();
        }

        return formattedResponse;
      }

      public static String formatResponse(String response, String format, Double score, Double relativeTime, Long processTime) throws JSONException {
        String formattedResponse = "";

        // Default is the full (directly returned by the API)
        // Therefore, we just have to return it
        if(format == null || format.equals("v2-Full")) {
          formattedResponse = response;
        } else if(format.equals("v1-Compact")) {

          JSONObject resp = new JSONObject(response);

          // Prepare images array
          JSONArray images = new JSONArray();
          // There's only 1 image at a time.
          JSONObject image = new JSONObject();

          // Array of faces
          JSONArray faces = new JSONArray();

          // Fill the faces
          for(int i=0; i<resp.getJSONArray("FaceData").length(); i++) {

            JSONObject faceData = resp.getJSONArray("FaceData").getJSONObject(i);
            JSONObject landmarks = faceData.getJSONObject("Landmark170");
            Double width = toDouble(resp.getJSONObject("Frame").get("Width"));
            Double height = toDouble(resp.getJSONObject("Frame").get("Height"));


            // Prepare the face object in the new JSON
            JSONObject face = new JSONObject();

            // Add height and width
            face.put("height", truncate(toDouble(faceData.getJSONObject("Location").get("Height"))));
            face.put("width", truncate(toDouble(faceData.getJSONObject("Location").get("Width"))));

            // center
            JSONObject center = new JSONObject();
            center.put("x", truncate((toDouble(landmarks.getJSONObject("Pt_142").get("X")) + toDouble(landmarks.getJSONObject("Pt_158").get("X")))*width/2.0));
            center.put("y", truncate((toDouble(landmarks.getJSONObject("Pt_116").get("Y")) + toDouble(landmarks.getJSONObject("Pt_150").get("Y")))*height/2.0));
            face.put("center", center);

            // eye_brow_left
            JSONObject eye_brow_left = new JSONObject();
            eye_brow_left.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_000").get("X"))*width)); eye_brow_left.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_000").get("Y").toString())*height));
            eye_brow_left.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_001").get("X"))*width)); eye_brow_left.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_001").get("Y").toString())*height));
            eye_brow_left.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_002").get("X"))*width)); eye_brow_left.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_002").get("Y").toString())*height));
            eye_brow_left.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_003").get("X"))*width)); eye_brow_left.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_003").get("Y").toString())*height));
            eye_brow_left.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_004").get("X"))*width)); eye_brow_left.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_004").get("Y").toString())*height));
            face.put("eye_brow_left", eye_brow_left);

            // eye_left
            JSONObject eye_left = new JSONObject();
            eye_left.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_010").get("X"))*width)); eye_left.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_010").get("Y"))*height));
            eye_left.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_011").get("X"))*width)); eye_left.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_011").get("Y"))*height));
            eye_left.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_012").get("X"))*width)); eye_left.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_012").get("Y"))*height));
            eye_left.put("x6", truncate(toDouble(landmarks.getJSONObject("Pt_013").get("X"))*width)); eye_left.put("y6", truncate(toDouble(landmarks.getJSONObject("Pt_013").get("Y"))*height));
            eye_left.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_014").get("X"))*width)); eye_left.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_014").get("Y"))*height));
            eye_left.put("x7", truncate(toDouble(landmarks.getJSONObject("Pt_015").get("X"))*width)); eye_left.put("y7", truncate(toDouble(landmarks.getJSONObject("Pt_015").get("Y"))*height));
            eye_left.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_016").get("X"))*width)); eye_left.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_016").get("Y"))*height));
            eye_left.put("x8", truncate(toDouble(landmarks.getJSONObject("Pt_017").get("X"))*width)); eye_left.put("y8", truncate(toDouble(landmarks.getJSONObject("Pt_017").get("Y"))*height));
            face.put("eye_left", eye_left);

            // eye_brow_right
            JSONObject eye_brow_right = new JSONObject();
            eye_brow_right.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_005").get("X"))*width)); eye_brow_right.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_005").get("Y").toString())*height));
            eye_brow_right.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_006").get("X"))*width)); eye_brow_right.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_006").get("Y").toString())*height));
            eye_brow_right.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_007").get("X"))*width)); eye_brow_right.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_007").get("Y").toString())*height));
            eye_brow_right.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_008").get("X"))*width)); eye_brow_right.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_008").get("Y").toString())*height));
            eye_brow_right.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_009").get("X"))*width)); eye_brow_right.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_009").get("Y").toString())*height));
            face.put("eye_brow_right", eye_brow_right);

            // eye_right
            JSONObject eye_right = new JSONObject();
            eye_right.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_018").get("X"))*width)); eye_right.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_018").get("Y"))*height));
            eye_right.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_019").get("X"))*width)); eye_right.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_019").get("Y"))*height));
            eye_right.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_020").get("X"))*width)); eye_right.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_020").get("Y"))*height));
            eye_right.put("x6", truncate(toDouble(landmarks.getJSONObject("Pt_021").get("X"))*width)); eye_right.put("y6", truncate(toDouble(landmarks.getJSONObject("Pt_021").get("Y"))*height));
            eye_right.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_022").get("X"))*width)); eye_right.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_022").get("Y"))*height));
            eye_right.put("x7", truncate(toDouble(landmarks.getJSONObject("Pt_023").get("X"))*width)); eye_right.put("y7", truncate(toDouble(landmarks.getJSONObject("Pt_023").get("Y"))*height));
            eye_right.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_024").get("X"))*width)); eye_right.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_024").get("Y"))*height));
            eye_right.put("x8", truncate(toDouble(landmarks.getJSONObject("Pt_025").get("X"))*width)); eye_right.put("y8", truncate(toDouble(landmarks.getJSONObject("Pt_025").get("Y"))*height));
            face.put("eye_right", eye_right);

            // mouth
            JSONObject mouth = new JSONObject();
            mouth.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_026").get("X"))*width)); mouth.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_026").get("Y"))*height));
            mouth.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_030").get("X"))*width)); mouth.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_030").get("Y"))*height));
            mouth.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_028").get("X"))*width)); mouth.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_028").get("Y"))*height));
            mouth.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_032").get("X"))*width)); mouth.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_032").get("Y"))*height));
            mouth.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_027").get("X"))*width)); mouth.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_027").get("Y"))*height));
            mouth.put("x6", truncate(toDouble(landmarks.getJSONObject("Pt_029").get("X"))*width)); mouth.put("y6", truncate(toDouble(landmarks.getJSONObject("Pt_029").get("Y"))*height));
            mouth.put("x7", truncate(toDouble(landmarks.getJSONObject("Pt_031").get("X"))*width)); mouth.put("y7", truncate(toDouble(landmarks.getJSONObject("Pt_031").get("Y"))*height));
            mouth.put("x8", truncate(toDouble(landmarks.getJSONObject("Pt_033").get("X"))*width)); mouth.put("y8", truncate(toDouble(landmarks.getJSONObject("Pt_033").get("Y"))*height));
            mouth.put("x9", truncate(toDouble(landmarks.getJSONObject("Pt_066").get("X"))*width)); mouth.put("y9", truncate(toDouble(landmarks.getJSONObject("Pt_066").get("Y"))*height));
            mouth.put("x10", truncate(toDouble(landmarks.getJSONObject("Pt_071").get("X"))*width)); mouth.put("y10", truncate(toDouble(landmarks.getJSONObject("Pt_071").get("Y"))*height));
            face.put("mouth", mouth);

            // nose
            JSONObject nose = new JSONObject();
            nose.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_037").get("X"))*width)); nose.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_037").get("Y"))*height));
            nose.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_040").get("X"))*width)); nose.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_040").get("Y"))*height));
            nose.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_054").get("X"))*width)); nose.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_054").get("Y"))*height));
            nose.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_125").get("X"))*width)); nose.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_125").get("Y"))*height));
            face.put("nose", nose);

            // chin contour
            JSONObject chin = new JSONObject();
            chin.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_143").get("X"))*width)); chin.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_143").get("Y"))*height));
            chin.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_145").get("X"))*width)); chin.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_145").get("Y"))*height));
            chin.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_150").get("X"))*width)); chin.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_150").get("Y"))*height));
            chin.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_155").get("X"))*width)); chin.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_155").get("Y"))*height));
            chin.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_157").get("X"))*width)); chin.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_157").get("Y"))*height));
            chin.put("x6", truncate(toDouble(landmarks.getJSONObject("Pt_148").get("X"))*width)); chin.put("y6", truncate(toDouble(landmarks.getJSONObject("Pt_148").get("Y"))*height));
            chin.put("x7", truncate(toDouble(landmarks.getJSONObject("Pt_152").get("X"))*width)); chin.put("y7", truncate(toDouble(landmarks.getJSONObject("Pt_152").get("Y"))*height));
            face.put("chin", chin);

            // forehead contour
            JSONObject forehead = new JSONObject();
            forehead.put("x1", truncate(toDouble(landmarks.getJSONObject("Pt_112").get("X"))*width)); forehead.put("y1", truncate(toDouble(landmarks.getJSONObject("Pt_112").get("Y"))*height));
            forehead.put("x2", truncate(toDouble(landmarks.getJSONObject("Pt_116").get("X"))*width)); forehead.put("y2", truncate(toDouble(landmarks.getJSONObject("Pt_116").get("Y"))*height));
            forehead.put("x3", truncate(toDouble(landmarks.getJSONObject("Pt_120").get("X"))*width)); forehead.put("y3", truncate(toDouble(landmarks.getJSONObject("Pt_120").get("Y"))*height));
            forehead.put("x4", truncate(toDouble(landmarks.getJSONObject("Pt_114").get("X"))*width)); forehead.put("y4", truncate(toDouble(landmarks.getJSONObject("Pt_114").get("Y"))*height));
            forehead.put("x5", truncate(toDouble(landmarks.getJSONObject("Pt_118").get("X"))*width)); forehead.put("y5", truncate(toDouble(landmarks.getJSONObject("Pt_118").get("Y"))*height));
            face.put("forehead", forehead);

            // attribute
            JSONObject attribute = new JSONObject();
            JSONObject emotion = new JSONObject();
            emotion.put("neutral", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Neutral").getJSONObject("Intensity").get("Value"))));
            emotion.put("sadness", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Sadness").getJSONObject("Intensity").get("Value"))));
            emotion.put("disgust", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Disgust").getJSONObject("Intensity").get("Value"))));
            emotion.put("anger", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Anger").getJSONObject("Intensity").get("Value"))));
            emotion.put("surprise", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Surprise").getJSONObject("Intensity").get("Value"))));
            emotion.put("fear", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Fear").getJSONObject("Intensity").get("Value"))));
            emotion.put("happiness", truncate(toDouble(faceData.getJSONObject("Emotion").getJSONObject("Happiness").getJSONObject("Intensity").get("Value"))));
            attribute.put("emotion", emotion);
            face.put("attribute", attribute);

            faces.put(face);
          }

          image.put("faces", faces);

          // Fill status of the image
          JSONObject status = new JSONObject();
          if(resp.getJSONArray("FaceData").length() == 0) {
            status.put("message", "No face found");
            status.put("code", "warning");
            status.put("task", "");
          } else {
            status.put("message", "");
            status.put("code", "success");
            status.put("task", "");
          }

          image.put("status", status);
          image.put("width", toInteger(resp.getJSONObject("Frame").get("Width")));
          image.put("height", toInteger(resp.getJSONObject("Frame").get("Height")));
          image.put("session_timestamp", relativeTime);
          image.put("session_seqnumber", score);
          image.put("session_seqtime", processTime);
          image.put("session_id", "");

          // Put the image in the array of images
          images.put(image);

          // Status object
          status = new JSONObject();
          status.put("message", "");
          status.put("code", "success");

          // Usage object
          JSONArray usages = new JSONArray();
          JSONObject usage = new JSONObject();

          Date now = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

          usage.put("start", dateFormat.format(now) + " 00:00:00 +0000");
          usage.put("end", dateFormat.format(now) + " 23:59:59 +0000");
          usage.put("metric", "hits");
          usage.put("period", dateFormat.format(now) + " 00:00:00 +0000");
          usage.put("current", 0);
          usage.put("limit", "none");

          usages.put(usage);

          // Add images to the response
          JSONObject finalResponse = new JSONObject();
          finalResponse.put("images", images);
          finalResponse.put("status", status);
          finalResponse.put("usage", usages);

          formattedResponse = finalResponse.toString();
        }

        return formattedResponse;
      }
      
      public static Double truncate(Double valueToBeTruncated) {
    	    Double truncatedDouble = new BigDecimal(valueToBeTruncated)
    	    .setScale(3, BigDecimal.ROUND_HALF_UP)
    	    .doubleValue();
    	    return truncatedDouble;
    	  }

    	  public static Double toDouble(Object value) {
    	    return Double.parseDouble(value.toString());
    	  }

    	  public static Integer toInteger(Object value) {
    	    return Integer.parseInt(value.toString());
    	  }

}