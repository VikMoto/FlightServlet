package flightservlet.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HelloServlet{

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        RequestDispatcher requestDispatcher = req.getRequestDispatcher("flights");
////
//////        req.setAttribute("1","234");
////        requestDispatcher .forward(req,resp);
//
//
//        req.getRequestDispatcher("flights")
//                .forward(req,resp);
//        System.out.println("req = " + req);
//
////        getServletContext().getRequestDispatcher("flights").forward(req,resp);
//    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        req.getRequestDispatcher("flights")
//                .include(req,resp);
//
//        PrintWriter writer = resp.getWriter();
//        writer.write("HELLO 2 FORM DISPATCH");
//

//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.write("HELLO 2 FORM DISPATCH");
        resp.sendRedirect("flights");



//        getServletContext().getRequestDispatcher("flights").forward(req,resp);
    }
}
