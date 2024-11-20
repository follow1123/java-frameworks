package cn.y.java.servlet.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/contextscope3")
public class ContextScope3Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(req.getRequestURI() + " start --------------");
        servletContext.removeAttribute("attr-k1");
        System.out.println("context attribute removed!");

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ContextScope3Servlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }
}
