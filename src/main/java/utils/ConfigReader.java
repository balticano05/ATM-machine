package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.StringConstants.PATH_TO_PROPERTIES;

public final class ConfigReader {

    private static ConfigReader instance;
    private Properties properties;

    private ConfigReader() {
    }

    {
        properties = new Properties();

        try (InputStream input = new FileInputStream(PATH_TO_PROPERTIES)) {

            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static ConfigReader getInstance() {

        if (instance == null) {

            instance = new ConfigReader();
        }

        return instance;
    }

    public double getDoubleValue(String propertyName) {

        String value = properties.getProperty(propertyName);

        if (value != null) {

            return Double.parseDouble(value);

        } else {

            throw new RuntimeException("Property '" + propertyName + "' not found in config.properties");
        }
    }

    public String getStringValue(String propertyName) {

        String value = properties.getProperty(propertyName);

        if (value != null) {

            return value;

        } else {

            throw new RuntimeException("Property '" + propertyName + "' not found in config.properties");
        }
    }
}
