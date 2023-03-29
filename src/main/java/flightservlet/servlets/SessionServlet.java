package flightservlet.servlets;

import flightservlet.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HelloServlet{
    private static final String USER = " user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserDto user = (UserDto)session.getAttribute(USER);
        if (user == null) {
            user = UserDto.builder()
            .id(25L)
            .email("first@gmail.com")
            .build();
            session.setAttribute(USER, user);

        }


        System.out.println("session.isNew() = " + session.isNew());

    }
}
