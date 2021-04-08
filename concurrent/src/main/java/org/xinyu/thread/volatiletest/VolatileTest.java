package org.xinyu.thread.volatiletest;

/**
 * Created by zzqno on 2017-6-3.
 *volatile 不能保证原子性
 */
public class VolatileTest extends Thread {
    public volatile Integer v = 100;

    public void addCount() {
        for (int i = 0; i < 100; i++) {
            v++;
        }
        System.out.println("count=" + v);
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        Vo vo = new Vo(v);
        Vo vo1 = new Vo(v);
        Vo vo2 = new Vo(v);
        vo.start();
        vo1.start();
        vo2.start();
        System.out.println(v.v);
        try {
            Thread.sleep(3000L);
            System.out.println("最终结果:" + v.v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Vo extends Thread {
    VolatileTest volatileTest;

    public Vo(VolatileTest volatileTest) {
        this.volatileTest = volatileTest;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            volatileTest.addCount();
        }
    }

}
