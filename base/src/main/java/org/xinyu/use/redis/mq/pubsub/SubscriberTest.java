package org.xinyu.use.redis.mq.pubsub;

/**
 * Created by zzqno on 2017-4-11.
 */
public class SubscriberTest {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        subscriber.subscribe("zzq:test:channel");
    }
}
