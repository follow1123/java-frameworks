package cn.y.java.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeTestListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context add attribute");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context remove attribute");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context replace attribute");
    }
}
