package com.testVagrant.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NdtvWeather {

    @FindBy(how = How.ID, using = "h_sub_menu")
    public WebElement moreOptionBtn;

    @FindBy(how = How.XPATH, using = "//a[text()='WEATHER']")
    public WebElement weatherLink;

    @FindBy(how = How.ID, using = "searchBox")
    public WebElement pinCitySearchInpBox;

    @FindBy(how = How.XPATH, using = "//a[text()='No Thanks']")
    public WebElement siteAlert;




    //dynamic locator

    public static String cityCheckBox = "//label[@for='nameLbl']/input";
    public static String mapCityClick ="//div[text()='nameLbl']";
    public static String cityWeatherDetails ="//div[div[span[contains(text(),'nameLbl')]]]";


}
