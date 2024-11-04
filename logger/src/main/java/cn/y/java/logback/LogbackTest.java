package cn.y.java.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.LoggerFactory;

public class LogbackTest {

    private static final LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    @Test
    public void testLog() {
        // 获取logback原生的Logger打印日志
        Logger log = loggerContext.getLogger(LogbackTest.class);
        System.out.println(log.getLevel());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        try {
            if (1 == 1) throw new RuntimeException();
        }catch (Exception e){
            log.error("error by {}", 1, e);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "ALL", // 显示所有日志
            "TRACE", // 显示当前级别及以下级别的日志
            "DEBUG",
            "INFO",
            "WARN",
            "ERROR",
            "OFF" // 关闭日志
    })
    public void testLogLevel(String logLevel) {
        Logger log = loggerContext.getLogger(LogbackTest.class);
        log.setLevel(Level.toLevel(logLevel));
        System.out.println(log.getLevel());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
