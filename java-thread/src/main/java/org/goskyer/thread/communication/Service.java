package org.goskyer.thread.communication;

/**
 * Created by zzqno on 2017-6-5.
 * wait会自动释放锁
 * 而notify不会
 */
public class Service {

    public void testMethod(Object lock) {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " begin wait");
                lock.wait();
                //Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void synNotifyMthod(Object object) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " begin notify");
                // notify 不会自动释放锁 同步块执行完之后才会释放锁
                object.notify();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " end notify");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        TestThreadD testThreadD = new TestThreadD(object);
        testThreadD.setName("waitThread");
        testThreadD.start();


        TestThreadE testThreadE = new TestThreadE(object);
        testThreadE.setName("notifyThread");
        testThreadE.start();
    }
}

class TestThreadD extends Thread {
    private Object object;

    public TestThreadD(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(object);
    }
}

class TestThreadE extends Thread {
    private Object object;

    public TestThreadE(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMthod(object);
    }
}
