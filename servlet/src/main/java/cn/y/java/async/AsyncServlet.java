package cn.y.java.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取结果，如果有结果直接返回
        Object result = req.getSession().getAttribute("result");
        if (result != null){
            resp.getWriter().write("<h1>OK result: " + result + "</h1>");
            return;
        }
        // 开启异步任务
        AsyncContext asyncContext = req.startAsync();
        System.out.println("asyncContext default timeout: " + asyncContext.getTimeout());
        asyncContext.start(() -> {
            try {
                Thread.sleep(2000);
                HttpSession session = ((HttpServletRequest) asyncContext.getRequest()).getSession();
                session.setAttribute("result", "111");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                asyncContext.complete();
            }
        });

        // 先返回正在处理
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<h1>正在处理</h1>");
    }
}
