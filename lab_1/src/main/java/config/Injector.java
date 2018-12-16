package config;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

//import static java.lang.System.getProperty;

public class Injector {

    private static final Logger log = Logger.getLogger(Injector.class);

    public <T> T inject(T object) {

        log.info("Dependency Injection " + object.toString());
        try {
            Field[] arrayFields = object.getClass().getDeclaredFields();
            for (int i = 0; i < arrayFields.length; i++) {

                Field field = arrayFields[i];
                field.setAccessible(true);
                Class<?> typeField = field.getType();
                FileInputStream fis;
                Properties properties = new Properties();
                String property;
                try {
                    fis = new FileInputStream("src/main/resources/config.properties");
                    properties.load(fis);
                    fis.close();
                } catch (IOException e) {
                    throw new Error(e.getMessage());
                }
                if (field.isAnnotationPresent(Iinjector.class)) {
                    property = properties.getProperty(typeField.getName());
                    field.set(object, Class.forName(property).newInstance());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        log.info("Injection return :" + object.toString());
        return object;
    }
}



