package org.goskyer.thread.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqno on 2017-5-29.
 * 阻塞队列 简单实现
 *
 */
public class BlockingQueue {

    private List arrayList;
    //容量
    private int limit;

    public BlockingQueue(int size) {
        arrayList = new ArrayList(size);
        this.limit = size;
    }
    //入列操作
    public synchronized void enqueue(Object item) throws InterruptedException {
        //达到arrylist上限 调用wait() 阻塞
        while (this.arrayList.size() == this.limit){
            System.out.println("add wait()");
            wait();
        }
        //达到arraylist下限 调用notifyAll() 唤醒所有阻塞线程
        if(this.arrayList.size() == 0){
            System.out.println("add notifyAll()");
            notifyAll();
        }
        this.arrayList.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.arrayList.size() == 0){
            System.out.println("dequeue wait()");
            wait();
        }
        if(this.arrayList.size() == this.limit){
            System.out.println("dequeue notifyAll()");
            notifyAll();
        }
        return this.arrayList.remove(0);
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(5);
        blockingQueue.enqueue(10);
        blockingQueue.enqueue(10);
        blockingQueue.enqueue(10);
        blockingQueue.enqueue(10);
        blockingQueue.enqueue(10);
        blockingQueue.dequeue();
        blockingQueue.enqueue(10);
    }




}
