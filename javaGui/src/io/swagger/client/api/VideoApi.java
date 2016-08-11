package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import java.io.File;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-04T18:10:01.068+02:00")
public class VideoApi {
  private ApiClient apiClient;

  public VideoApi() {
    this(Configuration.getDefaultApiClient());
  }

  public VideoApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Process a video. Returns the JSON. Keeps Connection Alive.
   * Process a video. The connection stays alive until the JSON of the video is returned
   * @param file File to post to the API. (required)
   * @param fps Number of fps of the video. (Default is 30) (optional)
   * @param enableFaceId Enable Face recognition. (One ID is given to each of the faces). Default is false (optional)
   * @param distance Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. (optional)
   * @param multipleFaces If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. (optional)
   * @param xMin Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param xMax Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param yMin Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param yMax Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String videoProcessUpload(File file, Integer fps, Boolean enableFaceId, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling videoProcessUpload");
    }
    
    // create path and map variables
    String localVarPath = "/video/process/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fps", fps));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "enableFaceId", enableFaceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "distance", distance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "multipleFaces", multipleFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMax", yMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Download the results.
   * Download the results after processing the video.
   * @param requestId ID associated to a video being processed (required)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String videoQueueResults(String requestId, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'requestId' is set
    if (requestId == null) {
      throw new ApiException(400, "Missing the required parameter 'requestId' when calling videoQueueResults");
    }
    
    // create path and map variables
    String localVarPath = "/video/queue/results".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "requestId", requestId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "application/zip"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Check the status of the processed video.
   * Check the status of the processed video.
   * @param requestId ID associated to a video being processed (required)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String videoQueueStatus(String requestId, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'requestId' is set
    if (requestId == null) {
      throw new ApiException(400, "Missing the required parameter 'requestId' when calling videoQueueStatus");
    }
    
    // create path and map variables
    String localVarPath = "/video/queue/status".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "requestId", requestId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Process a video. Email sent when finished.
   * Process a video. A webhook is used to inform you when the video will be processed.
   * @param file File to post to the API. (required)
   * @param fps Number of fps of the video. (Default is 30) (optional)
   * @param width Width of the output video. (Default is 1280) (optional)
   * @param height Height of the output video. (Default is 720) (optional)
   * @param enableFaceId Enable Face recognition. (One ID is given to each of the faces). Default is false (optional)
   * @param distance Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. (optional)
   * @param multipleFaces If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. (optional)
   * @param enableFooter Enable the footer with more information on the emotions. Default value is true. (optional)
   * @param dimSecFaces If set to true, it will dim all the secondary faces. Default value is true. (optional)
   * @param xMin Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param xMax Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param yMin Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param yMax Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String videoQueueUpload(File file, Integer fps, Integer width, Integer height, Boolean enableFaceId, String distance, Boolean multipleFaces, Boolean enableFooter, Boolean dimSecFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling videoQueueUpload");
    }
    
    // create path and map variables
    String localVarPath = "/video/queue/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fps", fps));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "width", width));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "height", height));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "enableFaceId", enableFaceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "distance", distance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "multipleFaces", multipleFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "enableFooter", enableFooter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dimSecFaces", dimSecFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMax", yMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Process a video. Returns the processed video. Keeps Connection Alive.
   * Process a video. The connection stays alive until the processed video is returned.
   * @param file File to post to the API. (required)
   * @param fps Number of fps of the video. (Default is 30) (optional)
   * @param width Width of the output video. (Default is 1280) (optional)
   * @param height Height of the output video. (Default is 720) (optional)
   * @param enableFaceId Enable Face recognition. (One ID is given to each of the faces). Default is false (optional)
   * @param distance Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. (optional)
   * @param multipleFaces If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. (optional)
   * @param enableFooter Enable the footer with more information on the emotions. Default value is true. (optional)
   * @param dimSecFaces If set to true, it will dim all the secondary faces. Default value is true. (optional)
   * @param xMin Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param xMax Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param yMin Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 (optional)
   * @param yMax Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String videoRenderUpload(File file, Integer fps, Integer width, Integer height, Boolean enableFaceId, String distance, Boolean multipleFaces, Boolean enableFooter, Boolean dimSecFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling videoRenderUpload");
    }
    
    // create path and map variables
    String localVarPath = "/video/render/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fps", fps));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "width", width));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "height", height));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "enableFaceId", enableFaceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "distance", distance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "multipleFaces", multipleFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "enableFooter", enableFooter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dimSecFaces", dimSecFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMax", yMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    if (file != null)
      localVarFormParams.put("file", file);

    final String[] localVarAccepts = {
      "video/mp4"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
