package com.hwq.fundament;

import com.hwq.fundament.springioc.AppConfig;
import com.hwq.fundament.springioc.Example;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: Administrator
 * @Date: 2020/2/6 0006 10:48
 * @Description:
 */
public class SpringIocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Example bean = applicationContext.getBean(Example.class);
        System.out.println(bean);
    }
}
