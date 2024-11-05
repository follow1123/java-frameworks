package cn.y.java.log4j2.file_package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileClass {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.trace("trace");
            log.debug("debug");
            log.info("info");
            log.warn("warn");
            log.error("error");
        }
    }
}
