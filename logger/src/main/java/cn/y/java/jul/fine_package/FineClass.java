package cn.y.java.jul.fine_package;


import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FineClass {

    static {
        try {
            LogManager.getLogManager().readConfiguration(FineClass.class.getClassLoader().getResourceAsStream("log.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Logger log = Logger.getLogger(FineClass.class.getName());

    public static void main(String[] args) {
        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("severe");
    }
}
