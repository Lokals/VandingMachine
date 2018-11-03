package pl.sdacademy.vending.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private final Properties properties;

    public Configuration() {
        properties = new Properties( );
//        InputStream in = getClass().getResourceAsStream("application.properties");
        try (InputStream in = ClassLoader
                .getSystemResourceAsStream("application.properties")){
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace( );
        }
        properties.list(System.out);

    }

    public Long getLongProperty(String paramName, Long defaultValue){
        String propertyvalue = properties.getProperty(paramName);
        if (propertyvalue == null){
            return defaultValue;
        }
        return Long.parseLong(propertyvalue);

    }
    public String getStringProperty(String paramName, String defaultValue){
        return properties.getProperty(paramName, defaultValue);

    }
}
