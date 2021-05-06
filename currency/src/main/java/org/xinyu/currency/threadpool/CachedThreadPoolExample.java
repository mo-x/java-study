package org.xinyu.currency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CachedThreadPool 使用示例
 * 创建一个可缓存的线程池，若线程数超过处理所需，
 * 缓存一段时间后会回收，若线程数不够，则新建线程。
 */
public class CachedThreadPoolExample {


    public static void cachedThreadPool() {
        // 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 执行任务
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(() -> {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2000);
                } catch (InterruptedException e) {
                }
            });
        }
    }

    public static void main(String[] args) {
        CachedThreadPoolExample.cachedThreadPool();
    }
}
