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

Please follow the [installation](#installation) instruction, open a comand prompt window in the directory where the file pom.xml is located and run the following command:

```shell
mvn test
```
This will run all the tests, which are located in src\test\java\io\swagger\client\api. There are three tests that are run :
- healthTest in MonitoringApiTest.java which just tests the health of all workers. It should print "info: All the workers responded to the PING."
- photoProcessUploadTest in PhotoApiTest.java which processes a .jpg photo using photoProcessUpload method. The program then extract all emotion intensities from the json and prints the emotion with the highest intensity.
- streamProcessUploadTest in StreamApiTest.java which starts a session and processes a stream of .jpg photos using streamProcessUpload method. The program then ends the session, performs a query to get the result in json format and extract all emotion intensities for all images and prints each time the emotion with the highest intensity.
- streamSessionDataTest in StreamApiTest.java which does the same as streamProcessUploadApiTest but just prints the resulting json object in csv format using streamSessionData method.
- videoProcessUploadTest in VideoApiTest.java which upload and processes a video, and prints for each frame the emotions of each face present on the frame.


## Documentation for API Endpoints

All URIs are relative to *http://192.168.10.158:8800/nviso/api/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MonitoringApi* | [**diskspace**](docs/MonitoringApi.md#diskspace) | **GET** /monitoring/diskspace | Check available diskspace on API server.
*MonitoringApi* | [**health**](docs/MonitoringApi.md#health) | **GET** /monitoring/health | Health of the workers
*MonitoringApi* | [**ping**](docs/MonitoringApi.md#ping) | **GET** /monitoring/ping | Ping API server.
*PhotoApi* | [**photoProcessBase64**](docs/PhotoApi.md#photoProcessBase64) | **POST** /photo/process/base64 | Process an uploaded Base64 encoded String in JPEG or PNG format returning result in a JSON format.
*PhotoApi* | [**photoProcessUpload**](docs/PhotoApi.md#photoProcessUpload) | **POST** /photo/process/upload | Process an uploaded photo encoded in JPEG or PNG format returning result in a JSON format.
*PhotoApi* | [**photoProcessUrl**](docs/PhotoApi.md#photoProcessUrl) | **GET** /photo/process/url | Process a JPEG or PNG image downloaded from provided URL returning result in a JSON format.
*PhotoApi* | [**photoRenderBase64**](docs/PhotoApi.md#photoRenderBase64) | **POST** /photo/render/base64 | Process an uploaded Base64 encoded String in JPEG or PNG format returning result as rendered visualization.
*PhotoApi* | [**photoRenderUpload**](docs/PhotoApi.md#photoRenderUpload) | **POST** /photo/render/upload | Process an uploaded photo encoded in JPEG or PNG format returning result as rendered visualization.
*PhotoApi* | [**photoRenderUrl**](docs/PhotoApi.md#photoRenderUrl) | **GET** /photo/render/url | Process a JPEG or PNG image downloaded from provided URL returning result as rendered visualization.
*StreamApi* | [**streamDelete**](docs/StreamApi.md#streamDelete) | **GET** /stream/delete | Delete all stored data for a given unique session key.
*StreamApi* | [**streamEnd**](docs/StreamApi.md#streamEnd) | **GET** /stream/end | End a session for a given unique session key.
*StreamApi* | [**streamList**](docs/StreamApi.md#streamList) | **GET** /stream/list | List of streams and status information for a given ID or wildcard search.
*StreamApi* | [**streamProcessBase64**](docs/StreamApi.md#streamProcessBase64) | **POST** /stream/process/base64 | Process an uploaded Base64 String of a time sequence photo encoded in JPEG or PNG format returning result in a JSON format.
*StreamApi* | [**streamProcessUpload**](docs/StreamApi.md#streamProcessUpload) | **POST** /stream/process/upload | Process an uploaded time sequence photo encoded in JPEG or PNG format returning result in a JSON format.
*StreamApi* | [**streamProcessUrl**](docs/StreamApi.md#streamProcessUrl) | **GET** /stream/process/url | Process a JPEG or PNG time sequence image downloaded from provided URL returning result in a JSON format.
*StreamApi* | [**streamQueryCsv**](docs/StreamApi.md#streamQueryCsv) | **GET** /stream/query/csv | Query stream based on session key and return data as CSV data format.
*StreamApi* | [**streamQueryGraph**](docs/StreamApi.md#streamQueryGraph) | **GET** /stream/query/graph | Query stream based on session key and return data as JSON graph format.
*StreamApi* | [**streamQueryImages**](docs/StreamApi.md#streamQueryImages) | **GET** /stream/query/images | Query stream based on session key and return data as a ZIP file containing the images of the stream.
*StreamApi* | [**streamQueryJson**](docs/StreamApi.md#streamQueryJson) | **GET** /stream/query/json | Query stream based on session key and return data as basic JSON format
*StreamApi* | [**streamQueryVideo**](docs/StreamApi.md#streamQueryVideo) | **GET** /stream/query/video | Query stream based on session key and return data as a video.
*StreamApi* | [**streamQueryZip**](docs/StreamApi.md#streamQueryZip) | **GET** /stream/query/zip | Query stream based on session key and return data as a ZIP file containging the images as well as the data in the basic JSON format.
*StreamApi* | [**streamStart**](docs/StreamApi.md#streamStart) | **POST** /stream/start | Start a stream with an ID and optional meta-data returning a unique session key.
*VideoApi* | [**videoProcessUpload**](docs/VideoApi.md#videoProcessUpload) | **POST** /video/process/upload | Process synchronously an uploaded MP4 encoded video keeping connection alive.
*VideoApi* | [**videoQueueDelete**](docs/VideoApi.md#videoQueueDelete) | **GET** /video/queue/delete | Delete all stored data associated with video processed of request ID.
*VideoApi* | [**videoQueueList**](docs/VideoApi.md#videoQueueList) | **GET** /video/queue/list | List all request IDs.
*VideoApi* | [**videoQueueResults**](docs/VideoApi.md#videoQueueResults) | **GET** /video/queue/results | Download result of uploaded video using request ID.
*VideoApi* | [**videoQueueStatus**](docs/VideoApi.md#videoQueueStatus) | **GET** /video/queue/status | Check status of uploaded video using request ID.
*VideoApi* | [**videoQueueUpload**](docs/VideoApi.md#videoQueueUpload) | **POST** /video/queue/upload | 
*VideoApi* | [**videoRenderUpload**](docs/VideoApi.md#videoRenderUpload) | **POST** /video/render/upload | Process asynchronously an uploaded MP4 encoded returns request ID.


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


