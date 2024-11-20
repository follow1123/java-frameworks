package cn.y.java.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextTestListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initialized ------------------------");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setInitParameter("ctx-k1", "v1");
        servletContext.setInitParameter("ctx-k2", "v2");
    }
}
