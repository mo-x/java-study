package org.goskyer.thread.disruptor;

import com.lmax.disruptor.EventHandler;


/**
 * 事件消费者
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Event: " + event);
    }
}