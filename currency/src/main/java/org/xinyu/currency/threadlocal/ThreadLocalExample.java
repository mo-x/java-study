package org.xinyu.currency.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * threadLocal 不具备继承性
 * threadLocal的set方法是获取当前线程 设置为KEY 所以在主线程设置 就只能通过主线程获取
 * 在子线程设置值 只能子线程获取
 */
@Slf4j
public class ThreadLocalExample {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
//        threadLocal.set("hello world");
        new Thread(() -> {
            threadLocal.set("hello world");
            log.info("thread:{}", threadLocal.get());//输出hello world

        }).start();
        log.info("main thread:{}", threadLocal.get());//输出null


    }
}
