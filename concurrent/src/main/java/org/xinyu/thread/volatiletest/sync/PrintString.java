package org.xinyu.thread.volatiletest.sync;

/**
 * Created by zzqno on 2017-6-4.
 * main线程处理循环 而无法设置isContinuePrint属性
 */
public class PrintString {
    private boolean isContinuePrint = true;

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintString printString = new PrintString();
        printString.printStringMethod();
        System.out.println("我要停止它！stopThread=" + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }
}
