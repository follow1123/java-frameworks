package cn.y.java.listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionbind/*")
public class SessionBingingTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        if (uri.endsWith("bind")){
            session.setAttribute("testBindListener", new SessionBindingTestListener());
        }else if (uri.endsWith("unbind")){
            session.removeAttribute("testBindListener");
        }
        resp.getWriter().write("<h1>SessionBingingTestServlet</h1>");
    }
}
