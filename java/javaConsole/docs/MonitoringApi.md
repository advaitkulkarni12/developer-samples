# MonitoringApi

All URIs are relative to *http://192.168.10.158:8800/nviso/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**diskspace**](MonitoringApi.md#diskspace) | **GET** /monitoring/diskspace | Check available diskspace on API server.
[**health**](MonitoringApi.md#health) | **GET** /monitoring/health | Health of the workers
[**ping**](MonitoringApi.md#ping) | **GET** /monitoring/ping | Ping API server.


<a name="diskspace"></a>
# **diskspace**
> String diskspace()

Check available diskspace on API server.

Check available diskspace on API server. This call does not require authentication.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MonitoringApi;


MonitoringApi apiInstance = new MonitoringApi();
try {
    String result = apiInstance.diskspace();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MonitoringApi#diskspace");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, multipart/form-data, text/csv

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
 - **Accept**: application/json, multipart/form-data, text/csv

<a name="ping"></a>
# **ping**
> String ping()

Ping API server.

Ping the status of the API server. This call does not require authentication.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MonitoringApi;


MonitoringApi apiInstance = new MonitoringApi();
try {
    String result = apiInstance.ping();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MonitoringApi#ping");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, multipart/form-data, text/csv

