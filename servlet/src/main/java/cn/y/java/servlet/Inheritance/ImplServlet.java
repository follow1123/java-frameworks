package cn.y.java.servlet.Inheritance;

import javax.servlet.*;
import java.io.IOException;

/**
 * 这个Servlet是顶级接口
 */
public class ImplServlet implements Servlet {
    /**
     * 初始化
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    /**
     * 获取Servlet配置
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 处理请求，响应数据
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    /**
     * 获取Servlet信息
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁Servlet
     */
    @Override
    public void destroy() {

    }
}
