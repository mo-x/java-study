package org.xinyu.currency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture 使用异步线程
 *
 * @author zhiqin.zhang
 */
public class CompletableFutureExample {


    public static void main(String[] args) {
        //使用线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("hello future");
        }, executor);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("hello future1");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello future2");
            return "string";
        });

    }
}
