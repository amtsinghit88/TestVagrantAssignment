package com.testVagrant.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryPool {

    public static LocalDate currentDate = LocalDate.now();

    @DataProvider(name = "feedData")
    public static Object[][] feedData() {

                return new Object[][]{ {"Jaipur"}};
    }


    @DataProvider(name = "cityTempRange")
    public static Object[] cityTempRange() {
            String fileName = System.getProperty("user.dir")+"/src/test/resources/cityTemperatureList.txt";
            List<String> data = new ArrayList<>();

            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                data = stream.collect(Collectors.toList());
            } catch (IOException e) {
            e.printStackTrace();
            }

        String[] list = new String[data.size()];
        for(int i=0;i<data.size();i++)
            list[i]=data.get(i);

        return list;

    }





}