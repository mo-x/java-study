package org.goskyer.thread.atomictest;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import static java.lang.Thread.*;

public class AtomicIntegerFieldUpdaterTest {

    static class A {

        volatile int intValue = 1000;
    }

    /**
     *      * 可以直接访问对应的变量，进行修改和处理
     *      * 条件：要在可访问的区域内，如果是private或挎包访问default类型以及非父亲类的protected均无法访问到
     *      * 其次访问对象不能是static类型的变量（因为在计算属性的偏移量的时候无法计算），也不能是final类型的变量（因为根本无法修改），必须是普通的成员变量
     *      *
     *      * 方法（说明上和AtomicInteger几乎一致，唯一的区别是第一个参数需要传入对象的引用）
     *      * @see AtomicIntegerFieldUpdater#addAndGet(Object, int)
     *      * @see AtomicIntegerFieldUpdater#compareAndSet(Object, int, int)
     *      * @see AtomicIntegerFieldUpdater#decrementAndGet(Object)
     *      * @see AtomicIntegerFieldUpdater#incrementAndGet(Object)
     *      *
     *      * @see AtomicIntegerFieldUpdater#getAndAdd(Object, int)
     *      * @see AtomicIntegerFieldUpdater#getAndDecrement(Object)
     *      * @see AtomicIntegerFieldUpdater#getAndIncrement(Object)
     *      * @see AtomicIntegerFieldUpdater#getAndSet(Object, int)
     *      
     */

    public final static AtomicIntegerFieldUpdater<A> ATOMIC_INTEGER_UPDATER = AtomicIntegerFieldUpdater.newUpdater(A.class, "intValue");


    public static void main(String[] args) {
        final A a = new A();
        //1
        int b = a.intValue;
        for (int i = 0; i < 100; i++) {
            final int num = i;
            new Thread(() -> {
                /**
                 * TODO
                 * 注意此处的第二个参数 如果直接使用a.intValue 每个线程都有修改的机会
                 * 而使用 1处的赋值方法 则只有一个线程有修改机会
                 * 比较过该类的字节码并无特殊的处理
                 */
                if (ATOMIC_INTEGER_UPDATER.compareAndSet(a, b, 120)){
                    System.out.println("我是线程：" + num + " 我对对应的值做了修改！");
                }
            }).start();
        }
        //等待执行完
        try {
            sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.intValue);

    }
}