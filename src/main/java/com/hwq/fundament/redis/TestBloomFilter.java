package com.hwq.fundament.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Auther: Administrator
 * @Date: 2020/2/3 0003 11:37
 * @Description: 测试布隆过滤器(可用于redis缓存穿透)
 * fpp 容错率
 *
 */
public class TestBloomFilter {

    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total,0.0001);

    public static void main(String[] args) {
        //初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }
        //匹配已经在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("有坏人逃脱了~~~~~");
            }
        }
        //匹配不再过滤器中的10000个值，有多少匹配出来
        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误伤的数量：" + count);
    }
}
