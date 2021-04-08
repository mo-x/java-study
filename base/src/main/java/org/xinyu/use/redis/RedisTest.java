package org.xinyu.use.redis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzqno on 2016-9-30.
 */
public class RedisTest {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisTest() {
        initialPool();
      /*  initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();*/
    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, "192.168.159.129", 6379);

        jedis = jedisPool.getResource();
        jedis.auth("123");

    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    /**
     * 字符串相关操作
     */
    public void testStringApi() {
        jedis.set("hello", "world");
        //追加操作
        jedis.append("hello", "hello world");
        jedis.set("java", "java");
        //设置存储的过期时间
        long expireLng = jedis.expire("java", 1);
        boolean exists = jedis.exists("javac");
        //不存在时添加
        long javacNx = jedis.setnx("javac", "javac");
        jedis.setnx("javac", "hello world");
        long time = jedis.ttl("java");
        jedis.setex("monster", 10, "zzq");
        System.out.println(expireLng);
        System.out.println(exists);
        System.out.println(jedis.get("java"));
        System.out.println(jedis.get("javac"));
        System.out.println(time);
        System.out.println(jedis.get("monster"));
        System.out.println(jedis.del(""));
        System.out.println(jedis.getrange("monster", 0, 0));
    }

    /**
     * list相关操作
     */
    public void testListApi() {
        flush();
        jedis.lpush("zzq", "vetor");
        jedis.lpush("zzq", "hello");
        jedis.lpush("zzq", "world");
        jedis.lpush("zzq", "java");
        //对指定下标进行修改
        jedis.lset("zzq", 0, "java");
        jedis.lindex("zzq", 0);
        jedis.lrange("zzq", 0, -1);
        //输出指定位置
        System.out.println(jedis.lindex("zzq", 0));
        //删除指定的元素
        System.out.println(jedis.lrem("zzq", 1, "java"));
        System.out.println(jedis.lrange("zzq", 0, -1));

        SortingParams sortingParameters = new SortingParams();
        sortingParameters.alpha();
        System.out.println(jedis.sort("zzq", sortingParameters));

    }


    public void testSetApi() {
        jedis.sadd("zhang", "zhiqing");
        jedis.sadd("zhang", "zhiqing");
        //判断元素是否存在集合中
        System.out.println(jedis.sismember("zhang", "zhiqing"));
        jedis.spop("zhang");
        for (String value : jedis.smembers("zhang")) {
            System.out.println(value);
        }

        //删除指定值
        jedis.srem("zhang", "zhiqing");
        jedis.smembers("zhang");
        System.out.println(jedis.smembers("zhang"));
        //集合运算
        //交集
        jedis.sinter("zhang","zhang");
        //并集
        jedis.sunion("zhang","zhang");
        //差集
        jedis.sdiff("zhang","zhang");
    }

    /**
     * 清空数据库
     */
    public void flush() {
        jedis.flushDB();
    }

    public static void main(String[] args) {
        RedisTest redisTest = new RedisTest();
        redisTest.initialPool();
        //redisTest.testStringApi();
        //redisTest.testListApi();
        redisTest.testSetApi();
    }

}
