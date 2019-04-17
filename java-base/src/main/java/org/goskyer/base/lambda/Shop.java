package org.goskyer.base.lambda;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String name;
    public Shop(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    /**
     * 异步api：使用创建CompletableFuture类提供的工厂方法与getPriceAsync()效果完全一致
     * 可以更轻易的完成这个流程，并且不用担心实现细节
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncByFactory(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
    /**
     * 异步api：
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product){
        //创建CompletableFuture对象，它将包含计算结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //在新线程中异步计算结果
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                //需要长时间计算的任务结束时，设置future的返回值
                futurePrice.complete(price);
            }catch (Exception e){
                //如这里没有使用completeExceptionally，线程不会结束，调用方会永远的执行下去
                futurePrice.completeExceptionally(e);
            }
        }).start();
        //无需等待计算结果，直接返回future对象
        return futurePrice;
    }

    /**
     * 同步api:
     * 每个商店都需要提供的查询api：根据名称返回价格；
     * 模拟查询数据库等一些耗时操作：使用delay()模拟这些耗时操作。
     * @param product
     * @return
     */
    public double getPrice(String product){
        return calculatePrice(product);
    }

    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private Random random = new Random();
    /**
     * 模拟耗时操作：延迟一秒
     */
    private static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
