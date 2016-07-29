# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) version 2.2.0 to be installed.

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


