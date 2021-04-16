package org.xinyu.currency.threadgroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by monster_zzq on 2016/7/14.
 */
public class SearchTask implements Runnable {

    private Result result;


    public SearchTask(Result result) {
        this.result = result;
    }
    //它会调用doTask() 方法和等待它结束或者接收一个 InterruptedException 异常。 这方法会写信息表明开始，结束，或者线程中断。
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: End\n", name);
    }

//实现 doTask() 方法。它会创建一个 Random 对象生一个随机数字并用这个数字调用 sleep() 方法 。
    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }


    public static void main(String[] args) {
        //首先, 创建一个 ThreadGroup 对象命名 Searcher.
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        //然后, 创建 一个 SearchTask 对象和 一个 Result 对象。
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        // 现在， 使用SearchTask对象创建 10个 Thread o对象。当你调用Thread 类的构造函数时，传递它作为ThreadGroup对象的第一个参数。
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //使用list() 方法写关于 ThreadGroup ob对象信息。
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        //使用 activeCount() 和 enumerate() 方法来获取线程个数和与ThreadGroup对象关联的线程的列表。我们可以用这个方法来获取信息， 例如，每个线程状态。
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        //调用 waitFinish()方法. 我们等下来实现这方法。它会等待ThreadGroup对象中的其中一个线程结束。
        waitFinish(threadGroup);
        threadGroup.interrupt();
    }

    //实现 waitFinish() 方法. 它会使用 activeCount() 方法来控制到最后一个线程。
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
