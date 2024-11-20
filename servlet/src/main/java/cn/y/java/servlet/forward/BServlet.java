package cn.y.java.servlet.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fb")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("name: " + req.getParameter("name"));
        // 获取转发过来的路径
        System.out.println(req.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI));
        System.out.println("到达BServlet");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>BServlet</h1>");
    }
}
