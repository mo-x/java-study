package org.goskyer.thread.volatiletest;

/**
 * Created by zzqno on 2017-6-4.
 * volatile 解决死循环问题
 */
public class RunThread extends Thread {
    volatile private boolean isRunning = true;

    //private boolean isRunning = true;

    @Override
    public void run() {
        System.out.println(" 进入run方法...");
        super.run();
        while (isRunning){
        }
        System.out.println("线程被停止");
    }


    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(1000);
        runThread.setRunning(false);
        System.out.println("赋值为false");
    }
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
