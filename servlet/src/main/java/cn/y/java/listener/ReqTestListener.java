package cn.y.java.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ReqTestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy");
    }
}
