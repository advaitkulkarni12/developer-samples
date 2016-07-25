/**
 * Developer API
 * Documentation of worker endpoints
 *
 * OpenAPI spec version: 2.1
 * Contact: info@nviso.ch
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import java.io.File;
import io.swagger.client.model.Key;
import org.junit.Test;
// Package to play with JSON objects and arrays
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StreamApi
 */
public class StreamApiTest {

    private final StreamApi api = new StreamApi();

    
    /**
     * Process an image using a Base 64 encoded string
     *
     * Process an image using a Base 64 encoded string. It returns a JSON with all the emotions.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamProcessBase64Test() throws ApiException {
        String base64 = null;
        String key = null;
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = null;
        String distance = null;
        Boolean multipleFaces = null;
        Double xMin = null;
        Double xMax = null;
        Double yMin = null;
        Double yMax = null;
        String appId = null;
        String appKey = null;
        // String response = api.streamProcessBase64(base64, key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);

        // TODO: test validations
    }
    
    /**
     * Post a image to the API. JSON returned.
     *
     * Post a single image to the API and get back the JSON response.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamProcessUploadTest() throws ApiException {
		//System.out.println("\n");
		//System.out.println("Test of the Stream upload for a single image :");
		String id = "sessionId";
        String data = "{\"info\": \"Test for example\"}";
        String appId = "AppId";
        String appKey = "AppKey";
		Key sessionKey = api.streamSessionStart(id, data, appId, appKey);
		
        File file = new File("src/test/java/io/swagger/client/api/data/dataStream/RID_105440_000.jpg");
        String key = sessionKey.getSessionKey();
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = "v2-Full";
        String distance = "near";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;
        String response = api.streamProcessUpload(file, key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);

		//System.out.println(response);
    }
    
    /**
     * Process an image given its URL.
     *
     * Process an image using its URL. It returns a JSON with all the emotions.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamProcessUrlTest() throws ApiException {
        String url = null;
        String key = null;
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = null;
        String distance = null;
        Boolean multipleFaces = null;
        Double xMin = null;
        Double xMax = null;
        Double yMin = null;
        Double yMax = null;
        String appId = null;
        String appKey = null;
        // String response = api.streamProcessUrl(url, key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);

        // TODO: test validations
    }
    
    /**
     * Query the results and get a CSV data format
     *
     * Query the results of the session using the key. Get an array with a CSV data format.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionDataTest() throws ApiException {
		System.out.println("\n");
		System.out.println("Test of the Stream query in csv format :");
		String id = "sessionId";
        String data = "{\"info\": \"Test for example\"}";
        String appId = "AppId";
        String appKey = "AppKey";
		Key sessionKey = api.streamSessionStart(id, data, appId, appKey);
		
        String key = sessionKey.getSessionKey();
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = "v2-Full";
        String distance = "near";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;

		for(int i=0; i < 27; ++i){
			String filename;
			if (i < 10){
				filename = "src/test/java/io/swagger/client/api/data/dataStream/RID_105440_00" + Integer.toString(i) + ".jpg";
			}
			else{
				filename = "src/test/java/io/swagger/client/api/data/dataStream/RID_105440_0" + Integer.toString(i) + ".jpg";
			}
			File file = new File(filename);
			String response_i = api.streamProcessUpload(file, key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
		}

		api.streamSessionEnd(key, appId, appKey);


        String dataFormat = "basic";
        String sortBy = "timestamp";
        String limitBy = "timestamp";
        Double startLimit = 0.0;
        Double endLimit = 2000000000.0;
        String order = "ascending";
        String response = api.streamSessionData(key, dataFormat, sortBy, limitBy, startLimit, endLimit, order, appId, appKey);

		System.out.println(response);
    }
    
    /**
     * End the session
     *
     * End the session using the key after starting a session.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionEndTest() throws ApiException {
        String key = null;
        String appId = null;
        String appKey = null;
        // String response = api.streamSessionEnd(key, appId, appKey);

        // TODO: test validations
    }
    
    /**
     * Query the results and get a Graph format
     *
     * Query the results of the session using the key. Get an array of JSONs back in a Graph format. The format charts-json is using the timestamp that the user has provided.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionGraphTest() throws ApiException {
        String key = null;
        String graphFormat = null;
        String sortBy = null;
        String limitBy = null;
        Double startLimit = null;
        Double endLimit = null;
        String order = null;
        String appId = null;
        String appKey = null;
        // String response = api.streamSessionGraph(key, graphFormat, sortBy, limitBy, startLimit, endLimit, order, appId, appKey);

        // TODO: test validations
    }
    
    /**
     * Session information related to ID.
     *
     * Get all the session information related to a given ID.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionListTest() throws ApiException {
        String ID = null;
        String appId = null;
        String appKey = null;
        // String response = api.streamSessionList(ID, appId, appKey);

        // TODO: test validations
    }
    
    /**
     * Query the results
     *
     * Query the results of the session using the key. Get an array of JSONs back.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionQueryTest() throws ApiException {
		System.out.println("\n");
		System.out.println("Test of the Stream query :");
        String id = "sessionId";
        String data = "{\"info\": \"Test for example\"}";
        String appId = "AppId";
        String appKey = "AppKey";
		Key sessionKey = api.streamSessionStart(id, data, appId, appKey);
		
        String key = sessionKey.getSessionKey();
        Double score = null;
        Double time = null;
        Double timestamp = null;
        String format = "v2-Full";
        String distance = "near";
        Boolean multipleFaces = false;
        Double xMin = 0.0;
        Double xMax = 1.0;
        Double yMin = 0.0;
        Double yMax = 1.0;

		for(int i=0; i < 27; ++i){
			String filename;
			if (i < 10){
				filename = "src/test/java/io/swagger/client/api/data/dataStream/RID_105440_00" + Integer.toString(i) + ".jpg";
			}
			else{
				filename = "src/test/java/io/swagger/client/api/data/dataStream/RID_105440_0" + Integer.toString(i) + ".jpg";
			}
			File file = new File(filename);
			String response_i = api.streamProcessUpload(file, key, score, time, timestamp, format, distance, multipleFaces, xMin, xMax, yMin, yMax, appId, appKey);
		}

		api.streamSessionEnd(key, appId, appKey);

        String dataFormat = "v2-Full";
        String sortBy = "timestamp";
        String limitBy = "timestamp";
        Double startLimit = 0.0;
        Double endLimit = 2000000000.0;
        String order = "ascending";
        String response = api.streamSessionQuery(key, dataFormat, sortBy, limitBy, startLimit, endLimit, order, appId, appKey);

		//System.out.println(response);

		JSONArray arrayImages = new JSONArray(response);
		for(int i=0; i < 27; ++i){
			JSONArray faceData = arrayImages.getJSONObject(i).getJSONArray("FaceData");
			if(faceData.length() == 0){
				System.out.println("Not able to process image " + Integer.toString(i));
			}
			else{
				JSONObject emotions = faceData.getJSONObject(0).getJSONObject("Emotion");
				double surprise = emotions.getJSONObject("Surprise").getJSONObject("Intensity").getDouble("Value");
				double happiness = emotions.getJSONObject("Happiness").getJSONObject("Intensity").getDouble("Value");
				double neutral = emotions.getJSONObject("Neutral").getJSONObject("Intensity").getDouble("Value");
				double sadness = emotions.getJSONObject("Sadness").getJSONObject("Intensity").getDouble("Value");
				double disgust = emotions.getJSONObject("Disgust").getJSONObject("Intensity").getDouble("Value");
				double anger = emotions.getJSONObject("Anger").getJSONObject("Intensity").getDouble("Value");
				double fear = emotions.getJSONObject("Fear").getJSONObject("Intensity").getDouble("Value");

				double max = Math.max(surprise, Math.max(happiness, Math.max(neutral, Math.max(sadness, Math.max(disgust, Math.max(anger, fear))))));
				System.out.print("The person on image " + Integer.toString(i) + " feels : ");
				if (max == surprise){
					System.out.print("surprise");
				}
				else if (max == happiness){
					System.out.print("happiness");
				}
				else if (max == neutral){
					System.out.print("neutral");
				}
				else if (max == sadness){
					System.out.print("sadness");
				}
				else if (max == disgust){
					System.out.print("disgust");
				}
				else if (max == anger){
					System.out.print("anger");
				}
				else {
					System.out.print("fear");
				}
				System.out.println(".");
			}
		}

    }
    
    /**
     * Returns a key for the image endpoints.
     *
     * Returns a key to start a session for the image endpoints.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void streamSessionStartTest() throws ApiException {
        String id = "sessionId";
        String data = "{\"info\": \"Test for example\"}";
        String appId = "AppId";
        String appKey = "AppKey";
		Key sessionKey = api.streamSessionStart(id, data, appId, appKey);

		System.out.println(sessionKey.getSessionKey());

        // TODO: test validations
    }
    
}
