package org.goskyer.thread.synctest;

/**
 * Created by zzqno on 2017-6-3.
 */
public class MyThread1 extends Thread {

    private MyTask myTask;

    public MyThread1(MyTask myTask) {
        this.myTask = myTask;
    }

    @Override
    public void run() {
        super.run();
        this.myTask.doLongTimeTask();
    }
}
