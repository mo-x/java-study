package org.xinyu.currency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture 线程串行执行使用示例
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        //线程串行执行 不依赖上一次运行结果 无返回值
        CompletableFuture<Void> future1 = CompletableFuture
                .supplyAsync(() -> "hello siting", executor)
                .thenRunAsync(() -> System.out.println("OK"), executor);
        //线程串行执行 依赖上一次运行结果 无返回值
        CompletableFuture<Void> future2 = CompletableFuture
                .supplyAsync(() -> "hello siting", executor)
                .thenAcceptAsync(System.out::println, executor);

        //线程串行执行 依赖上一次运行结果 有返回值
        CompletableFuture<String> future3 = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenApplyAsync(data -> {
                    System.out.println(data);
                    return "OK";
                }, executor);
        System.out.println(future3.join());

        //thenCompose - 任务完成则运行fn，依赖上一个任务的结果，有返回值
        //第一个异步任务，常量任务
        CompletableFuture<String> f = CompletableFuture.completedFuture("OK");
        //第二个异步任务
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenComposeAsync(data -> {
                    System.out.println(data);
                    return f; //使用第一个任务作为返回
                }, executor);
        System.out.println(future.join());
        executor.shutdown();

    }
}
