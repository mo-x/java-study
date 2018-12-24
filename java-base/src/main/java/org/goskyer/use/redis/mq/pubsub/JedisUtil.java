package org.goskyer.use.redis.mq.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zzqno on 2017-4-11.
 */
public final class JedisUtil {


    private static JedisPool jedisPool = null;

    public static JedisPool getJedisPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        return new JedisPool(config, "127.0.0.1", 6379);
    }

    public static Jedis getJedis() {
        if (jedisPool == null) {
            jedisPool = getJedisPool();
        }
        return jedisPool.getResource();
    }

    /*
     * 在finaally中回收jedis
     */
    public static void returnJedis(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.returnResource(jedis);
        }
    }

    /*
     * 销毁链接(放入catch
     */
    public static void returnBrokenResource(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.returnResource(jedis);
        }
    }

    /*
     * 判断key是否存在
     */
    public static boolean exists(String key) {
        Jedis jedis = getJedis();
        boolean exists = jedis.exists(key);
        returnJedis(jedis);
        return exists;
    }

    public static void main(String[] args) {
        boolean hello = JedisUtil.exists("hello");
    }
}
