package com.testVagrant.properties;

public class WeatherProperties {
    public static PropertyReader propertyReader = new PropertyReader();

    public static final String APP_ID = propertyReader.getAppId();
    public static final String BASE_URI = propertyReader.getBaseUri();


}
