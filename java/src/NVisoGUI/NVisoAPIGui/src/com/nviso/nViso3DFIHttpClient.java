package com.nviso;


import com.mashape.client.authentication.Authentication;
import com.mashape.client.authentication.AuthenticationParameter;
import com.mashape.client.authentication.QueryAuthentication;
import com.mashape.client.http.ContentType;
import com.mashape.client.http.HttpClient;
import com.mashape.client.http.HttpMethod;
import com.mashape.client.http.MashapeCallback;
import com.mashape.client.http.MashapeResponse;
import com.mashape.client.http.ResponseType;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

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
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (image != null && !image.equals("")) {
	parameters.put("image", image);
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
                    HttpMethod.POST,
                    "https://" + PUBLIC_DNS + "/process/emotion/image/upload/",
                    parameters,
                    ContentType.BINARY,
                    ResponseType.JSON,
                    authenticationHandlers);
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
    public Thread processEmotionImageByUpload(File image, String sessionid, String sessionseqnumber, String sessionmetadata, String priority, String consent, String format, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (image != null && !image.equals("")) {
        
            parameters.put("image", image);
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
                    HttpMethod.POST,
                    "https://" + PUBLIC_DNS + "/process/emotion/image/upload/",
                    parameters,
                    ContentType.BINARY,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

    /**
     * Asynchronous call without optional parameters.
     */
    public Thread processEmotionImageByUpload(File image, MashapeCallback<JSONObject> callback) {
        return processEmotionImageByUpload(image, "", "", "", "", "", "", callback);
    }

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

}