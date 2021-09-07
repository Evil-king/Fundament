package com.hwq.fundament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2020/2/5 0005 10:16
 * @Description:
 */
@RestController
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/login/{id}")
//    public User login(@PathVariable int id){
//        User user = userService.login(id);
//        return user;
//    }

    @Value("${my.fullName}")
    private String name;

//    @Autowired
//    private RedisTemplate redisTemplate;

//    @Autowired
//    private JedisResourcePool jedisResourcePool;


    @RequestMapping("/")
    public String index(){
//        redisTemplate.opsForValue().set("Fox","SB");
//        Jedis jedis = jedisResourcePool.getJedis();
//        jedis.set("Fox","SB");
//        jedisResourcePool.returnResource(jedis);
//        System.out.println("pool use end");
        return "我的名字是:"+name;
    }

}
