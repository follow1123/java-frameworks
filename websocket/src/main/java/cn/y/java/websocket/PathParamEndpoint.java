package cn.y.java.websocket;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

// 使用{}表示参数
@ServerEndpoint("/ws/param/{name}/echo")
public class PathParamEndpoint {

    @OnOpen
    public void open(Session session, EndpointConfig ec, @PathParam("name") String name){
        // 配合 @PathParam 获取路径参数
        System.out.printf("handle path param %s%n", name);
        // 保存到当前会话内
        session.getUserProperties().put("name", name);
    }

    @OnMessage
    public void onHandlePathParam(Session session, String msg){
        if (session.isOpen()) {
            // 获取当前会话指定的数据
            String name = (String) session.getUserProperties().get("name");
            System.out.printf("get path param %s with message %s%n", name, msg);
            try {
                session.getBasicRemote().sendText(msg + name);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}