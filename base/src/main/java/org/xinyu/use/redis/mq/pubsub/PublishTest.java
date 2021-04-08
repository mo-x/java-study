package org.xinyu.use.redis.mq.pubsub;

/**
 * Created by zzqno on 2017-4-11.
 */
public class PublishTest {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.publish("zzq:test:channel","hello world");
    }
}
