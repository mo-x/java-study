package org.goskyer.base.lambda;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    new Thread(
            () -> {
              // 模拟执行耗时任务
              System.out.println("task doing...");
              try {
                Thread.sleep(3000);
              } catch (Exception e) {
                // 告诉completableFuture任务发生异常了
                completableFuture.completeExceptionally(e);
              }
              // 告诉completableFuture任务已经完成
              completableFuture.complete("ok");
            })
        .start();
    // 获取任务结果，如果没有完成会一直阻塞等待
    String result = completableFuture.get();
    System.out.println("计算结果:" + result);
    // supplyAsync内部使用ForkJoinPool线程池执行任务
    CompletableFuture<String> completableFuture1 =
        CompletableFuture.supplyAsync(
            () -> {
              // 模拟执行耗时任务
              System.out.println("task doing...");
              try {
                Thread.sleep(3000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              // 返回结果
              return "result";
            });
    System.out.println("计算结果:" + completableFuture1.get());
  }
}
