package org.xinyu.currency.atomictest;

import lombok.extern.slf4j.Slf4j;
import org.xinyu.currency.annoations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * AtomicBoolean 可用于代码只执行一次
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanExample {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);
    private static final int clientTotal = 5000;
    private static final int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {

            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception:", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("isHappened:{}", isHappened.get());
        executorService.shutdown();
    }

    private static void test() {
        if (isHappened.compareAndSet(false, true)) {
            log.info("exectute");
        }
    }
}
