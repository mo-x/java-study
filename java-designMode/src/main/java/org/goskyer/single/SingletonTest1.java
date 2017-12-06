package org.goskyer.single;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zzqno on 2017-2-26.
 * 最优写法
 *
 */
public class SingletonTest1 {

    private SingletonTest1() {}

    private static ReentrantLock lock = new ReentrantLock();
    private static SingletonTest1 singleTest1;


    public static SingletonTest1 getSingleTest() {
        if (singleTest1 == null) {
            lock.lock();
            singleTest1 = new SingletonTest1();
            lock.unlock();
        }
        return singleTest1;
    }

    public static void main(String[] args) {
        SingletonTest1 test = SingletonTest1.getSingleTest();
        SingletonTest1 test1 = SingletonTest1.getSingleTest();
        System.out.println(test == test1);
    }
}
