package org.xinyu.currency.atomictest;

import lombok.extern.slf4j.Slf4j;
import org.xinyu.currency.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 解决ABA问题代码示例
 */
@Slf4j
@ThreadSafe
public class CasAbaExample2 {

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(0, 0);

    public static void main(String[] args) throws InterruptedException {
        //stamp为版本号
        final int stamp = atomicStampedReference.getStamp();
        // reference 为具体的对象引用
        final Integer reference = atomicStampedReference.getReference();
        Thread t1 = new Thread(() -> {
            log.info(" t1 start reference:{} stamp:{}", reference, stamp);
            atomicStampedReference.compareAndSet(reference, reference + 10, stamp, stamp + 1);
            log.info(" t1 reference:{}", atomicStampedReference.getReference());
        });


        Thread t2 = new Thread(() -> {
            Integer reference1 = atomicStampedReference.getReference();
            log.info("t2 reference1:{}", reference1);
            atomicStampedReference.compareAndSet(reference1, reference1 + 10, stamp, stamp + 1);
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        log.info("reference:{} stamp:{}", atomicStampedReference.getReference(), atomicStampedReference.getStamp());
    }
}
