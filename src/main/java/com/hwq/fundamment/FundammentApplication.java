package com.hwq.fundamment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FundammentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundammentApplication.class, args);
    }
}
