package com.testVagrant;

import com.testVagrant.Groups;
import com.testVagrant.TestBase;
import com.testVagrant.core.ApiMethods;
import com.testVagrant.core.CommonMethods;
import com.testVagrant.core.UiMethods;
import com.testVagrant.data.QueryPool;
import com.testVagrant.drivers.WebDriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;


public class WeatherComparison extends TestBase {


    RemoteWebDriver driver;
    UiMethods uiMethods = new UiMethods();
    ApiMethods apiMethods = new ApiMethods();
    CommonMethods commonMethods = new CommonMethods();
    String env = "www";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) throws InterruptedException {
        driver = WebDriverSetup.setUpBrowser(browser);
        driver.get("https://"+env+".ndtv.com");
    }


    @Test(groups = { Groups.SMOKE, Groups.REGRESSION}, priority = 1,
            dataProviderClass = QueryPool.class,dataProvider = "feedData")
    @Description("Compare weather from Ndtv Web and openweathermap api")
    @Story("Compare weather from Ndtv Web and openweathermap api")
    public void weatherComparison(String cityName) throws InterruptedException {
        HashMap<String,String> uiMap = uiMethods.uiWeatherDetails(driver,cityName);
        HashMap<String,String> apiMap = apiMethods.apiWeatherDetails(cityName);
        commonMethods.weatherComparator(uiMap,apiMap);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();

    }

}
