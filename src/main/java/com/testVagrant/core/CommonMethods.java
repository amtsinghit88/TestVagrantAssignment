package com.testVagrant.core;

import com.testVagrant.utils.ReporterUtil;
import org.testng.Assert;

import java.util.HashMap;

public class CommonMethods {

    ApiMethods apiMethods = new ApiMethods();

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

        Assert.assertTrue(Math.round(apiTemp)==Math.round(convetDegreeInKelvin),"openweathermap api temp isnot matching with ndtv weather temp in kelvin temp unit");

    }

    public void exteranlDatatemperatureValidation(String data){
        String [] split = data.split(" ");
        HashMap<String,String> apiMap = apiMethods.apiWeatherDetails(split[0]);
        float temp = Float.parseFloat(apiMap.get("temp"));
        float minTemp = Float.parseFloat(split[2]);
        float maxTemp = Float.parseFloat(split[4]);
        String tempUnit = split[5];

        if(tempUnit.equals("C")){
            double minTempDegreeInKelvin = minTemp+273.15;
            double maxTempDegreeInKelvin = maxTemp+273.15;

            if(temp>minTempDegreeInKelvin &&temp<maxTempDegreeInKelvin){
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                ReporterUtil.log("found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }else {
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                Assert.fail("not found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }

        }else if (tempUnit.equals("F")){

            double minTempFarInKelvin = 273.5 + ((minTemp - 32.0) * (5.0/9.0));
            double maxTempFarInKelvin = 273.5 + ((minTemp - 32.0) * (5.0/9.0));

            if(temp>minTempFarInKelvin &&temp<maxTempFarInKelvin){
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                ReporterUtil.log("found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }else {
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                Assert.fail("not found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }


        }else if (tempUnit.equals("K")){

            if(temp>minTemp &&temp<maxTemp){
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                ReporterUtil.log("found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }else {
                ReporterUtil.log("Acutal temperature of city : "+split[0]+" : "+(temp-273.15));
                Assert.fail("not found temperature between in range for this city "+split[0]+" : temp : "+(temp-273.15));
            }
        }
    }
}
