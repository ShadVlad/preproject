package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReaderOfProperties {
    public static Properties getProperties(String filename) {
        Properties properties = new Properties();
        try(InputStream inputStream = ReaderOfProperties.class.getClassLoader().getResourceAsStream(filename)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }
}
