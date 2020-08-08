package com.testVagrant.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    PropertyReader() {
        properties = new Properties();
        try {
            properties.load(getPropertyStream());
        } catch (IOException e) {
            throw new RuntimeException("Invalid env " + WeatherSystemProperties.ENV.toLowerCase());
        }
    }

    private InputStream getPropertyStream() {
        System.out.println("Prop:" + WeatherSystemProperties.ENV.toLowerCase());
        return getClass().getClassLoader()
                .getResourceAsStream(WeatherSystemProperties.ENV.toLowerCase() + ".properties");
    }

    String getAppId() {
        return properties.getProperty("appId");
    }

    String getBaseUri() {
        return properties.getProperty("baseUri");
    }

}
