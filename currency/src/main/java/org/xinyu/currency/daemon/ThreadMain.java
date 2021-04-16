package org.xinyu.currency.daemon;

/**
 * Created by monster_zzq on 2016/7/13.
 */
public class ThreadMain {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.setDaemon(true);
        threadB.start();
        threadA.start();
        Thread threadMain = Thread.currentThread();
        System.out.println("线程A是不是守护线程 ："+threadA.isDaemon());
        System.out.println("线程B是不是守护线程 ："+threadB.isDaemon());
        System.out.println("线程main是不是守护线程 ：" + threadMain.isDaemon());
    }

}

class ThreadB extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 5L; i++) {
            System.out.println("后台线程B第" + i + "次执行");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 10L; i++) {
            System.out.println("后台线程A第" + i + "次执行");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}