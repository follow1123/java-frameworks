package cn.y.java.servlet.scope_object;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionscope")
public class SessionScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        Object name = session.getAttribute("name");
        String content = null;
        if (name == null){
            content = "new attribute";
            session.setAttribute("name", "111");
        }else {
            content = "attribute: " + session.getAttribute("name");
        }
        resp.getWriter().write("<h1>" + content + "</h1>");
    }
}
