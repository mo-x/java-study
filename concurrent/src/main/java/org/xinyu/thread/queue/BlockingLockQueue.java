package org.xinyu.thread.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zzqno on 2017-5-29.
 */
public class BlockingLockQueue {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    private List list;

    private int limit;

    public int getLimit() {

        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public BlockingLockQueue(int limit) {
        this.limit = limit;
        list = new LinkedList();
    }


    public void enqueue(Object item) throws InterruptedException {
        lock.lock();
        while (this.list.size() == limit) {
            notFull.await();
        }
        while (this.list.size() == 0) {
            notEmpty.signal();
        }
        list.add(item);
        lock.unlock();
    }

    public void dequeue() throws InterruptedException {
        lock.lock();
        while (this.list.size() == 0){
            notEmpty.await();
        }

    }



}
