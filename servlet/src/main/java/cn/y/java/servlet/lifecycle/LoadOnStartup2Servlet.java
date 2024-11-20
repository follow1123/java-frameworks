package cn.y.java.servlet.lifecycle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 这个使用xml配置
 */
public class LoadOnStartup2Servlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化 LoadOnStartup2Servlet");
    }

}
