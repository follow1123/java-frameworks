package cn.y.java.servlet.request_response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/req")
public class HttpServletRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI() + " start --------------");

        System.out.println("请求行 --------------");
        System.out.println(req.getRequestURL()); // 获取URL
        System.out.println(req.getRequestURI()); // 获取URI
        System.out.println(req.getServerPort()); // 获取客户端发送请求时的端口
        System.out.println(req.getLocalPort()); // 获取当前应用所在容器的端口
        System.out.println(req.getRemotePort()); // 获取客户端程序的端口
        System.out.println(req.getScheme()); // 获取请求协议
        System.out.println(req.getProtocol()); // 获取请求协议和版本号
        System.out.println(req.getMethod()); // 获取请求方法

        System.out.println("请求头 --------------");

        System.out.println(req.getHeader("Host")); // 获取请求头
        Enumeration<String> headerNames = req.getHeaderNames(); // 获取所有请求头的key
        System.out.println(req.getContentType()); // 获取ContentType请求头

        System.out.println("请求参数 --------------");
        System.out.println(req.getQueryString()); // 获取URL上拼接的请求参数
        System.out.println(req.getParameter("a")); // 根据名称获取参数的值
        System.out.println(req.getParameterValues("b")); // 根据名称获取参数的值，多个值
        Enumeration<String> parameterNames = req.getParameterNames(); // 根据名称获取参数的值，所有值
        System.out.println(req.getParameterMap()); // 以Map结构获取请求参数
        BufferedReader reader = req.getReader(); // 获取请求内容的Reader
        // ServletInputStream inputStream = req.getInputStream(); // 获取请求内容的InputStream
        System.out.println(req.getContentLength()); // 获取请求长度

        System.out.println("其他 --------------");
        System.out.println(req.getServletPath()); // 获取请求的Servlet路径
        ServletContext servletContext = req.getServletContext(); // 获取Servlet Context对象
        System.out.println(req.getCookies().length); // 获取 Cookie
        HttpSession session = req.getSession(); // 获取 Session
        req.setCharacterEncoding("UTF-8"); // 设置请求字符集

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>HttpServletRequestServlet</h1>");
        System.out.println(req.getRequestURI() + " end --------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getContentType());
        System.out.println(req.getParameter("name"));
        resp.getWriter().write("<h1>OK</h1>");
    }
}
