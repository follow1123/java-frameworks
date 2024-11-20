package cn.y.java.servlet.lifecycle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/loadonstartup3", loadOnStartup = 98)
public class LoadOnStartup3Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化 LoadOnStartup3Servlet");
    }

}
