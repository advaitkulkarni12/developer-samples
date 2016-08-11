# MonitoringApi

All URIs are relative to *http://192.168.10.158:8080/nviso/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**health**](MonitoringApi.md#health) | **GET** /monitoring/health | Health of the workers


<a name="health"></a>
# **health**
> ResponseServer health(ipAddress, port, appId, appKey)

Health of the workers

Check the health of all the workers. If the IP Address and the port is given, it will only check the health of the given worker.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MonitoringApi;


MonitoringApi apiInstance = new MonitoringApi();
String ipAddress = "ipAddress_example"; // String | IP Address of the server where the worker is.
String port = "port_example"; // String | Port to the Rest API.
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    ResponseServer result = apiInstance.health(ipAddress, port, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MonitoringApi#health");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ipAddress** | **String**| IP Address of the server where the worker is. | [optional]
 **port** | **String**| Port to the Rest API. | [optional]
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

[**ResponseServer**](ResponseServer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, multipart/form-data

