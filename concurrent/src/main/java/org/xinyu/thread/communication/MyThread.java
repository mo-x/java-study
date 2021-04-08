package org.xinyu.thread.communication;

/**
 * Created by zzqno on 2017-6-4.
 * wait 与 notify 使用示例
 */
public class MyThread extends Thread {
    private Object lock;

    public MyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 开始 wait time =" + System.currentTimeMillis());
                lock.wait();
                System.out.println(Thread.currentThread().getName() + "结束 wait time =" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread myThread = new MyThread(lock);
        myThread.setName("A");
        myThread.start();
        Thread.sleep(2000);
        MyThread2 myThread2 = new MyThread2(lock);
        myThread2.setName("B");
        myThread2.start();
    }
}

class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " 开始 notify time =" + System.currentTimeMillis());
            lock.notify();
            System.out.println(Thread.currentThread().getName() + " 结束 notify time =" + System.currentTimeMillis());
        }
    }
}