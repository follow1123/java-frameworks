package cn.y.java.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 在 web.xml 内配置
public class ConfWithXmlFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("xml filter 请求之前的操作");

        // 放行
        chain.doFilter(req, res);

        System.out.println("xml filter 响应之前的操作");
    }

}
