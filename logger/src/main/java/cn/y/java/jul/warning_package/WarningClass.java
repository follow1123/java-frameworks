package cn.y.java.jul.warning_package;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class WarningClass {

    static {
        try {
            LogManager.getLogManager().readConfiguration(WarningClass.class.getClassLoader().getResourceAsStream("log.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Logger log = Logger.getLogger(WarningClass.class.getName());

    public static void main(String[] args) {
        System.out.println(log.getParent().getLevel());
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }
}
