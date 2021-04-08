package org.xinyu.thread.exception;

/**
 * Created by zzqno on 2017-2-22.
 * 实现UncaughtExceptionHandler接口 来实现 自定义异常
 *
 */
public class ExceptionHandlerThread implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(" AN Exception has bean captured \n");
        System.out.printf(" Thread: %s\n",t.getId());
        System.out.printf("Exception: %s:%s\n",e.getClass().getName());
        System.out.println("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s \n",t.getState());
    }
}
