package cn.y.java.servlet.session_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/*")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getRequestURI().endsWith("add")){
            Cookie c1 = new Cookie("aaa", "111");
            Cookie c2 = new Cookie("bbb", "222");
            c2.setMaxAge(60); // 一分钟后过期
            resp.addCookie(c1);
            resp.addCookie(c2);
            resp.getWriter().write("<h1>add cookie</h1>");
        }else {
            Cookie[] cookies = req.getCookies();
            StringBuilder sb = new StringBuilder("<h1>");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    sb.append(cookie.getName()).append(" - ").append(cookie.getValue()).append("\n");
                }
            }
            sb.append("</h1>");
            resp.getWriter().write(sb.toString());
        }
    }
}
