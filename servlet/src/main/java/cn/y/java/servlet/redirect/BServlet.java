package cn.y.java.servlet.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rb")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里无法获取之前的参数
        System.out.println("name: " + req.getParameter("name"));
        System.out.println("到达BServlet");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>BServlet</h1>");
    }
}
