package com.redbus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){
        File file = new File("C:\\Users\\ashin\\Documents\\APP Testing Version one\\RedBusCucumber\\src\\test\\resources\\config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getBaseUrl(String BASE_URL){
       return  properties.getProperty(BASE_URL);
    }
}
