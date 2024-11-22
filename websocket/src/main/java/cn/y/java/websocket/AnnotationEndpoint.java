package cn.y.java.websocket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint("/ws/anno/echo")
public class AnnotationEndpoint{

    @OnMessage
    public void echoTxtMsg(Session session, String msg, boolean last){
        if (session.isOpen()) {
            try {
                System.out.printf("annotation string handle message %s is last: %b%n", msg, last);
                session.getBasicRemote().sendText(msg, last);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @OnMessage
    public void echoBinaryMsg(Session session, ByteBuffer byteBuffer, boolean last){
        if (session.isOpen()) {
            try {
                System.out.printf("annotation string handle binary %s is last: %b%n", byteBuffer.toString(), last);
                session.getBasicRemote().sendBinary(byteBuffer, last);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
