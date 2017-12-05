package org.goskyer.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zzqno on 2017-4-1.
 */
public class ExecutePool {
    private static ExecutorService executorService;

    public ExecutePool(int maxPoolSize, int queueSize) {
        executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }

    public static void main(String[] args) {
        ExecutePool executePool = new ExecutePool(50, 1000);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    System.out.println("running");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executePool.execute(runnable);
        }
    }
}
