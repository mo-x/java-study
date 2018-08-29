package org.goskyer.thread.interrupt;

/**
 * Created by monster_zzq on 2016/7/7.
 */
public class ThreadInterruptDemo1 extends Thread {

    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            System.out.println(" this thread is running...");
            if (isInterrupted()) {
                System.out.println("break....");
                return;
            }
        }
        System.out.println("this thread exiting under request....");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruptDemo1 thread = new ThreadInterruptDemo1();
        System.out.println(" start thread .... ");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" interrupt thread .... ");
        thread.interrupt();
        System.out.println("线程是否中断：" + thread.isInterrupted());
        //    Thread.sleep(3000);
        System.out.println("application over ....");
    }
}
