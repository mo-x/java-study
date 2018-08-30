package org.goskyer.thread.jointest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * join方法可以让线程顺序执行
 */
public class JoinTest implements Runnable {

    private String name;

    public JoinTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinTest("One"));
        Thread thread2 = new Thread(new JoinTest("Two"));
        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}
