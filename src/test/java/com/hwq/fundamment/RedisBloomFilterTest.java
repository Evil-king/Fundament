package com.hwq.fundamment;

import com.hwq.fundamment.redis.RedisBloomFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2020/3/11 0011 12:36
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBloomFilterTest {
//    private static final int NUM_APPROX_ELEMENTS = 3000;
//    private static final double FPP = 0.03;
//    private static final int DAY_SEC = 60 * 60 * 24;
//    private static JedisResourcePool jedisResourcePool = new JedisResourcePool();

    @Autowired
    private RedisBloomFilter redisBloomFilter;


    @Test
    public void testInsert() throws Exception {
//        redisBloomFilter.insert("topic_read:8839540:20190609", "76930242", DAY_SEC);
//        redisBloomFilter.insert("topic_read:8839540:20190609", "76930243", DAY_SEC);
//        redisBloomFilter.insert("topic_read:8839540:20190609", "76930244", DAY_SEC);
//        redisBloomFilter.insert("topic_read:8839540:20190609", "76930245", DAY_SEC);
//        redisBloomFilter.insert("topic_read:8839540:20190609", "76930246", DAY_SEC);

        redisBloomFilter.put("1001");
        redisBloomFilter.put("1002");
        redisBloomFilter.put("1003");
        redisBloomFilter.put("1004");
        redisBloomFilter.put("1005");
    }

    @Test
    public void testMayExist() throws Exception {
//        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930242"));
//        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930244"));
//        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930246"));
//        System.out.println(redisBloomFilter.mayExist("topic_read:8839540:20190609", "76930248"));

//        System.out.println(redisBloomFilter.isExit("topic_read:8839540:20190609"));
////        System.out.println(redisBloomFilter.isExit("topic_read:8839540:20190609"));
////        System.out.println(redisBloomFilter.isExit("topic_read:8839540:20190609"));
////        System.out.println(redisBloomFilter.isExit("topic_read:8839540:20190609"));

        if(!redisBloomFilter.isExit("bf:fox")){
            System.out.println("不存在数据");
        } else {
            System.out.println("111111");
        }

    }
}
