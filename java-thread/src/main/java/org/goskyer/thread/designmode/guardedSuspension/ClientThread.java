package org.goskyer.thread.designmode.guardedSuspension;

import java.util.Random;

public class ClientThread extends Thread {
    private RequestQuue requestQuue;

    public ClientThread(RequestQuue requestQuue, String name) {
        super(name);
        this.requestQuue = requestQuue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 1000; i++) {
            Request request = new Request("request" + i);
            requestQuue.putRequest(request);
            System.out.println(Thread.currentThread().getName() + "   put    " + request.getName());
            try {
                sleep(new Random().nextInt(200));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
