package cn.y.java.servlet.scope_object;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/contextscope")
public class ContextScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ServletContext context = getServletContext();
        Object name = context.getAttribute("name");
        String content = null;
        if (name == null){
            content = "new attribute";
            context.setAttribute("name", "111");
        }else {
            content = "attribute: " + context.getAttribute("name");
        }
        resp.getWriter().write("<h1>" + content + "</h1>");
    }
}
