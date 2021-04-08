package org.xinyu.thread.createthread;

/**
 * Created by zzqno on 2017-3-10.
 */
public class CreateThreadByInterface implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" thread run " + i);
        }
    }


    public static void main(String[] args) {
        System.out.println("main thread start ....");
        CreateThreadByInterface createThreadByInterface = new CreateThreadByInterface();
        Thread thread = new Thread(createThreadByInterface);
        thread.start();
        System.out.println("main thread end ....");

    }
}
