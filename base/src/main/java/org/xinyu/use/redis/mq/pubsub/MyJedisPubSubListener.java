package org.xinyu.use.redis.mq.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by zzqno on 2017-4-11.
 */
public class MyJedisPubSubListener extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage -->");
        System.out.println("Channel:" + channel);
        System.out.println("Message:" + message.toString());
    }

    @Override
    // 初始化订阅时候的处理
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe:" + channel);
    }

    @Override
    // 取消订阅时候的处理
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe:" + channel);
    }

    // 初始化按表达式的方式订阅时候的处理
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
// System.out.println(pattern + "=" + subscribedChannels);
    }

    // 取消按表达式的方式订阅时候的处理
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
// System.out.println(pattern + "=" + subscribedChannels);
    }

    // 取得按表达式的方式订阅的消息后的处理
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + "=" + channel + "=" + message);
    }
}
