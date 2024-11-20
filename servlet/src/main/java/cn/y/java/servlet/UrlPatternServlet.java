package cn.y.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({
        // "/" // 除了jsp文件可以正常访问外，其他路径都会走这个Servlet
        // "/*" // 所有路径都会走这个Servlet
        // "/a/*" // 所有以/a开头的路径都会走这个Servlet
        "*.do" // 所有以.do结尾的路径都会走这个Servlet
})
public class UrlPatternServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>UrlPatternServlet</h1>");
    }
}
