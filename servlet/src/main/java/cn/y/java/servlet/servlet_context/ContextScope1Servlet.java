package cn.y.java.servlet.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextscope1")
public class ContextScope1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(req.getRequestURI() + " start --------------");
        servletContext.setAttribute("attr-k1", "attr-v1");
        System.out.println("add context attribute!");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ContextScope1Servlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }
}
