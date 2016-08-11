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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-02T10:34:05.963+02:00")
public class PhotoApi {
  private ApiClient apiClient;

  public PhotoApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PhotoApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Process a photo using a a Base 64 encoded string
   * Process a photo using a Base 64 encoded string. It returns a JSON with all the emotions.
   * @param bas64 Base 64 encoded image (required)
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
  public String photoProcessBase64(String bas64, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = bas64;
    
    // verify the required parameter 'bas64' is set
    if (bas64 == null) {
      throw new ApiException(400, "Missing the required parameter 'bas64' when calling photoProcessBase64");
    }
    
    // create path and map variables
    String localVarPath = "/photo/process/base64".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
   * Post a photo to the API. JSON returned.
   * Post a single photo to the API and get back the JSON response.
   * @param file File to post to the API. (required)
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
  public String photoProcessUpload(File file, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling photoProcessUpload");
    }
    
    // create path and map variables
    String localVarPath = "/photo/process/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
   * Process a photo given its URL.
   * Process a photo using its URL. It returns a JSON with all the emotions.
   * @param url URL to upload the picture (required)
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
  public String photoProcessUrl(String url, String format, String distance, Boolean multipleFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'url' is set
    if (url == null) {
      throw new ApiException(400, "Missing the required parameter 'url' when calling photoProcessUrl");
    }
    
    // create path and map variables
    String localVarPath = "/photo/process/url".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "url", url));
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
   * Post a photo using as a Base 64 encoded string. Screenshot returned.
   * Process a photo using a Base 64 encoded string and get back the screenshot. WARNING: The screenshot cannot be displayed in the UI. This will be fixed
   * @param bas64 Base 64 encoded image (required)
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
  public String photoRenderBase64(String bas64, String distance, Boolean multipleFaces, Boolean enableFooter, Boolean dimSecFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = bas64;
    
    // verify the required parameter 'bas64' is set
    if (bas64 == null) {
      throw new ApiException(400, "Missing the required parameter 'bas64' when calling photoRenderBase64");
    }
    
    // create path and map variables
    String localVarPath = "/photo/render/base64".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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

    
    
    final String[] localVarAccepts = {
      "image/png"
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
   * Post a photo to the API. Screenshot returned.
   * Post a single photo to the API and get back the screenshot. WARNING: The screenshot cannot be displayed in the UI. This will be fixed
   * @param file File to post to the API. (required)
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
  public String photoRenderUpload(File file, String distance, Boolean multipleFaces, Boolean enableFooter, Boolean dimSecFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'file' is set
    if (file == null) {
      throw new ApiException(400, "Missing the required parameter 'file' when calling photoRenderUpload");
    }
    
    // create path and map variables
    String localVarPath = "/photo/render/upload".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
      "image/png"
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
   * Render a photo given its URL.
   * Render a photo using its URL. It returns a screenshot of the processed photo.
   * @param url URL to upload the picture (required)
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
  public String photoRenderUrl(String url, String distance, Boolean multipleFaces, Boolean enableFooter, Boolean dimSecFaces, Double xMin, Double xMax, Double yMin, Double yMax, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'url' is set
    if (url == null) {
      throw new ApiException(400, "Missing the required parameter 'url' when calling photoRenderUrl");
    }
    
    // create path and map variables
    String localVarPath = "/photo/render/url".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "url", url));
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

    
    
    final String[] localVarAccepts = {
      "image/png"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
