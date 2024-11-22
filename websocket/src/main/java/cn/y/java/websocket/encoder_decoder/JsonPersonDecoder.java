package cn.y.java.websocket.encoder_decoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * json转Person对象解码器
 */
public class JsonPersonDecoder implements Decoder.Text<Person> {

    @Override
    public Person decode(String s) throws DecodeException {
        // 这里使用 jackson 进行 json 转换
        ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(s, Person.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        // 这里是判断发送过来的字符串是否可以使用当前解码器
        return true;
    }
    @Override
    public void init(EndpointConfig config) {}
    @Override
    public void destroy() {}
}
