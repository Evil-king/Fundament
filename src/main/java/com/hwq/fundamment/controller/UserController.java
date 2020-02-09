package com.hwq.fundamment.controller;

import com.hwq.fundamment.pojo.User;
import com.hwq.fundamment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/")
    public String index(){
        return "我的名字是:"+name;
    }

}
