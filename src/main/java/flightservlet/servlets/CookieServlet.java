package flightservlet.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HelloServlet{
    private static final String UNIQUE_ID = "userId";
    private static final AtomicInteger counter = new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null || Arrays.stream(cookies)
                .filter(cookie -> UNIQUE_ID.equals(cookie.getName()))
                .findFirst().isEmpty()) {//no such cookie and user get first time
            Cookie cookie = new Cookie(UNIQUE_ID, "1");
            cookie.setPath("/cookies");
            cookie.setMaxAge(15 * 60); //15 min * 60s
            resp.addCookie(cookie);
            counter.incrementAndGet();
        }

            resp.setContentType("text/html");
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

            try (PrintWriter writer = resp.getWriter()) {
                writer.write(counter.get());
            }


    }
}
