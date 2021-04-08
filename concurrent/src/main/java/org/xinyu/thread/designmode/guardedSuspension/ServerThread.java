package org.xinyu.thread.designmode.guardedSuspension;

public class ServerThread extends Thread {
    private RequestQuue requestQuue;

    public ServerThread(RequestQuue requestQuue, String name) {
        super(name);
        this.requestQuue = requestQuue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 1000; i++) {
            Request request = requestQuue.getRequest();
            System.out.println(Thread.currentThread().getName() + "   get   " + request.getName());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("try");
        }catch (Exception e){
            System.out.println("e");

        }finally {
            System.out.println("finally");
        }
    }
}
