package org.xinyu.thread.synctest.string;

/**
 * Created by zzqno on 2017-6-3.
 */
public class StringService {

    public static void print(String strParm) {
        try {
            synchronized (strParm) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringService stringService = new StringService();
        ThreadB threadB = new ThreadB(stringService);
        threadB.setName("B");
        threadB.start();
        ThreadA threadA = new ThreadA(stringService);
        threadA.setName("A");
        threadA.start();

    }
}

class ThreadB extends Thread {
    private StringService stringService;

    public ThreadB(StringService stringService) {
        super();
        this.stringService = stringService;
    }

    @Override
    public void run() {
        stringService.print("AA");
    }
}

class ThreadA extends Thread {
    private StringService stringService;

    public ThreadA(StringService stringService) {
        super();
        this.stringService = stringService;
    }

    @Override
    public void run() {
        stringService.print("AA");
    }
}
