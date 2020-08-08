package com.testVagrant.core;

import com.testVagrant.utils.ReporterUtil;
import org.testng.Assert;

import java.util.HashMap;

public class CommonMethods {

    public void weatherComparator(HashMap<String,String> uiMap,HashMap<String,String> apiMap){

        Float tempInDegree = Float.parseFloat(uiMap.get("Temp in Degrees"));
        Float tempInFahrenheit = Float.parseFloat(uiMap.get("Temp in Fahrenheit"));
        Double apiTemp = Double.parseDouble(apiMap.get("temp"));

        ReporterUtil.log("NDTV temp in degrees :: "+tempInDegree);
        ReporterUtil.log("NDTV temp in Fahrenheit :: "+tempInFahrenheit);
        ReporterUtil.log("openweathermap api temp in kelvin :: "+apiMap.get("temp"));

        double convetDegreeInKelvin = tempInDegree+273.15;
        double convetFahrenheitInKelvin = 273.5 + ((tempInFahrenheit - 32.0) * (5.0/9.0));

        ReporterUtil.log("NDTV temp converted from degrees to kelvin :: "+convetDegreeInKelvin);
        ReporterUtil.log("NDTV temp converted from fahrenheit to kelvin :: "+convetFahrenheitInKelvin);

        Assert.assertTrue(apiTemp==convetDegreeInKelvin,"openweathermap api temp isnot matching with ndtv weather temp in kelvin temp unit");

    }
}
