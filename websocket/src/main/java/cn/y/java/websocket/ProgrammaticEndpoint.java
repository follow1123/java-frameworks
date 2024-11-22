package cn.y.java.websocket;

import javax.websocket.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ProgrammaticEndpoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
        session.addMessageHandler(new EchoMsgHandlerTxt(basicRemote));
        session.addMessageHandler(new EchoMsgHandlerBinary(basicRemote));
    }

    static class EchoMsgHandlerTxt implements MessageHandler.Whole<String> {

        private final RemoteEndpoint.Basic remoteEndpoint;

        EchoMsgHandlerTxt(RemoteEndpoint.Basic remoteEndpoint) {
            this.remoteEndpoint = remoteEndpoint;
        }

        @Override
        public void onMessage(String message) {
            System.out.printf("programmatic string handle message %s%n", message);
            if (remoteEndpoint != null){
                try {
                    remoteEndpoint.sendText(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class EchoMsgHandlerBinary implements MessageHandler.Whole<ByteBuffer> {

        private final RemoteEndpoint.Basic remoteEndpoint;

        EchoMsgHandlerBinary(RemoteEndpoint.Basic remoteEndpoint) {
            this.remoteEndpoint = remoteEndpoint;
        }

        @Override
        public void onMessage(ByteBuffer message) {
            System.out.printf("programmatic binary handle message %s%n", message.toString());
            if (remoteEndpoint != null){
                try {
                    remoteEndpoint.sendBinary(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
