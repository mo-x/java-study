package org.xinyu.thread.communication.waitInterruptException;

/**
 * Created by zzqno on 2017-6-5.
 * 出现异常时 锁也会释放
 */
public class TestService {

    public void testMethod(Object lock) {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " begin wait");
                lock.wait();
                //Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("出现异常 因为线程被interrupt了");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadOne threadOne = new ThreadOne(lock);
            threadOne.start();
            Thread.sleep(3000);
            threadOne.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadOne extends Thread {
    private Object object;

    public ThreadOne(Object o) {
        this.object = o;
    }

    @Override
    public void run() {
        TestService service = new TestService();
        service.testMethod(object);
    }
}