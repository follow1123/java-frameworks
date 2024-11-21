package cn.y.java.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class SessionBindingTestListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("session bind");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("session unbound");
    }
}
