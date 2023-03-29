package flightservlet.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(value = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       req.getHeader("user-agent");
//        var headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String header = headerNames.nextElement();
//            System.out.println(req.getHeader(header));
//        }
//        resp.setContentType("text/html; charset=UTF-8");
//        resp.setHeader("token", "12345");
////        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        try (var writer = resp.getWriter()){
//            writer.write("<h1>Hello world from Servlet. Привет </h1>");
//        }
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println();
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var writer = resp.getWriter()){
            writer.write("<h1>Hello world from Servlet. Привет </h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("parameterMap = " + parameterMap);
        try (BufferedReader reader = req.getReader();
             Stream<String> stringStream = reader.lines()) {
           stringStream.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
