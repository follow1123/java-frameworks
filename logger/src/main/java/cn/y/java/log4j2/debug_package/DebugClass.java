package cn.y.java.log4j2.debug_package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebugClass {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }
}
