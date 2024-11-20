package cn.y.java.servlet.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/context")
public class ServletContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(req.getRequestURI() + " start --------------");
        // 单独获取
        System.out.println(servletContext.getInitParameter("ctx-k1"));

        // 获取全部参数
        Enumeration<String> params = servletContext.getInitParameterNames();
        while (params.hasMoreElements()){
            String key = params.nextElement();
            System.out.println(key + " - " + servletContext.getInitParameter(key));
        }

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ServletContextServlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }
}
