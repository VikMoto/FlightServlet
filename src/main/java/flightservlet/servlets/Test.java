package flightservlet.servlets;

import flightservlet.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        try (InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
//        try (InputStream resourceAsStream = new FileInputStream(FlightServlet.getResourcesDirectory())) {

            String resourcePath = PropertiesUtil.class.getClassLoader().getResource("application.properties").getPath();
            System.out.println("resourcePath = " + resourcePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
