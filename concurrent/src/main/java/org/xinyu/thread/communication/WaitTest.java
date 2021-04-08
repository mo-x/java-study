package org.xinyu.thread.communication;

/**
 * Created by zzqno on 2017-6-4.
 * wait与Thread
 * wait 自动释放锁
 * sleep 不会
 */
public class WaitTest {

    public void testMethod(Object object) {
        try {
            synchronized (object) {
                System.out.println(" wait begin...");
              //  object.wait();
                Thread.sleep(10000);
                System.out.println(" wait end...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        TestThread1 testThread1 = new TestThread1(waitTest);
        testThread1.setName("testThread1");
        testThread1.start();
        TestThread2 testThread2 = new TestThread2(waitTest);
        testThread2.setName("testThread2");
        testThread2.start();
    }
}


class TestThread1 extends Thread {
    private Object object;

    public TestThread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        WaitTest waitTest = new WaitTest();
        waitTest.testMethod(object);
    }
}

class TestThread2 extends Thread {
    private Object object;

    public TestThread2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        WaitTest waitTest = new WaitTest();
        waitTest.testMethod(object);
    }
}