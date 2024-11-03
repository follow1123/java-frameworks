package cn.y.java.jul;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JDKLogTest {

    @Test
    public void testLog() {
        Logger log = Logger.getLogger("test log");
        /*
            由于默认的日志级别是INFO，所以下面只有INFO WARNING SEVERE这三个日志级别
            使用setLevel修改日志级别也没用，需要找到父log获取对应的handler再修改日志级别才有效
         */
        System.out.println(log.getParent().getLevel()); // INFO
        log.setLevel(Level.ALL); // 无效
        log.getParent().setLevel(Level.ALL); // 无效
        // log.getParent().getHandlers()[0].setLevel(Level.ALL); // 有效

        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }

    @Test
    public void testLogFormatter() {
        Logger log = Logger.getLogger("test log formatter");
        // 不使用父logger，自己指定handler
        log.setUseParentHandlers(false);
        // 创建日志处理器
        ConsoleHandler handler = new ConsoleHandler();
        /*
            设置日志处理器的级别
            这个日志级别是默认的最高级别
            在这里设置后，使用log.setLevel设置的日志级别不能超过这里的级别
         */
        handler.setLevel(Level.ALL);
        // 自定义格式化显示日志
        handler.setFormatter(new CustomFormatter());
        log.addHandler(handler);

        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }

    @ParameterizedTest
    @CsvSource({
            "OFF", // 关闭日志
            "ALL", // 显示所有日志
            "FINEST", // 显示当前级别及以下级别的日志
            "FINER",
            "FINE",
            "CONFIG",
            "INFO",
            "WARNING",
            "SEVERE"
    })
    public void testLogLevel(String logLevel) {
        Logger log = Logger.getLogger("test log level");
        Handler[] handlers = log.getHandlers();
        if (handlers.length == 0){
            ConsoleHandler handler = new ConsoleHandler();
            handler.setLevel(Level.ALL);
            handler.setFormatter(new CustomFormatter());
            log.addHandler(handler);
        }
        log.setUseParentHandlers(false);
        log.setLevel(Level.parse(logLevel));
        System.out.println(log.getLevel());
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }

    @Test
    public void testLogUseConfig() {
        /*
            默认日志配置文件在
                %JAVA_HOME%/conf/logging.properties(jdk8及之前)
                %JAVA_HOME%/jre/lib/logging.properties(jdk8之后)
         */
        try {
            LogManager manager = LogManager.getLogManager();
            InputStream is = getClass().getClassLoader().getResourceAsStream("log.properties");
            manager.readConfiguration(is);
            Logger log = Logger.getLogger("test log use config");
            log.finest("finest");
            log.finer("finer");
            log.fine("fine");
            log.config("config");
            log.info("info");
            log.warning("warning");
            log.severe("severe");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

