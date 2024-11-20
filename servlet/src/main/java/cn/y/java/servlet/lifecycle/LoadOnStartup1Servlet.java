package cn.y.java.servlet.lifecycle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/loadonstartup1", loadOnStartup = 101)
public class LoadOnStartup1Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化 LoadOnStartup1Servlet");
    }

}
