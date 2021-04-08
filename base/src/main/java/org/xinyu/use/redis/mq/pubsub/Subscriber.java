package org.xinyu.use.redis.mq.pubsub;

import redis.clients.jedis.Jedis;

/**
 * Created by zzqno on 2017-4-11.
 * 订阅服务
 */
public class Subscriber {

    public redis.clients.jedis.JedisPool JedisPool;
    public Jedis jedis;

    public Subscriber() {
        JedisPool = JedisUtil.getJedisPool();
        jedis = JedisPool.getResource();
    }

    /**
     * 订阅
     * @param channel
     */
    public void subscribe(String channel) {
        new Thread(() -> {
            System.out.println("订阅：");
            jedis.subscribe(new MyJedisPubSubListener(), channel);
        }).start();
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
}
