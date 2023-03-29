package flightservlet.servlets;

import flightservlet.service.FlightService;
import flightservlet.util.PropertiesUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet(value = "/flights")
public class FlightServlet extends HttpServlet{
    protected static File resourcesDirectory;

    public static File getResourcesDirectory() {
        return resourcesDirectory;
    }

    private FlightService flightService = FlightService.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        resourcesDirectory = new File(getServletContext().getRealPath("/WEB-INF/application.properties"));
        System.out.println("resourcesDirectory = " + resourcesDirectory);




        try {
            // Replace the file path with your own file path
            BufferedReader reader = new BufferedReader(new FileReader(resourcesDirectory));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


//        try (
                PrintWriter printWriter = resp.getWriter();
//        ) {
            printWriter.write("<h1>List of flights </h1>");
            printWriter.write("<ul>");
//            flightService.findAll().forEach(flightDto -> printWriter.write(flightDto.toString() + "<br>"));
            flightService.findAll().forEach(flightDto -> {
                printWriter.write("""
                        <li>
                           <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription())) ;
            });
            printWriter.write("</ul>");
//        }
    }
}
