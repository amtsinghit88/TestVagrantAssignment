package com.testVagrant;

import com.testVagrant.core.CommonMethods;
import com.testVagrant.data.QueryPool;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class WeatherVarianceLogic {

    CommonMethods commonMethods = new CommonMethods();

    @Test(groups = {Groups.SMOKE, Groups.REGRESSION}, priority = 1,
            dataProviderClass = QueryPool.class, dataProvider = "cityTempRange")
    @Description("Compare external source city temperature with ui and api source")
    @Story("Compare external source city temperature with ui and api source")
    public void weatherTemperatureValidation(String data) {
        commonMethods.exteranlDatatemperatureValidation(data);
    }
}