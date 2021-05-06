package org.xinyu.currency.cacheline;

/**
 * 本例子采用的L1缓存为64KB
 * 每个long类型占用8个字节 8*7=56
 * CacheLinePadding 该类为对象 对象头还占用了8个字节
 * 正好凑够64
 */
public class CacheLinePadding {
    public volatile long value = 0L;
    public long p1, p2, p3, p4, p5, p6;
}
