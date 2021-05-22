//package com.hwq.fundamment.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.util.Assert;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import java.nio.charset.Charset;
//
///**
// * @Auther: Administrator
// * @Date: 2020/3/11 0011 10:07
// * @Description:
// */
//@Slf4j
//@Configuration
//public class JedisResourcePool {
//
//    private static JedisPool jedisPool = new JedisPool();
//
//    @Autowired
//    private JedisConnectionFactory jedisConnectionFactory;
//
////    @Value("${redis.ip}")
////    private  String ip;
////
////    @Value("${redis.port}")
////    private  Integer port;
////
////    @Value("${redis.max.total}")
////    private  Integer maxTotal;//最大连接数
////
////    @Value("${redis.max.idle}")
////    private  Integer maxIdle;//最大空闲状态实例
////
////    @Value("${redis.min.idle}")
////    private  Integer minIdle;//最小空闲状态实例
////
////    @Value("${redis.jedis.pool.max-wait}")
////    private long maxWaitMillis;
////
////    @Value("${redis.block-when-exhausted}")
////    private boolean  blockWhenExhausted;
////
////    @Value("${redis.timeout}")
////    private int timeout;
////
////    @Bean
////    public  JedisPool redisPoolFactory(){
////        log.info("JedisPool注入成功！！");
////        log.info("redis地址：" + ip + ":" + port);
////        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////        jedisPoolConfig.setMaxIdle(maxIdle);
////        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
////        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
////        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
////        // 是否启用pool的jmx管理功能, 默认true
////        jedisPoolConfig.setJmxEnabled(true);
////        JedisPool jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout);
////        return jedisPool;
////    }
//
//    public Jedis getJedis(){// 记的关闭jedis
//
//        if(jedisPool != null) {
//            return jedisPool.getResource();
//        } else {
//            jedisConnectionFactory.afterPropertiesSet();
//            return jedisPool.getResource();
//        }
//    }
//
//    //归还连接
//    public void returnResource(Jedis jedis){
//        jedisPool.returnResource(jedis);
//    }
//
//
//    @Bean
//    public StringRedisTemplate redisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory);
//        CustomStringRedisSerializer customStringRedisSerializer = new CustomStringRedisSerializer();
//        redisTemplate.setValueSerializer(customStringRedisSerializer);
//        redisTemplate.setKeySerializer(customStringRedisSerializer);
//        redisTemplate.setHashValueSerializer(customStringRedisSerializer);
//        redisTemplate.setHashKeySerializer(customStringRedisSerializer);
//        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    //redis序列化
//    class CustomStringRedisSerializer implements RedisSerializer<Object> {
//        private final Charset charset;
//        public CustomStringRedisSerializer() {
//            this(Charset.forName("UTF8"));
//        }
//        public CustomStringRedisSerializer(Charset charset) {
//            Assert.notNull(charset, "Charset must not be null!");
//            this.charset = charset;
//        }
//        public String deserialize(byte[] bytes) {
//            return (bytes == null ? null : new String(bytes, charset));
//        }
//        public byte[] serialize(Object o) {
//            return (o == null ? null : o.toString().getBytes(charset));
//        }
//    }
//
//}
