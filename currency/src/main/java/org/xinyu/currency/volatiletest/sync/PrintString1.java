package org.xinyu.currency.volatiletest.sync;

/**
 * Created by zzqno on 2017-6-4.
 *
 */
public class PrintString1 implements Runnable{

    private boolean isContinuePrint = true;

    public void printStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        printStringMethod();
    }
    public static void main(String[] args) throws InterruptedException {
        PrintString1 printString = new PrintString1();
        new Thread(printString).start();
        //printString.printStringMethod();
        Thread.sleep(1000);
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
