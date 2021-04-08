package org.xinyu.use.redis.mq.pubsub;

import redis.clients.jedis.Jedis;

/**
 * Created by zzqno on 2017-4-11.
 * 发布服务
 */
public class Publisher {

    public redis.clients.jedis.JedisPool JedisPool;
    public Jedis jedis;


    public Publisher() {
        JedisPool = JedisUtil.getJedisPool();
        jedis = JedisPool.getResource();
    }

    public void publish(final String channel, final String message) {
        new Thread(()->{
            System.out.println("发布：news.share");
            jedis.publish(channel, message);
        }).start();

    }
}
