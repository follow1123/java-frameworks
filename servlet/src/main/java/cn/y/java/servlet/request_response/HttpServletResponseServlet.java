package cn.y.java.servlet.request_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp")
public class HttpServletResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI() + " start --------------");

        System.out.println("响应行 --------------");
        resp.setStatus(200); // 设置响应状态码

        System.out.println("响应头 --------------");
        resp.setHeader("aaa", "1234"); // 设置响应头信息
        resp.setContentType("text/html"); // 设置响应头的content-type，（媒体类型设置）

        System.out.println("响应体 --------------");
        // resp.getWriter(); // 获取响应的 Writer 用于写出数据
        // resp.getOutputStream(); // 获取响应的 OutputStream 用于写出数据
        // resp.setContentLength(10); // 设置响应内容长度，就是设置 content-length 响应头

        System.out.println("其他 --------------");
        resp.sendError(500, "server error"); // 响应错误信息
        resp.addCookie(new Cookie("bbb", "789")); // 设置 Cookie
        resp.setCharacterEncoding("UTF-8"); // 设置响应字符集

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>HttpServletResponseServlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }

}
