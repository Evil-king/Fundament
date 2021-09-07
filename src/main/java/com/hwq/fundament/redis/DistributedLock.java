//package com.hwq.fundament.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.core.script.RedisScript;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
///**
// * @author: Administrator
// * @date: 18/7/6 下午4:58
// * @description: 基于Redis实现的分布式锁
// */
//@Component
//@Slf4j
//public class DistributedLock {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    private static final Long SUCCESS = 1L;
//
//    /**
//     * 获取锁
//     *
//     * @param lockKey
//     * @param value
//     * @param expireTime：单位-秒
//     * @return
//     */
//    public boolean getLock(String lockKey, String value, int expireTime) {
//        String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
//        try {
//            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, expireTime);
//            if (SUCCESS.equals(result)) {
//                return true;
//            }
//        } catch (Exception e) {
//            log.error("获取锁异常", e);
//            throw new RuntimeException(e);
//        }
//        return false;
//    }
//
//    /**
//     * 释放锁
//     *
//     * @param lockKey
//     * @param value
//     * @return
//     */
//    public boolean releaseLock(String lockKey, String value) {
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        try {
//            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
//            if (SUCCESS.equals(result)) {
//                return true;
//            }
//        } catch (Exception e) {
//            log.error("释放锁异常", e);
//            throw new RuntimeException(e);
//        }
//        return false;
//    }
//}