package com.hwq.fundamment.service;

import com.hwq.fundamment.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2020/2/5 0005 10:14
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public User login(int id) {
        User user = new User().setId(1).setUsername("胡文卿");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
