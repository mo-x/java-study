package org.xinyu.thread.communication;

/**
 * Created by zzqno on 2017-6-4.
 * 出现 IllegalMonitorStateException
 * 原因是没有"对象监视器" 也就是没有同步加锁
 */
public class Test {
    public static void main(String[] args) {
        try {
            String str = new String("");
            str.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
