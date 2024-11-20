package cn.y.java.servlet.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rhtml")
public class RedirectToHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("a.html");
        // 无法访问首保护资源
        // resp.sendRedirect("WEB-INF/private.html");
        // 可以重定向到外部资源
        // resp.sendRedirect("https://www.baidu.com");
    }
}
