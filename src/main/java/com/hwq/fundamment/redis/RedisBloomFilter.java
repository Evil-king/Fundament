package com.hwq.fundamment.redis;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Longs;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/3/11 0011 10:02
 * @Description:基于redis实现的BloomFilter
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "bloom.filter")
@Component
public class RedisBloomFilter {
//    @Autowired
//    private JedisResourcePool jedisResourcePool;
    @Autowired
    private RedisTemplate redisTemplate;


    private static final String BF_KEY_PREFIX  = "bf";

    //预计插入量
    private long expectedInsertions;
    //误判率
    private double fpp;
    //hash函数数量
    private int numHashFunctions;
    //bit数组长度
    private long numBits;


    @PostConstruct
    public void init(){
        this.numBits = optimalNumOfBits(expectedInsertions,fpp);
        this.numHashFunctions = optimalNumOfHashFunctions(expectedInsertions,numBits);
    }


//    /**
//     * 构造布隆过滤器。注意：在同一业务场景下，三个参数务必相同
//     *
//     * @param expectedInsertions 预估元素数量
//     * @param fpp               可接受的最大误差（假阳性率）
//     * @param jedisResourcePool Codis专用的Jedis连接池
//     */
//    public RedisBloomFilter(int expectedInsertions, double fpp, JedisResourcePool jedisResourcePool,RedisTemplate redisTemplate) {
//        this.expectedInsertions = expectedInsertions;
//        this.fpp = fpp;
//        this.jedisResourcePool = jedisResourcePool;
//        this.redisTemplate = redisTemplate;
//
//        numBits = (int) (-expectedInsertions * Math.log(fpp) / (Math.log(2) * Math.log(2)));
//        numHashFunctions = Math.max(1, (int) Math.round((double) numBits / expectedInsertions * Math.log(2)));
//    }

//    /**
//     * 取得自动计算的最优哈希函数个数
//     */
//    public int getNumHashFunctions() {
//        return numHashFunctions;
//    }
//
//    /**
//     * 取得自动计算的最优Bitmap长度
//     */
//    public int getBitmapLength() {
//        return numBits;
//    }

//    @PostConstruct
//    public void init() {
//        this.numBits = optimalNumOfBits(expectedInsertions, fpp);
//        this.numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, numBits);
//    }
//
//
    //计算hash函数个数
    private int optimalNumOfHashFunctions(long n, long m) {
        // (m / n) * log(2), but avoid truncation due to division!
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    //计算bit数组长度
    private long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

//    /**
//     * 插入元素
//     *
//     * @param key       原始Redis键，会自动加上'bf:'前缀
//     * @param element   元素值，字符串类型
//     * @param expireSec 过期时间（秒）
//     */
//    public void insert(String key, String element, int expireSec) {
//        if (key == null || element == null) {
//            throw new RuntimeException("键值均不能为空");
//        }
//        String actualKey = BF_KEY_PREFIX.concat(key);
//
//        try (Jedis jedis = jedisResourcePool.getJedis()) {
//            try (Pipeline pipeline = jedis.pipelined()) {
//                for (long index : getBitIndices(element)) {
//                    pipeline.setbit(actualKey, index, true);
//                }
//                pipeline.syncAndReturnAll();
//            } catch (IOException ex) {
//                log.error("pipeline.close()发生IOException", ex);
//            }
//            jedis.expire(actualKey, expireSec);
//        }
//    }
//
//    /**
//     * 检查元素在集合中是否（可能）存在
//     *
//     * @param key     原始Redis键，会自动加上'bf:'前缀
//     * @param element 元素值，字符串类型
//     */
//    public boolean mayExist(String key, String element) {
//        if (key == null || element == null) {
//            throw new RuntimeException("键值均不能为空");
//        }
//        String actualKey = BF_KEY_PREFIX.concat(key);
//        boolean result = false;
//
//        try (Jedis jedis = jedisResourcePool.getJedis()) {
//            try (Pipeline pipeline = jedis.pipelined()) {
//                for (long index : getBitIndices(element)) {
//                    pipeline.getbit(actualKey, index);
//                }
//                result = !pipeline.syncAndReturnAll().contains(false);
//            } catch (IOException ex) {
//                log.error("pipeline.close()发生IOException", ex);
//            }
//        }
//
//        return result;
//    }
//
//
//    /**
//     * 计算一个元素值哈希后映射到Bitmap的哪些bit上
//     *
//     * @param element 元素值
//     * @return bit下标的数组
//     */
//    private long[] getBitIndices(String element) {
//        long[] indices = new long[numHashFunctions];
//
//        byte[] bytes = Hashing.murmur3_128()
//                .hashObject(element, Funnels.stringFunnel(Charset.forName("UTF-8")))
//                .asBytes();
//
//        long hash1 = Longs.fromBytes(
//                bytes[7], bytes[6], bytes[5], bytes[4], bytes[3], bytes[2], bytes[1], bytes[0]
//        );
//        long hash2 = Longs.fromBytes(
//                bytes[15], bytes[14], bytes[13], bytes[12], bytes[11], bytes[10], bytes[9], bytes[8]
//        );
//
//        long combinedHash = hash1;
//        for (int i = 0; i < numHashFunctions; i++) {
//            indices[i] = (combinedHash & Long.MAX_VALUE) % numBits;
//            combinedHash += hash2;
//        }
//
//        return indices;
//    }

    public void put(String key){
        long[] indexs = getIndex(key);
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                for(long index: indexs){
                    redisConnection.setBit("bf:fox".getBytes(),index,true);
                }
                redisConnection.close();
                return null;
            }
        });
    }


    public boolean isExit(String key){
        long[] indexs = getIndex(key);
        List list = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                for(long index:indexs){
                    redisConnection.getBit("bf:fox".getBytes(),index);
                }
                redisConnection.close();
                return null;
            }
        });
        return !list.contains(false);
    }

    private long[] getIndex(String key){
        long hash1 = Hashing.murmur3_128().hashCode();
        long hash2 = hash1 >>> 16;
        long[] result = new long[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            long combineHash = hash1 + i * hash2;
            if(combineHash < 0){
                combineHash = ~combineHash;
            }
            result[i] = combineHash % numBits;
        }
        return result;
    }

}
