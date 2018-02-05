package org.goskyer.thread.atomictest;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import static java.lang.Thread.sleep;

public class AtomicReferenceFieldUpdaterTest {


    static class B {
        volatile String stringValue = "abc";
    }

    public static final AtomicReferenceFieldUpdater<B, String> ATOMIC_REFERENCE_FIELD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(B.class, String.class, "stringValue");

    public static void main(String[] args) {
        final B b = new B();
        for (int i = 0; i < 100; i++) {
            final int num = i;
            new Thread(() -> {
                if (ATOMIC_REFERENCE_FIELD_UPDATER.compareAndSet(b, "abc", "ccc")) {
                    System.out.println("我是线程：" + num + " 我对对应的值做了修改！value-> "+ b.stringValue);
                }
            }).start();
        }
        //等待执行完
        try {
            sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(b.stringValue);

    }
}
