package AutomationTest.qumu.Utilities;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file TestData.properties
 */
public class TestDataReader {

    private static Properties properties;

    static {

        try {
            String path = "TestData.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}
