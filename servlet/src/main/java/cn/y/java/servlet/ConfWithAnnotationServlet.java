package cn.y.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annoservlet") // 直接指定路径
// @WebServlet(name = "ConfWithAnnotationServlet", value = "/annoservlet") //指定名称或路径
// @WebServlet(urlPatterns = "/annoservlet") // 和显示指定路径，和value一样
// @WebServlet({"annoservlet1", "annoservlet2", "anno/*"}) // 指定多个路径
public class ConfWithAnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>ConfWithAnnotationServlet</h1>");
    }
}
