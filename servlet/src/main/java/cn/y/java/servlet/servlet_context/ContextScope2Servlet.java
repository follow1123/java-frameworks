package cn.y.java.servlet.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/contextscope2")
public class ContextScope2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(req.getRequestURI() + " start --------------");
        // 单独获取
        System.out.println(servletContext.getAttribute("attr-k1"));

        // 获取全部参数
        Enumeration<String> attrs = servletContext.getAttributeNames();
        while (attrs.hasMoreElements()){
            String attrKey = attrs.nextElement();
            System.out.println(attrKey + " - " + servletContext.getAttribute(attrKey));
        }

        System.out.println("query context attribute!");

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ContextScope2Servlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }
}
