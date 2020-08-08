package com.testVagrant.properties;

public interface WeatherSystemProperties {
    String ENV = System.getProperty("env", "prod");
}
