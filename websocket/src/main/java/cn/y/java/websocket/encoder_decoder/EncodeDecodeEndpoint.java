package cn.y.java.websocket.encoder_decoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
        value = "/ws/ed/echo",
        encoders = PersonJsonEncoder.class, // 编码器
        decoders = JsonPersonDecoder.class // 解码器
)
public class EncodeDecodeEndpoint {

    @OnMessage
    public void echoJsonMsg(Session session, Person person){
        System.out.printf("encode decode handle message %s%n", person);
        if (session.isOpen()) {
            try {
                session.getBasicRemote().sendObject(person);
            } catch (IOException | EncodeException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
