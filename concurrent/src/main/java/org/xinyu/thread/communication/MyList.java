package org.xinyu.thread.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqno on 2017-6-4.
 */
public class MyList {

    private List list = new ArrayList();

    public void add() {
        list.add("zzq");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(myList);
        threadB.setName("A");
        threadB.start();
    }
}

class ThreadA extends Thread {
    private MyList myList;

    public ThreadA(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                myList.add();
                System.out.println("添加了" + (i++) + "个元素");
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (myList.size() == 5) {
                    System.out.println("==5,线程B 要退出...");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}