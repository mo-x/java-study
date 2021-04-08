package org.xinyu.thread.communication;

/**
 * Created by zzqno on 2017-6-4.
 * wait 使用必须在同步块中调用
 * wait之后的代码是不会执行的
 */
public class Test2 {

    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("sout 上面");
            synchronized (lock) {
                System.out.println("sout 第一行");
                lock.wait();
                System.out.println("wait 下的代码");
            }
            System.out.println("sout 下的代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
