package cn.y.java.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Log4j2Test {

    private static final Logger log = LogManager.getLogger();

    @Test
    public void testLog() {
        System.out.println(log.getLevel());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }

    @ParameterizedTest
    @CsvSource({
            "ALL", // 显示所有日志
            "TRACE", // 显示当前级别及以下级别的日志
            "DEBUG",
            "INFO",
            "WARN",
            "ERROR",
            "FATAL",
            "OFF" // 关闭日志
    })
    public void testLogLevel(String logLevel) {
        Configurator.setLevel(log, Level.getLevel(logLevel));
        Configurator.setRootLevel(Level.ALL);
        System.out.println(log.getLevel());
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }
}
