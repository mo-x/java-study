package org.goskyer.base.lambda.completableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Demo {

  public static void main(String[] args) throws Exception {
    whenComplete();
  }

  /** runAsync方法不支持返回值。 supplyAsync可以支持返回值。 */
  public void method() {

    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello world");
    CompletableFuture<String> future3 =
        future.thenApply((element) -> element + " 1").thenApply((element) -> element + " 2");
    try {
      System.out.println(future3.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  /**
   * whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
   * whenCompleteAsync：是执行把 whenCompleteAsync 这个任务继续提交给线程池来进行执行。
   * @throws Exception
   */
  public static void whenComplete() throws Exception {
    CompletableFuture<Void> future =
        CompletableFuture.runAsync(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
              }
              if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
              }
              System.out.println("run end ...");
            });
    future.whenCompleteAsync(
        new BiConsumer<Void, Throwable>() {
          @Override
          public void accept(Void t, Throwable action) {
            System.out.println("whenCompleteAsync 执行完成！");
          }
        });
    future.whenComplete(
        new BiConsumer<Void, Throwable>() {
          @Override
          public void accept(Void t, Throwable action) {
            System.out.println("执行完成！");
          }
        });
    future.exceptionally(
        new Function<Throwable, Void>() {
          @Override
          public Void apply(Throwable t) {
            System.out.println("执行失败！" + t.getMessage());
            return null;
          }
        });

    TimeUnit.SECONDS.sleep(2);
  }
}
