package org.xinyu.currency.exception;

/**
 * Created by zzqno on 2017-2-23.
 */
public class ThreadB implements Runnable {

    @Override
    public void run() {
        int numbert = Integer.parseInt("TTTT");
    }

    public static void main(String[] args) {
        ThreadB task = new ThreadB();
        Thread thread = new Thread(task);
        //设置线程的异常类
        thread.setUncaughtExceptionHandler(new ExceptionHandlerThread());
        thread.start();
    }
}
