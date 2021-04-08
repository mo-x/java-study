package org.xinyu.thread.disruptor.demo1;


import lombok.Data;

/**
 * 定义事件
 */
@Data
public class LongEvent {

    private long value;
}