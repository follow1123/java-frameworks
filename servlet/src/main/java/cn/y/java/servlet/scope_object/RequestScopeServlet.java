package cn.y.java.servlet.scope_object;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqscope")
public class RequestScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Object name = req.getAttribute("name");
        String content = null;
        if (name == null){
            content = "new attribute";
            req.setAttribute("name", "111");
        }else {
            content = "attribute: " + req.getAttribute("name");
        }
        resp.getWriter().write("<h1>" + content + "</h1>");
    }
}
