package org.xinyu.currency.atomictest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zzqno on 2017-6-4.
 * 使用原子类来保证线程安全
 */
public class AddCountThread extends Thread {

    private AtomicInteger count = new AtomicInteger(0);

    /*   public void addNum() {
           System.out.println(Thread.currentThread().getName() + "加了100之后的值是：" + count.addAndGet(100));
           count.addAndGet(1);
       }
   */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        AddCountThread addCountThread = new AddCountThread();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();

    }
}


