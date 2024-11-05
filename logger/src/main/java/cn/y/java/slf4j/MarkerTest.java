package cn.y.java.slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MarkerTest implements Runnable, Callable {

    private static final Logger log = LoggerFactory.getLogger(MarkerTest.class);
    private static final Marker marker = MarkerFactory.getMarker("TEST");

    @Test
    public void test() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            pool.submit((Runnable) this);
            pool.submit((Callable<Object>) this);
        }
        pool.shutdown();
    }

    @Override
    public void run() {
        log.info(marker, new Random().nextInt() + "");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object call() throws Exception {
        log.info(marker, new Random().nextBoolean() + "");
        Thread.sleep(100);
        return "";
    }
}
