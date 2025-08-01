package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String readKey(String key) {
        try {
            // Path to properties file in resources folder
            FileInputStream fileInputStream = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources/data.properties");

            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);

        } catch (IOException e) {
            throw new RuntimeException("Failed to read the properties file", e);
        }
    }
}
