package flightservlet.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
    private static final String CREDENTIALS_FILE = "artifacts/flight_servlet/WEB-INF/resources/application.properties";
    private static final Properties PROPERTIES = new Properties();
    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
//        try (InputStream resourceAsStream = new FileInputStream(FlightServlet.getResourcesDirectory())) {

            String resourcePath = PropertiesUtil.class.getClassLoader().getResource("application.properties").getPath();
            System.out.println("resourcePath = " + resourcePath);
//            System.out.println("resourceAsStream = " + resourceAsStream);

            String classpath = System.getProperty("java.class.path");
            System.out.println("Classpath: " + classpath);

            URL url = PropertiesUtil.class.getClassLoader().getResource("application.properties");
            if (url == null) {
                System.out.println("Unable to locate application.properties file.");
            } else {
                System.out.println("Found application.properties file at " + url.getPath());
            }


            PROPERTIES.load(resourceAsStream);
        }catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private PropertiesUtil() {
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
