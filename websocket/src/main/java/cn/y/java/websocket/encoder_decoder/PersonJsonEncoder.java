package cn.y.java.websocket.encoder_decoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Person转json对象编码器
 */
public class PersonJsonEncoder implements Encoder.Text<Person> {

    @Override
    public String encode(Person person) throws EncodeException {
        // 这里使用 jackson 进行 json 转换
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(EndpointConfig config) {}
    @Override
    public void destroy() {}
}
