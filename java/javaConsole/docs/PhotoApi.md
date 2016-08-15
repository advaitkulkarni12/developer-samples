# PhotoApi

All URIs are relative to *http://192.168.10.158:8800/nviso/api/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**photoProcessBase64**](PhotoApi.md#photoProcessBase64) | **POST** /photo/process/base64 | Process an uploaded Base64 encoded String in JPEG or PNG format returning result in a JSON format.
[**photoProcessUpload**](PhotoApi.md#photoProcessUpload) | **POST** /photo/process/upload | Process an uploaded photo encoded in JPEG or PNG format returning result in a JSON format.
[**photoProcessUrl**](PhotoApi.md#photoProcessUrl) | **GET** /photo/process/url | Process a JPEG or PNG image downloaded from provided URL returning result in a JSON format.
[**photoRenderBase64**](PhotoApi.md#photoRenderBase64) | **POST** /photo/render/base64 | Process an uploaded Base64 encoded String in JPEG or PNG format returning result as rendered visualization.
[**photoRenderUpload**](PhotoApi.md#photoRenderUpload) | **POST** /photo/render/upload | Process an uploaded photo encoded in JPEG or PNG format returning result as rendered visualization.
[**photoRenderUrl**](PhotoApi.md#photoRenderUrl) | **GET** /photo/render/url | Process a JPEG or PNG image downloaded from provided URL returning result as rendered visualization.


<a name="photoProcessBase64"></a>
# **photoProcessBase64**
> String photoProcessBase64(bas64, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process an uploaded Base64 encoded String in JPEG or PNG format returning result in a JSON format.

Process an uploaded Base64 encoded String in JPEG or PNG format returning result in a JSON format. Same options as /photo/process/upload.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
String bas64 = "bas64_example"; // String | Base 64 encoded image
String format = "format_example"; // String | Format of the JSON response. Default is v2-Full.
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.photoProcessBase64(bas64, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoProcessBase64");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bas64** | **String**| Base 64 encoded image |
 **format** | **String**| Format of the JSON response. Default is v2-Full. | [optional] [enum: v1-Compact, v2-Full]
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

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="photoProcessUpload"></a>
# **photoProcessUpload**
> String photoProcessUpload(file, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process an uploaded photo encoded in JPEG or PNG format returning result in a JSON format.

Process an uploaded photo encoded in JPEG or PNG format returning result in JSON format. Options that can be set to process the image include specifying if multiple faces should be detected, the distance of the faces that should be detected from the camera, and if a region of interest should be set to restrict processing of faces within the specified region of interest.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
File file = new File("/path/to/file.txt"); // File | File to post to the API.
String format = "format_example"; // String | Format of the JSON response. Default is v2-Full.
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.photoProcessUpload(file, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoProcessUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**| File to post to the API. |
 **format** | **String**| Format of the JSON response. Default is v2-Full. | [optional] [enum: v1-Compact, v2-Full]
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

<a name="photoProcessUrl"></a>
# **photoProcessUrl**
> String photoProcessUrl(url, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process a JPEG or PNG image downloaded from provided URL returning result in a JSON format.

Process a JPEG or PNG image downloaded from provided URL returning result in a JSON format. Same options as /photo/process/upload.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
String url = "url_example"; // String | URL to upload the picture
String format = "format_example"; // String | Format of the JSON response. Default is v2-Full.
String distance = "distance_example"; // String | Distance is the distance at which the picture was taken. Near = 1.5 m; Medium = 3 m; Far > 3 m. Default value is near.
Boolean multipleFaces = true; // Boolean | If there are multiple faces in the region of interest, then you need to put this value to True. Default value is true.
Double xMin = 3.4D; // Double | Minimum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double xMax = 3.4D; // Double | Maximum horizontal value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
Double yMin = 3.4D; // Double | Minimum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 0.0
Double yMax = 3.4D; // Double | Maximum vertical value for the region of interest. It should be between 0.0 and 1.0. Default is 1.0
String appId = "appId_example"; // String | Application ID. Used for the authentication
String appKey = "appKey_example"; // String | Application key. Used for the authentication
try {
    String result = apiInstance.photoProcessUrl(url, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoProcessUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **url** | **String**| URL to upload the picture |
 **format** | **String**| Format of the JSON response. Default is v2-Full. | [optional] [enum: v1-Compact, v2-Full]
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

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="photoRenderBase64"></a>
# **photoRenderBase64**
> String photoRenderBase64(bas64, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process an uploaded Base64 encoded String in JPEG or PNG format returning result as rendered visualization.

Process an uploaded Base64 encoded String in JPEG or PNG format returning result in JSON format. Same options as /photo/process/upload. Note this function is only available if workers have been configured with OpenGL rendering.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
String bas64 = "bas64_example"; // String | Base 64 encoded image
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
    String result = apiInstance.photoRenderBase64(bas64, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoRenderBase64");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bas64** | **String**| Base 64 encoded image |
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

 - **Content-Type**: text/plain
 - **Accept**: image/png

<a name="photoRenderUpload"></a>
# **photoRenderUpload**
> String photoRenderUpload(file, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process an uploaded photo encoded in JPEG or PNG format returning result as rendered visualization.

Process an uploaded photo encoded in JPEG or PNG format returning result in JSON format. Same options as /photo/process/upload. Note this function is only available if workers have been configured with OpenGL rendering.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
File file = new File("/path/to/file.txt"); // File | File to post to the API.
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
    String result = apiInstance.photoRenderUpload(file, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoRenderUpload");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **File**| File to post to the API. |
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
 - **Accept**: image/png

<a name="photoRenderUrl"></a>
# **photoRenderUrl**
> String photoRenderUrl(url, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey)

Process a JPEG or PNG image downloaded from provided URL returning result as rendered visualization.

Process a JPEG or PNG image downloaded from provided URL returning result in JSON format. Same options as /photo/process/upload. Note this function is only available if workers have been configured with OpenGL rendering.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PhotoApi;


PhotoApi apiInstance = new PhotoApi();
String url = "url_example"; // String | URL to upload the picture
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
    String result = apiInstance.photoRenderUrl(url, distance, multipleFaces, enableFooter, dimSecFaces, xMin, xMax, yMin, yMax, appId, appKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PhotoApi#photoRenderUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **url** | **String**| URL to upload the picture |
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

 - **Content-Type**: Not defined
 - **Accept**: image/png

