package org.xinyu.base.question;

/**
 * Created by zzq on 16-10-19.
 */
public class Run {

    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }
    static void pong() {
        System.out.print("pong");
    }
}
