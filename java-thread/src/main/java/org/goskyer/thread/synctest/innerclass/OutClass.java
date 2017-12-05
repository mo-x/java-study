package org.goskyer.thread.synctest.innerclass;

/**
 * Created by zzqno on 2017-6-3.
 */
public class OutClass {

    static class Inner {

        public void method1() {
            synchronized ("其他的锁") {
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        synchronized public void method2() {
            for (int i = 0; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + "i");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        new Thread(() -> {
            inner.method1();
        }, "A").start();

        new Thread(() -> {
            inner.method2();
        }).start();


    }


}
