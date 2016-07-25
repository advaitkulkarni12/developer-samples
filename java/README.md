# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.MonitoringApi;

import java.io.File;
import java.util.*;

public class MonitoringApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://127.0.0.1:8080/nviso/api/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MonitoringApi* | [**health**](docs/MonitoringApi.md#health) | **GET** /monitoring/health | Health of the workers
*PhotoApi* | [**photoProcessBase64**](docs/PhotoApi.md#photoProcessBase64) | **POST** /photo/process/base64 | Process a photo using a a Base 64 encoded string
*PhotoApi* | [**photoProcessUpload**](docs/PhotoApi.md#photoProcessUpload) | **POST** /photo/process/upload | Post a photo to the API. JSON returned.
*PhotoApi* | [**photoProcessUrl**](docs/PhotoApi.md#photoProcessUrl) | **GET** /photo/process/url | Process a photo given its URL.
*PhotoApi* | [**photoRenderBase64**](docs/PhotoApi.md#photoRenderBase64) | **POST** /photo/render/base64 | Post a photo using as a Base 64 encoded string. Screenshot returned.
*PhotoApi* | [**photoRenderUpload**](docs/PhotoApi.md#photoRenderUpload) | **POST** /photo/render/upload | Post a photo to the API. Screenshot returned.
*PhotoApi* | [**photoRenderUrl**](docs/PhotoApi.md#photoRenderUrl) | **GET** /photo/render/url | Render a photo given its URL.
*StreamApi* | [**streamProcessBase64**](docs/StreamApi.md#streamProcessBase64) | **POST** /stream/process/base64 | Process an image using a Base 64 encoded string
*StreamApi* | [**streamProcessUpload**](docs/StreamApi.md#streamProcessUpload) | **POST** /stream/process/upload | Post a image to the API. JSON returned.
*StreamApi* | [**streamProcessUrl**](docs/StreamApi.md#streamProcessUrl) | **GET** /stream/process/url | Process an image given its URL.
*StreamApi* | [**streamSessionData**](docs/StreamApi.md#streamSessionData) | **GET** /stream/session/data | Query the results and get a CSV data format
*StreamApi* | [**streamSessionEnd**](docs/StreamApi.md#streamSessionEnd) | **GET** /stream/session/end | End the session
*StreamApi* | [**streamSessionGraph**](docs/StreamApi.md#streamSessionGraph) | **GET** /stream/session/graph | Query the results and get a Graph format
*StreamApi* | [**streamSessionList**](docs/StreamApi.md#streamSessionList) | **GET** /stream/session/list | Session information related to ID.
*StreamApi* | [**streamSessionQuery**](docs/StreamApi.md#streamSessionQuery) | **GET** /stream/session/query | Query the results
*StreamApi* | [**streamSessionStart**](docs/StreamApi.md#streamSessionStart) | **POST** /stream/session/start | Returns a key for the image endpoints.


## Documentation for Models

 - [Key](docs/Key.md)
 - [ResponseServer](docs/ResponseServer.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

info@nviso.ch

