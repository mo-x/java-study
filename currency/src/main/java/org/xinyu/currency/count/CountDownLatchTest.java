package org.xinyu.currency.count;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(10000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CountDownLatchTest0").start();

        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(5000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CountDownLatchTest1").start();

        System.out.println("等待2个子线程执行完毕...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}
