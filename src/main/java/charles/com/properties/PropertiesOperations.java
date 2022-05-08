package charles.com.properties;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {

    private PropertiesOperations() {
    }

    static Properties properties = new Properties();

    public static String getPropertyValueByKey(String key) {
        String value = getSetupPropertyFile(key);
        if (StringUtils.isEmpty(value)) {
            try {
                throw new IllegalArgumentException(String.format("Value is not specified for key: %s in properties file.", key));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    private static String getSetupPropertyFile(String key) {
        String propFilePath = System.getProperty("user.dir").concat("/src/main/resources/config.properties");
        try (FileInputStream fileInputStream = new FileInputStream(propFilePath)) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.get(key).toString();
    }
}
