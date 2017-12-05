package org.goskyer.thread.synctest.waitforver;

/**
 * Created by zzqno on 2017-6-3.
 * 用不同的监视器对象解决无限等待问题
 */
public class Service {

    Object obj = new Object();

     public void methodA() {
/*        System.out.println("methodA begin");
        boolean isContinueRun = true;
        while (isContinueRun) {
        }
        System.out.println("methodA end");*/
        synchronized (obj) {
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun) {
            }
            System.out.println("methodA end");
        }
    }

    Object obj2 = new Object();

     public void methodB() {
     /*   System.out.println("methodB begin");
        System.out.println("methodB end");*/
        synchronized (obj2){
            System.out.println("methodB begin");
            System.out.println("methodB end");
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}


class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodA();
    }
}

class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}