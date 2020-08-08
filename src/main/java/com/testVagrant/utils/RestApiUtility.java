package com.testVagrant.utils;

import com.testVagrant.properties.WeatherProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class RestApiUtility {


    public static Response getService(Map<String,String> headers, HashMap<String,String> query, String endPoints){

        baseURI = WeatherProperties.BASE_URI;
        Response response = RestAssured.given().log().all()
                .headers(headers).queryParams(query).get(endPoints);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        return response;
    }
}
