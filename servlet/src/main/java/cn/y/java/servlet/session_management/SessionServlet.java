package cn.y.java.servlet.session_management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String content = "new session";
        if (session.isNew()){
            String name = req.getParameter("name");
            System.out.println("name: " + name);
            if (name != null) session.setAttribute("user", name);
        }else {
            Object n = session.getAttribute("user");
            content = n == null ? "anonymous user" : "user: " + n;
        }
        resp.getWriter().write("<h1>" + content + "</h1>");
    }
}
