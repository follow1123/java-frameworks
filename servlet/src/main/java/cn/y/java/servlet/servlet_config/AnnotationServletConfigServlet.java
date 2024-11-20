package cn.y.java.servlet.servlet_config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/annoconfig",
        initParams = {
                @WebInitParam(name = "k1", value = "v1"),
                @WebInitParam(name = "k2", value = "v2")
        })
public class AnnotationServletConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();

        // 获取指定key对应的数据
        System.out.println(servletConfig.getInitParameter("k1"));

        // 获取全部参数
        Enumeration<String> params = getServletConfig().getInitParameterNames();
        while (params.hasMoreElements()) {
            String key = params.nextElement();
            System.out.println(key + " - " + servletConfig.getInitParameter(key));
        }

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>AnnotationServletConfigServlet</h1>");
    }
}
