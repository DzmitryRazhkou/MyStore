package com.mystore.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    /**
     * This method is used to load properties from config.properties file
     * @return Properties prop object
     */

    public static Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream(
             "/Users/dzmitryrazhkou/Documents/Automation/MyStoreGit" +
             "/src/main/java/com/mystore/qa/config/Config.properties");
            try {
                properties.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
