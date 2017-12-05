package org.goskyer.thread.synctest;

/**
 * Created by zzqno on 2017-6-3.
 * 一半同步一半异步
 */
public class MyTask {

    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchroized threadName =" + Thread.currentThread() + "i=" + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchroized threadName =" + Thread.currentThread() + "i=" + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        MyThread1 thread1 = new MyThread1(myTask);
        thread1.start();
        MyThread2 thread2 = new MyThread2(myTask);
        thread2.start();
    }

}
