package org.xinyu.currency.atomictest;

import lombok.extern.slf4j.Slf4j;
import org.xinyu.currency.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ABA问题模拟，线程并发中，导致ABA问题，解决方案是使用|AtomicMarkableReference
 * 请参看相应的例子：AtomicStampedReferenceTest、AtomicMarkableReferenceTest
 */
@Slf4j
@ThreadSafe
public class CasAbaExample1 {

    private final static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs((int) (Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ATOMIC_REFERENCE.compareAndSet("abc", "abc2")) {
                    log.info("线程{}获取锁对对象进行了修改", num);
                }
            }).start();
        }

        new Thread(() -> {
            while (!ATOMIC_REFERENCE.compareAndSet("abc2", "abc")) {
                log.info("已经修改为原始值");
            }
        }).start();
    }

}