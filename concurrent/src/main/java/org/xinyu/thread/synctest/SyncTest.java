package org.xinyu.thread.synctest;

/**
 * Created by zzqno on 2017-6-3.
 */
public class SyncTest {

    synchronized public void addByKey() {
        System.out.println("addByKey start" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("addByKey end" + Thread.currentThread().getName());
    }

    public void addByThis() {
   /*     synchronized (this){
            System.out.println("addByThis");
        }*/
        System.out.println("addByThis start" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("addByThis end" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        TestA testA = new TestA(syncTest);
        testA.setName("A");
        TestB testB = new TestB(syncTest);
        testB.setName("B");
        testB.start();
        testA.start();

    }

}

class TestA extends Thread {
    private SyncTest syncTest;

    TestA(SyncTest syncTest) {
        this.syncTest = syncTest;
    }

    @Override
    public void run() {
        syncTest.addByKey();
    }
}

class TestB extends Thread {
    private SyncTest syncTest;

    TestB(SyncTest syncTest) {
        this.syncTest = syncTest;
    }

    @Override
    public void run() {
        syncTest.addByKey();
    }
}
