package org.xinyu.currency.atomictest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zzqno on 2017-6-4.
 * 使用原子操作时
 * 方法的调用是不同步的
 * 结果是正确的
 *
 */
public class MyService {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized void add() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + atomicInteger.addAndGet(100));
        System.out.println(Thread.currentThread().getName() + "执行+1操作之前");
        atomicInteger.addAndGet(1);
        System.out.println(Thread.currentThread().getName() + "执行+1操作之后");
    }

/*
    public  void add() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + atomicInteger.addAndGet(100));
        System.out.println(Thread.currentThread().getName() + "执行+1操作之前");
        atomicInteger.addAndGet(1);
        System.out.println(Thread.currentThread().getName() + "执行+1操作之后");
    }
*/

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread[] array = new MyThread[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new MyThread(myService);
        }
        for (int i = 0; i < array.length; i++) {
            array[i].start();
        }

        Thread.sleep(1000);
        System.out.println("result:" + MyService.atomicInteger.get());
    }
}

class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.add();
    }
}

