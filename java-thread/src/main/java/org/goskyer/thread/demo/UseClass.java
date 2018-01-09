package org.goskyer.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zzqno on 2016-9-23.
 */
public class UseClass {
    public static void main(String[] args) {
        new UseClass().useArrayBlockingQueue();
    }


    public void useArrayBlockingQueue() {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(16);
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        String log = bq.take();
                        parseLog(log);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            for (int i = 0; i < 16; i++) {
                String log = (i + 1) + "----->";
                bq.put(log);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void parseLog(String log) {
        System.out.println(log + " " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
