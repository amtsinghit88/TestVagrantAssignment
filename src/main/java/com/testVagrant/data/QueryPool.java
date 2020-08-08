package com.testVagrant.data;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.util.HashMap;

public class QueryPool {

    public static LocalDate currentDate = LocalDate.now();

    @DataProvider(name = "feedData")
    public static Object[][] feedData() {

                return new Object[][]{ {"Jaipur"}};
    }



}