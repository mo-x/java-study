package org.xinyu.thread.interrupt;

/**
 * Created by monster_zzq on 2016/7/7.
 */
public class ThreadInterruptDemo2 implements Runnable{
    public void run() {
        boolean stop = false;
        while (!stop){
            System.out.println(" this thread is running...");
            try {
                Thread.sleep(3L);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("this thread exiting under request....");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        Thread threadInterrupt2 = new Thread(thread);
        System.out.println(" start thread .... ");
        threadInterrupt2.start();
        Thread.sleep(3000);
        System.out.println(" interrupt thread .... ");
        thread.interrupt();
        System.out.println("线程是否中断："+thread.isInterrupted());
      //  Thread.sleep(3000);
        System.out.println(" stop application ....");
    }
}
