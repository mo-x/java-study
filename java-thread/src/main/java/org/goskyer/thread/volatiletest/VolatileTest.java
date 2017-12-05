package org.goskyer.thread.volatiletest;

/**
 * Created by zzqno on 2017-6-3.
 */
public class VolatileTest extends Thread {

    volatile public static int count;

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {

    }
}
