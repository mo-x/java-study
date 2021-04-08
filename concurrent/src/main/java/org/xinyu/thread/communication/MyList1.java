package org.xinyu.thread.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqno on 2017-6-4.
 * wait 与 notify 使用示例
 */
public class MyList1 {

    public static List list = new ArrayList();

    public static void add() {
        list.add("zzq");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyList1 myList = new MyList1();
        Thread1 thread1 = new Thread1(object);
        thread1.setName("A");
        thread1.start();

        Thread2 thread2 = new Thread2(object);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(7000);
        System.out.println("main ==== size:"+MyList1.list.size());
    }
}

class Thread1 extends Thread {
    private Object object;

    public Thread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                if (MyList1.list.size() != 5) {
                    System.out.println(Thread.currentThread().getName() + " wait begin " + System.currentTimeMillis());
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + " wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    private Object object;

    public Thread2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    MyList1.add();
                    if (MyList1.list.size() == 5) {
                        object.notify();
                        System.out.println("已发出通知");
                        break;
                    }
                    System.out.println("添加了" + (i+1) + "个元素！");
                    Thread.sleep(1000);
                }
                System.out.println("size = "+MyList1.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
