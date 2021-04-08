package org.xinyu.thread.producer_consumer;

import java.util.ArrayList;

/**
 * Created by zzqno on 2017-5-8.
 */
public class ProducerAndConsumerTest {


    public static void main(String[] args) {
        //Creating shared object
        ArrayList list = new ArrayList();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new ProducerTest(list));
        Thread consThread = new Thread(new ConsumerTest(list));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }
}

//Producer Class in java
class ProducerTest implements Runnable {

    private final ArrayList arrayList;

    public ProducerTest(ArrayList arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced: " + i);
            arrayList.add(i);
        }
    }

}

//Consumer Class in Java
class ConsumerTest implements Runnable {

    private final ArrayList arrayList;

    public ConsumerTest(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println("Consumed: " + arrayList.get(i));
                arrayList.remove(i);
            }

        }
    }
}
