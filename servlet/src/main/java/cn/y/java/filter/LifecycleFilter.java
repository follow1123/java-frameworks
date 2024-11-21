package cn.y.java.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/filtertest/*")
public class LifecycleFilter extends HttpFilter {

    public LifecycleFilter() {
        System.out.println("lifecycle filter created");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("lifecycle filter init");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("lifecycle filter doFilter");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("lifecycle filter destroy");
    }
}
