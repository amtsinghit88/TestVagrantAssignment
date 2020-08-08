package com.testVagrant.ui;

import com.testVagrant.Groups;
import com.testVagrant.TestBase;
import com.testVagrant.core.ApiMethods;
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




public class WeatherComparison extends TestBase {


    RemoteWebDriver driver;
    UiMethods uiMethods = new UiMethods();
    ApiMethods apiMethods = new ApiMethods();
    String env = "www";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) throws InterruptedException {
        driver = WebDriverSetup.setUpBrowser(browser);
        driver.get("https://"+env+".ndtv.com");
    }


    @Test(groups = { Groups.SMOKE, Groups.REGRESSION}, priority = 1,
            dataProviderClass = QueryPool.class,dataProvider = "feedData")
    @Description("Search content at google search page")
    @Story("Search content at google search page")
    public void weatherComparison(String cityName) throws InterruptedException {
        uiMethods.uiWeatherDetails(driver,cityName);
        apiMethods.apiWeatherDetails(cityName);


    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();

    }

}
