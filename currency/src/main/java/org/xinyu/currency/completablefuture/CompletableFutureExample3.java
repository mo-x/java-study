package org.xinyu.currency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample3 {

    /**
     * 两个CompletableFuture并行执行完，然后执行action，不依赖上两个任务的结果，无返回值
     */
    public static void main(String[] args) {
        //第一个异步任务，常量任务
        CompletableFuture<String> first = CompletableFuture.completedFuture("hello world");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "hello siting", executor)
                // () -> System.out.println("OK") 是第三个任务
                .runAfterBothAsync(first, () -> {
                    try {
                        System.out.println("OK");
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }, executor);

        CompletableFuture<Void> future2 = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "hello siting", executor)
                // () -> System.out.println("OK") 是第三个任务
                .runAfterBothAsync(first, () -> System.out.println("two"), executor);


        //第一个异步任务，常量任务
        CompletableFuture<String> first1 = CompletableFuture.completedFuture("hello world");
        CompletableFuture<Void> future1 = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "hello siting", executor)
                // (w, s) -> System.out.println(s) 是第三个任务
                .thenAcceptBothAsync(first, (s, w) -> System.out.println(s), executor);
//        executor.shutdown();

    }
}
