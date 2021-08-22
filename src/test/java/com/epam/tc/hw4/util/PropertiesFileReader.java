package com.epam.tc.hw4.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    protected String userLoginInfoFile = "src/test/resources/HW3.properties";

    public String getProperties(String name) {
        Properties properties = new Properties();
        String value = "";

        try (InputStream inputStream = new FileInputStream(userLoginInfoFile)) {
            properties.load(inputStream);
            value = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
