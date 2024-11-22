package cn.y.java.websocket;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;

public class WsConfig implements ServerApplicationConfig {
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
        HashSet<ServerEndpointConfig> configs = new HashSet<>();
        // 编程方式Endpoint配置方式
        if (endpointClasses.contains(ProgrammaticEndpoint.class)){
            configs.add(ServerEndpointConfig.Builder.create(ProgrammaticEndpoint.class, "/ws/echo").build());
        }
        return configs;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return scanned;
    }
}
