package cn.y.java.servlet.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextapi")
public class ContextApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println(req.getRequestURI() + " start --------------");
        // 获取项目运行时实际路径
        System.out.println("real path: " + servletContext.getRealPath(""));

        // 获取项目context路径
        System.out.println("context path: " + servletContext.getContextPath());

        // 获取项目内文件的媒体类型
        System.out.println(servletContext.getMimeType("a.html"));

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ContextApiServlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }
}
