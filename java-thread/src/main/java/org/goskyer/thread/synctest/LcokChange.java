package org.goskyer.thread.synctest;

/**
 * Created by zzqno on 2017-6-3.
 * 锁对象的改变
 */
public class LcokChange {

    private String lock = "123";

    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin" + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LcokChange lcokChange = new LcokChange();
        ThreadA threadA = new ThreadA(lcokChange);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(lcokChange);
        threadB.setName("B");
        threadA.start();
        Thread.sleep(50);
        threadB.start();
    }


}

class ThreadA extends Thread {
    private LcokChange lcokChange;

    public ThreadA(LcokChange lcokChange) {
        this.lcokChange = lcokChange;
    }

    @Override
    public void run() {
        lcokChange.testMethod();
    }
}

class ThreadB extends Thread {
    private LcokChange lcokChange;

    public ThreadB(LcokChange lcokChange) {
        this.lcokChange = lcokChange;
    }

    @Override
    public void run() {
        lcokChange.testMethod();
    }
}