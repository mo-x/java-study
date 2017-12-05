package org.goskyer.thread.communication;

/**
 * Created by zzqno on 2017-6-6.
 * notify 只会随机唤醒一个等待线程
 * notifyAll 回唤醒所有等待线程
 *
 */
public class NotifyOne {

    public void testMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait() ThreadName=" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        WaitThreadA waitThreadA = new WaitThreadA(lock);
        waitThreadA.start();

        WaitThreadB waitThreadB = new WaitThreadB(lock);
        waitThreadB.start();

        WaitThreadC waitThreadC = new WaitThreadC(lock);
        waitThreadC.start();

        Thread.sleep(1000);
        NotityThread notifyThread = new NotityThread(lock);
        notifyThread.start();
     /*   NotityThread notifyThread1 = new NotityThread(redisson);
        notifyThread1.start();
        NotityThread notifyThread2 = new NotityThread(redisson);
        notifyThread2.start();*/
    }
}

class NotityThread extends Thread {
    private Object object;

    public NotityThread(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        synchronized (object){
            object.notify();
            object.notifyAll();
        }
    }
}

class WaitThreadA extends Thread {
    private Object object;

    public WaitThreadA(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        NotifyOne notifyOne = new NotifyOne();
        notifyOne.testMethod(object);
    }
}

class WaitThreadB extends Thread {
    private Object object;

    public WaitThreadB(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        NotifyOne notifyOne = new NotifyOne();
        notifyOne.testMethod(object);
    }
}

class WaitThreadC extends Thread {
    private Object object;

    public WaitThreadC(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        NotifyOne notifyOne = new NotifyOne();
        notifyOne.testMethod(object);
    }
}