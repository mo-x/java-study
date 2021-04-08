package org.xinyu.thread.read_and_write_lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zzqno on 2017-3-12.
 */
public class ReentrantReadWriteLockDemo {

    private final Map<String, String> cache = new HashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    //得到一个可被多个线程公用的读锁，排斥所有写的操作
    private Lock readLock = reentrantReadWriteLock.readLock();

    //得到一个写锁，排斥所有的其他的读操作和写操作
    private Lock writeLock = reentrantReadWriteLock.writeLock();


    public void put(String k, String v) {
        String alreadyValue;
        //先上读锁
        readLock.lock();
        try {
            alreadyValue = cache.get(k);
            if (alreadyValue == null) {
                //不存在该值 释放读锁
                readLock.unlock();
                try {
                    //上写锁
                    writeLock.lock();
                    cache.put(k, v);
                } finally {
                    //释放写锁
                    writeLock.unlock();
                }
                //此处注意 若没上读锁 会无法释放读锁
                readLock.lock();
            }
        } finally {
            readLock.unlock();
        }
    }


    public String get(String k) {
        readLock.lock();
        String value;
        try {
            value = cache.get(k);

        } finally {
            readLock.unlock();
        }
        return value;
    }


    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        demo.put("hello", "world");
        System.out.println(demo.get("hello"));
        demo.put("java", "java");
        System.out.println(demo.get("java"));
    }

}
