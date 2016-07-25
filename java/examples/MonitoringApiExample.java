import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.MonitoringApi;

import java.io.File;
import java.util.*;

public class MonitoringApiExample {

    public static void main(String[] args) {
		Pair p = new Pair("name", "value");
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