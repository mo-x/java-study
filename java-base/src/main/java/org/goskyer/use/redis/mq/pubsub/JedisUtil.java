package org.goskyer.use.redis.mq.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zzqno on 2017-4-11.
 */
public final class JedisUtil {

    public static JedisPool getJedisPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        return new JedisPool(config, "192.168.1.115", 6379);
    }
}
