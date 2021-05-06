package org.xinyu.currency.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * SingleThreadScheduledExecutor 使用示例
 * 创建一个单线程的可以执行延迟任务的线程池。
 */
public class SingleThreadScheduledExecutorExample {

    public static void SingleThreadScheduledExecutor() {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        // 添加定时执行任务(2s 后执行)
        System.out.println("添加任务,时间:" + new Date());
        threadPool.schedule(() -> {
            System.out.println("任务被执行,时间:" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        SingleThreadScheduledExecutorExample.SingleThreadScheduledExecutor();
    }

}
