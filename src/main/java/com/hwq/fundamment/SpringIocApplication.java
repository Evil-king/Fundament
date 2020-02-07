package com.hwq.fundamment;

import com.hwq.fundamment.springioc.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: Administrator
 * @Date: 2020/2/6 0006 10:48
 * @Description:
 */
public class SpringIocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
