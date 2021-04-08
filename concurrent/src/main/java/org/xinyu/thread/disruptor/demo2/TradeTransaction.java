package org.xinyu.thread.disruptor.demo2;

import lombok.Data;

/**
 * 交易demo
 */
@Data
public class TradeTransaction {

    private String id;//交易ID
    private double price;//交易金额
}
