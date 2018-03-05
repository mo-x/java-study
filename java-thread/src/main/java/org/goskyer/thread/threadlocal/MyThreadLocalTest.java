package org.goskyer.thread.threadlocal;

/**
 * Created by zzqno on 2017-4-5.
 */
public class MyThreadLocalTest {

    /**
     * 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定其初始值
     */
    private static MyThreadLocal<Integer> seqNum;

    static {
        seqNum = new MyThreadLocal<Integer>() {
            @Override
            public Integer initialValue() {
                return 0;
            }
        };
    }


    public MyThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        MyThreadLocalTest threadMain = new MyThreadLocalTest();
        //3个线程共享threadmain 各自产生序列号
        TestClient t1 = new TestClient(threadMain);
        TestClient t2 = new TestClient(threadMain);
        TestClient t3 = new TestClient(threadMain);
        t1.start();
        t2.start();
        t3.start();
    }


    /**
     * 线程类
     */
    private static class TestClient extends Thread {
        private MyThreadLocalTest sn;

        public TestClient(MyThreadLocalTest sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            //4.每个线程打印出3个序列值
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] -->sn[" + sn.getNextNum() + "]");
            }
            //显示调用该方法清除线程的局部变量并不是必须的操作 但可以加快内存回收的速度
            sn.getThreadLocal().remove();//每个线程用完的时候要记得删除
        }
    }


}
