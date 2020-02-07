package com.hwq.fundamment;

import com.hwq.fundamment.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: Administrator
 * @Date: 2020/2/5 0005 10:47
 * @Description:
 */
@EnableAspectJAutoProxy
@ComponentScan("com.hwq.fundamment.*")
public class SpringAopApplication {
    public static void main(String[] args) {
        //走接口的形式 获取的则是jdk的动态代理
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringApplication.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        userService.login(1);

        //不走接口的形式 则是获取的CJLB的动态代理
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringApplication.class);
//        UserServiceImpl userService = (UserServiceImpl)annotationConfigApplicationContext.getBean("userService");
//        userService.login(1);
    }
}
