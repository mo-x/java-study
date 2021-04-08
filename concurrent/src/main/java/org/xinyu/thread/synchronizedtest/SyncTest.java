package org.xinyu.thread.synchronizedtest;

/**
 * synchronized 作用域 代码示例
 *
 * 类锁和对象锁不冲突
 *
 * @author zhiqing.zhang
 */
public class SyncTest {


    public synchronized static void add1() {
        System.out.println("add1" + Thread.currentThread().getName());
    }


    public synchronized static void add2() {
        System.out.println("add2" + Thread.currentThread().getName());
    }

    public synchronized void get1() {
        System.out.println("get1" + Thread.currentThread().getName());
    }

    public synchronized void get2() {
        System.out.println("get2" + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
       /* ThreadClassA threadClassA = new ThreadClassA();
        Thread thread = new Thread(threadClassA);
        thread.start();
        ThreadClassB threadClassB = new ThreadClassB();
        Thread threadB = new Thread(threadClassB);
        threadB.start();*/
        SyncTest syncTest = new SyncTest();
        ThreadClassA threadClassA = new ThreadClassA(syncTest);
        Thread thread = new Thread(threadClassA);
        thread.start();
        ThreadClassB threadClassB = new ThreadClassB(syncTest);
        Thread threadB = new Thread(threadClassB);
        threadB.start();

    }
}


class ThreadClassA implements Runnable {
    private SyncTest syncTest;

    public ThreadClassA() {
    }

    public ThreadClassA(SyncTest syncTest) {
        this.syncTest = syncTest;
    }

    @Override
    public void run() {
        try {
            SyncTest.add1();
            syncTest.get1();
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadClassB implements Runnable {
    private SyncTest syncTest;

    public ThreadClassB() {
    }

    public ThreadClassB(SyncTest syncTest) {
        this.syncTest = syncTest;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000L);
            syncTest.get2();
            SyncTest.add2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}