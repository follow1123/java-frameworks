package cn.y.java.servlet.lifecycle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
    public LifecycleServlet() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>LifecycleServlet</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
