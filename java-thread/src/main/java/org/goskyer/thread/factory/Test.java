package org.goskyer.thread.factory;

import java.util.concurrent.*;

public class Test {


    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new MyThreadFactory("demo-pool-%d");


        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                                                                  0L, TimeUnit.MILLISECONDS,
                                                                  new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}
