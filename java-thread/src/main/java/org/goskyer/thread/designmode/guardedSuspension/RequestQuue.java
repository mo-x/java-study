package org.goskyer.thread.designmode.guardedSuspension;

import java.util.LinkedList;

public class RequestQuue {

    private final LinkedList queue = new LinkedList();
    public synchronized Request getRequest(){
        while (queue.size() <= 0) {
            try {
                wait();

            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
        return (Request) queue.removeFirst();
    }

    public synchronized void putRequest(Request requst) {
        // TODO Auto-generated method stub
        queue.addLast(requst);
        notifyAll();
    }
}
