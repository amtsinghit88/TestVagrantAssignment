package com.testVagrant.core;


import com.google.gson.Gson;
import com.testVagrant.endPoints.HeaderBuilder;
import com.testVagrant.endPoints.WeatherService;
import com.testVagrant.entities.MainModule;
import com.testVagrant.properties.WeatherProperties;
import com.testVagrant.utils.ReporterUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import static com.testVagrant.utils.RestApiUtility.*;

public class ApiMethods {


    public HashMap<String, String> apiWeatherDetails(String cityName){
        HashMap<String,String> weatherDetails = new HashMap<>();
        HeaderBuilder headerBuilder = new HeaderBuilder();
        Map<String,String> headers = headerBuilder.withDefault();
        HashMap<String,String> queryPool= new HashMap<>();
        queryPool.put("q",cityName);
        queryPool.put("appid", WeatherProperties.APP_ID);
        Response response = getService(headers,queryPool, WeatherService.CITY_WEATHER);

        Gson gson = new Gson();
        gson.fromJson(response.getBody().asString(), MainModule.class);

        JSONObject jsonObject = new JSONObject(response.asString());
        JSONObject main = new JSONObject(jsonObject.get("main").toString());
        JSONObject wind = new JSONObject(jsonObject.get("wind").toString());
        JSONArray weather = new JSONArray(jsonObject.get("weather").toString());

        JSONObject weatherDetail = new JSONObject(weather.get(0).toString());

        weatherDetails.put("temp", String.valueOf(main.get("temp")));
        weatherDetails.put("humidity",String.valueOf(main.get("humidity")));
        weatherDetails.put("wind",String.valueOf(wind.get("speed")));
        weatherDetails.put("condition", (String) weatherDetail.get("main"));

        ReporterUtil.log("weather details from API");
        for(Map.Entry<String,String> entry : weatherDetails.entrySet()){
            ReporterUtil.log(entry.getKey()+" :: "+entry.getValue());
        }
return weatherDetails;

    }


}