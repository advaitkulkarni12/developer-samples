package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import java.io.File;
import io.swagger.client.model.Key;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-07-06T18:20:08.762+02:00")
public class StreamApi {
  private ApiClient apiClient;

  public StreamApi() {
    this(Configuration.getDefaultApiClient());
  }

  public StreamApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Process an image using a Base 64 encoded string
   * Process an image using a Base 64 encoded string. It returns a JSON with all the emotions.
   * @param base64 Base 64 encoded image (required)
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param score Score defines the order of the images. Image with lowest score will first in the sequence. If score is not set, then the order will done on the timestamp. (optional)
   * @param time Relative time of the video. Default is 0.0. (optional)
   * @param timestamp Specific timestamp for the picture in the session in UNIX time. Default is the time when you process the image. (optional)
   * @param format Format of the JSON response. Default is v2-Full. (optional)
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
  public String streamProcessBase64(String base64, String key, Double score, Double time, Double timestamp, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = base64;
    
    // verify the required parameter 'base64' is set
    if (base64 == null) {
      throw new ApiException(400, "Missing the required parameter 'base64' when calling streamProcessBase64");
    }
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamProcessBase64");
    }
    
    // create path and map variables
    String localVarPath = "/stream/process/base64".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "score", score));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "time", time));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timestamp", timestamp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "format", format));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "distance", distance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "multipleFaces", multipleFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMax", yMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "text/plain"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Post a image to the API. JSON returned.
   * Post a single image to the API and get back the JSON response.
   * @param file File to post to the API. (required)
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param score Score defines the order of the images. Image with lowest score will first in the sequence. If score is not set, then the order will done on the timestamp. (optional)
   * @param time Relative time of the video. Default is 0.0. (optional)
   * @param timestamp Specific timestamp for the picture in the session in UNIX time. Default is the time when you process the image. (optional)
   * @param format Format of the JSON response. Default is v2-Full. (optional)
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
  public String streamProcessUpload(File file, String key, Double score, Double time, Double timestamp, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling streamProcessUpload");
    }
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamProcessUpload");
    }
    
    // create path and map variables
    String localVarPath = "/stream/process/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "score", score));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "time", time));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timestamp", timestamp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "format", format));
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
   * Process an image given its URL.
   * Process an image using its URL. It returns a JSON with all the emotions.
   * @param url URL to upload the picture (required)
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param score Score defines the order of the images. Image with lowest score will first in the sequence. If score is not set, then the order will done on the timestamp. (optional)
   * @param time Relative time of the video. Default is 0.0. (optional)
   * @param timestamp Specific timestamp for the picture in the session in UNIX time. Default is the time when you process the image. (optional)
   * @param format Format of the JSON response. Default is v2-Full. (optional)
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
  public String streamProcessUrl(String url, String key, Double score, Double time, Double timestamp, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'url' is set
    if (url == null) {
      throw new ApiException(400, "Missing the required parameter 'url' when calling streamProcessUrl");
    }
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamProcessUrl");
    }
    
    // create path and map variables
    String localVarPath = "/stream/process/url".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "url", url));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "score", score));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "time", time));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "timestamp", timestamp));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "format", format));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "distance", distance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "multipleFaces", multipleFaces));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMin", xMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "xMax", xMax));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMin", yMin));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "yMax", yMax));
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
   * Query the results and get a CSV data format
   * Query the results of the session using the key. Get an array with a CSV data format.
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param dataFormat Format of the JSON response. Default is basic. (optional)
   * @param sortBy This parameter defines how you want to sort the images in the session. Default is timestamp. (optional)
   * @param limitBy This parameter defines the parameters the API will use to limit the data. Default is timestamp. (optional)
   * @param startLimit Starting limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param endLimit Ending limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param order This parameters defines the order, ascending or descending. Default is ascending (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String streamSessionData(String key, String dataFormat, String sortBy, String limitBy, Double startLimit, Double endLimit, String order, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamSessionData");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/data".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dataFormat", dataFormat));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limitBy", limitBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startLimit", startLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "endLimit", endLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "order", order));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "text/csv"
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
   * End the session
   * End the session using the key after starting a session.
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String streamSessionEnd(String key, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamSessionEnd");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/end".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
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
   * Query the results and get a Graph format
   * Query the results of the session using the key. Get an array of JSONs back in a Graph format. The format charts-json is using the timestamp that the user has provided.
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param graphFormat Format of the JSON response. Default is charts-json. (optional)
   * @param sortBy This parameter defines how you want to sort the images in the session. Default is timestamp. (optional)
   * @param limitBy This parameter defines the parameters the API will use to limit the data. Default is timestamp. (optional)
   * @param startLimit Starting limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param endLimit Ending limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param order This parameters defines the order, ascending or descending. Default is ascending (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String streamSessionGraph(String key, String graphFormat, String sortBy, String limitBy, Double startLimit, Double endLimit, String order, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamSessionGraph");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/graph".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "graphFormat", graphFormat));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limitBy", limitBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startLimit", startLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "endLimit", endLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "order", order));
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
   * Session information related to ID.
   * Get all the session information related to a given ID.
   * @param ID ID used for starting the sessions. Use the character % if you don&#39;t know a part of the ID. For example, %test%. (required)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String streamSessionList(String ID, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'ID' is set
    if (ID == null) {
      throw new ApiException(400, "Missing the required parameter 'ID' when calling streamSessionList");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/list".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ID", ID));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "text/csv"
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
   * Query the results
   * Query the results of the session using the key. Get an array of JSONs back.
   * @param key key to store the processed images in the database. Please use a key generated by the API. (required)
   * @param queryFormat Format of the JSON response. Default is v2-Full. (optional)
   * @param sortBy This parameter defines how you want to sort the images in the session. Default is timestamp. (optional)
   * @param limitBy This parameter defines the parameters the API will use to limit the data. Default is timestamp. (optional)
   * @param startLimit Starting limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param endLimit Ending limit. It needs to be consistent with the limitBy parameter. (For example, if you&#39;re limiting by timestamp, put here a UNIX time) (optional)
   * @param order This parameters defines the order, ascending or descending. Default is ascending (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String streamSessionQuery(String key, String queryFormat, String sortBy, String limitBy, Double startLimit, Double endLimit, String order, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling streamSessionQuery");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/query".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "queryFormat", queryFormat));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limitBy", limitBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startLimit", startLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "endLimit", endLimit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "order", order));
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
   * Returns a key for the image endpoints.
   * Returns a key to start a session for the image endpoints.
   * @param id ID that will be used to start the session. (required)
   * @param data These data are key-value paired. It should look like {\&quot;string\&quot;: \&quot;value1\&quot;, \&quot;number\&quot;: 123, \&quot;boolean\&quot;: true}. They will be stored in the database. (required)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return Key
   * @throws ApiException if fails to make API call
   */
  public Key streamSessionStart(String id, String data, String appId, String appKey) throws ApiException {
    Object localVarPostBody = data;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling streamSessionStart");
    }
    
    // verify the required parameter 'data' is set
    if (data == null) {
      throw new ApiException(400, "Missing the required parameter 'data' when calling streamSessionStart");
    }
    
    // create path and map variables
    String localVarPath = "/stream/session/start".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
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

    GenericType<Key> localVarReturnType = new GenericType<Key>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}