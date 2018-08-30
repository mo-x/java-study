package org.goskyer.thread.disruptor.demo3;

import com.lmax.disruptor.EventHandler;
import org.goskyer.thread.disruptor.demo2.TradeTransaction;

public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction> {

    @Override
    public void onEvent(TradeTransaction event, long sequence,
                        boolean endOfBatch) {
        //do something....
        System.out.println("consumer: id=" + event.getId() + ",price=" + event.getPrice());
    }

}
