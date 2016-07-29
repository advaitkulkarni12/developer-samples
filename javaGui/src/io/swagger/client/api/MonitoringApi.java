package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import io.swagger.client.model.ResponseServer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-07-06T18:20:08.762+02:00")
public class MonitoringApi {
  private ApiClient apiClient;

  public MonitoringApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MonitoringApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Health of the workers
   * Check the health of all the workers. If the IP Address and the port is given, it will only check the health of the given worker.
   * @param ipAddress IP Address of the server where the worker is. (optional)
   * @param port Port to the Rest API. (optional)
   * @param appId Application ID. Used for the authentication (optional)
   * @param appKey Application key. Used for the authentication (optional)
   * @return ResponseServer
   * @throws ApiException if fails to make API call
   */
  public ResponseServer health(String ipAddress, String port, String appId, String appKey) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/monitoring/health".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ipAddress", ipAddress));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "port", port));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appId", appId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "appKey", appKey));

    
    
    final String[] localVarAccepts = {
      "application/json", "multipart/form-data"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<ResponseServer> localVarReturnType = new GenericType<ResponseServer>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
