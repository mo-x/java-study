package org.xinyu.thread.synctest;

/**
 * Created by zzqno on 2017-6-4.
 * synchronized 代码块具有volatile同步功能
 */
public class Service {
    private boolean isContinueRun = true;

    public void runMethod() {
      /*  while (isContinueRun) {

        }
        System.out.println("停下来了！");*/
        String str = new String();
        while (isContinueRun){
      /*      synchronized (str) {
            }*/
        }
        System.out.println("停下来了！");
    }

    public void stopMethod() {
        isContinueRun = false;
        System.out.println(Thread.currentThread().getName()+"执行");
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadT threadT = new ThreadT(service);
        threadT.start();
        Thread.sleep(1000);
        ThreadS threadS = new ThreadS(service);
        threadS.start();
        System.out.println("已发起停止命令");
    }
}

class ThreadT extends Thread {
    private Service service;

    public ThreadT(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}

class ThreadS extends Thread {
    private Service service;

    public ThreadS(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMethod();
    }
}