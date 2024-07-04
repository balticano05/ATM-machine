package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties(); // Инициализируем объект properties
        try (InputStream input = new FileInputStream("src/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getDoubleValue() {
        // Проверяем, что свойство "sumInATM" существует
        if (properties.getProperty("sumInATM") != null) {
            return Double.parseDouble(properties.getProperty("sumInATM"));
        } else {
            // Лучше выбрасывать исключение, если свойство не найдено
            throw new RuntimeException("Property 'sumInATM' not found in config.properties");
        }
    }

    public String getFilePath() {
        // Проверяем, что свойство "filePath" существует
        if (properties.getProperty("filePath") != null) {
            return properties.getProperty("filePath");
        } else {
            throw new RuntimeException("Property 'filePath' not found in config.properties");
        }
    }
}
