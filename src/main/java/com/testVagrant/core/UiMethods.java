package com.testVagrant.core;

import com.testVagrant.pom.NdtvWeather;
import com.testVagrant.utils.ReporterUtil;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static com.testVagrant.utils.SeleniumUtility.*;


public class UiMethods {

    public HashMap<String, String> uiWeatherDetails(RemoteWebDriver driver, String cityName) throws InterruptedException {
        String data = null;
        HashMap<String, String> map = new HashMap<>();
        NdtvWeather ndtvWeather = PageFactory.initElements(driver, NdtvWeather.class);
        if (isElementPresent(ndtvWeather.siteAlert))
            seleniumClick(ndtvWeather.siteAlert);
        seleniumClick(ndtvWeather.moreOptionBtn);
        waitForElementVisibility(driver, ndtvWeather.weatherLink, 10);
        seleniumClick(ndtvWeather.weatherLink);
        if (isElementPresent(ndtvWeather.pinCitySearchInpBox)) {
            Thread.sleep(500);
            seleniumType(ndtvWeather.pinCitySearchInpBox, cityName);
            if(isElementPresent(driver, NdtvWeather.cityCheckBox, cityName))
                Thread.sleep(500);
            seleniumClick(driver, NdtvWeather.cityCheckBox, cityName);
        } else {
            screenshot(driver);
            Assert.fail(cityName + " is not available at city List");
        }

        if (isElementPresent(driver, NdtvWeather.mapCityClick, cityName)) {
            seleniumClick(driver, NdtvWeather.mapCityClick, cityName);
            data = seleniumGetText(driver, NdtvWeather.cityWeatherDetails, cityName);
            screenshot(driver);
            ReporterUtil.log("weather details from ndtv");
            //ReporterUtil.log(data);
        } else {
            screenshot(driver);
            Assert.fail(cityName + " is not available at map");
        }

        String[] split = data.split("\n");
        for (int i = 1; i < split.length; i++) {
            String[] split1 = split[i].split(":");
            map.put(split1[0], split1[1]);
        }

        for(Map.Entry<String,String> entry : map.entrySet()){
            ReporterUtil.log(entry.getKey()+" :: "+entry.getValue());
        }
    return map;
    }



}