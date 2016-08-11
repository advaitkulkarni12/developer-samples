# VideoApi

All URIs are relative to *http://192.168.10.158:8080/nviso/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**videoProcessUpload**](VideoApi.md#videoProcessUpload) | **POST** /video/process/upload | Process a video. Returns the JSON. Keeps Connection Alive.
[**videoQueueResults**](VideoApi.md#videoQueueResults) | **GET** /video/queue/results | Download the results.
[**videoQueueStatus**](VideoApi.md#videoQueueStatus) | **GET** /video/queue/status | Check the status of the processed video.
[**videoQueueUpload**](VideoApi.md#videoQueueUpload) | **POST** /video/queue/upload | Process a video. Email sent when finished.
[**videoRenderUpload**](VideoApi.md#videoRenderUpload) | **POST** /video/render/upload | Process a video. Returns the processed video. Keeps Connection Alive.


<a name="videoProcessUpload"></a>
# **videoProcessUpload**
> String videoProcessUpload(file, enableFaceId, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process a video. Returns the JSON. Keeps Connection Alive.

Process a video. The connection stays alive until the JSON of the video is returned

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VideoApi;


VideoApi apiInstance = new VideoApi();
File file = new File("/path/to/file.txt"); // File | File to post to the API.
Boolean enableFaceId = true; // Boolean | Enable Face recognition. (One ID is given to each of the faces). Default is false
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.videoProcessUpload(file, enableFaceId, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VideoApi#videoProcessUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**| File to post to the API. |
 **enableFaceId** | **Boolean**| Enable Face recognition. (One ID is given to each of the faces). Default is false | [optional]
 **distance** | **String**| Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. | [optional] [enum: near, medium, far]
 **multipleFaces** | **Boolean**| If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. | [optional]
 **xMin** | **Double**| Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **xMax** | **Double**| Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **yMin** | **Double**| Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **yMax** | **Double**| Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="videoQueueResults"></a>
# **videoQueueResults**
> String videoQueueResults(requestId, appId, appKey)

Download the results.

Download the results after processing the video.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VideoApi;


VideoApi apiInstance = new VideoApi();
String requestId = "requestId_example"; // String | ID associated to a video being processed
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.videoQueueResults(requestId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VideoApi#videoQueueResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| ID associated to a video being processed |
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/zip

<a name="videoQueueStatus"></a>
# **videoQueueStatus**
> String videoQueueStatus(requestId, appId, appKey)

Check the status of the processed video.

Check the status of the processed video.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VideoApi;


VideoApi apiInstance = new VideoApi();
String requestId = "requestId_example"; // String | ID associated to a video being processed
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.videoQueueStatus(requestId, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VideoApi#videoQueueStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| ID associated to a video being processed |
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="videoQueueUpload"></a>
# **videoQueueUpload**
> String videoQueueUpload(file, fps, width, height, enableFaceId, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process a video. Email sent when finished.

Process a video. A webhook is used to inform you when the video will be processed.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VideoApi;


VideoApi apiInstance = new VideoApi();
File file = new File("/path/to/file.txt"); // File | File to post to the API.
Integer fps = 56; // Integer | Number of fps of the video. (Default is 30)
Integer width = 56; // Integer | Width of the output video. (Default is 1280)
Integer height = 56; // Integer | Height of the output video. (Default is 720)
Boolean enableFaceId = true; // Boolean | Enable Face recognition. (One ID is given to each of the faces). Default is false
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Boolean enableFooter = true; // Boolean | Enable the footer with more information on the emotions. Default value is true.
Boolean dimSecFaces = true; // Boolean | If set to true, it will dim all the secondary faces. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.videoQueueUpload(file, fps, width, height, enableFaceId, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VideoApi#videoQueueUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**| File to post to the API. |
 **fps** | **Integer**| Number of fps of the video. (Default is 30) | [optional]
 **width** | **Integer**| Width of the output video. (Default is 1280) | [optional]
 **height** | **Integer**| Height of the output video. (Default is 720) | [optional]
 **enableFaceId** | **Boolean**| Enable Face recognition. (One ID is given to each of the faces). Default is false | [optional]
 **distance** | **String**| Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. | [optional] [enum: near, medium, far]
 **multipleFaces** | **Boolean**| If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. | [optional]
 **enableFooter** | **Boolean**| Enable the footer with more information on the emotions. Default value is true. | [optional]
 **dimSecFaces** | **Boolean**| If set to true, it will dim all the secondary faces. Default value is true. | [optional]
 **xMin** | **Double**| Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **xMax** | **Double**| Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **yMin** | **Double**| Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **yMax** | **Double**| Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="videoRenderUpload"></a>
# **videoRenderUpload**
> String videoRenderUpload(file, fps, width, height, enableFaceId, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process a video. Returns the processed video. Keeps Connection Alive.

Process a video. The connection stays alive until the processed video is returned.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VideoApi;


VideoApi apiInstance = new VideoApi();
File file = new File("/path/to/file.txt"); // File | File to post to the API.
Integer fps = 56; // Integer | Number of fps of the video. (Default is 30)
Integer width = 56; // Integer | Width of the output video. (Default is 1280)
Integer height = 56; // Integer | Height of the output video. (Default is 720)
Boolean enableFaceId = true; // Boolean | Enable Face recognition. (One ID is given to each of the faces). Default is false
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Boolean enableFooter = true; // Boolean | Enable the footer with more information on the emotions. Default value is true.
Boolean dimSecFaces = true; // Boolean | If set to true, it will dim all the secondary faces. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.videoRenderUpload(file, fps, width, height, enableFaceId, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VideoApi#videoRenderUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**| File to post to the API. |
 **fps** | **Integer**| Number of fps of the video. (Default is 30) | [optional]
 **width** | **Integer**| Width of the output video. (Default is 1280) | [optional]
 **height** | **Integer**| Height of the output video. (Default is 720) | [optional]
 **enableFaceId** | **Boolean**| Enable Face recognition. (One ID is given to each of the faces). Default is false | [optional]
 **distance** | **String**| Distance is the distance at which the picture was taken. Near &#x3D; 1.5 m; Medium &#x3D; 3 m; Far &gt; 3 m. Default value is near. | [optional] [enum: near, medium, far]
 **multipleFaces** | **Boolean**| If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true. | [optional]
 **enableFooter** | **Boolean**| Enable the footer with more information on the emotions. Default value is true. | [optional]
 **dimSecFaces** | **Boolean**| If set to true, it will dim all the secondary faces. Default value is true. | [optional]
 **xMin** | **Double**| Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **xMax** | **Double**| Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **yMin** | **Double**| Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0 | [optional]
 **yMax** | **Double**| Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0 | [optional]
 **appId** | **String**| Application ID. Used for the authentication | [optional]
 **appKey** | **String**| Application key. Used for the authentication | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: video/mp4

