package com.hwq.fundamment.springaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2020/2/5 0005 10:30
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AspectUser {

    @Pointcut("execution(* com.hwq.fundamment.service.*.*(..))")
    public void piontCut() {
    }

    @Before("com.hwq.fundamment.springaop.AspectUser.piontCut()")
    public void before() {
        System.out.println("Before");
    }

    @After("com.hwq.fundamment.springaop.AspectUser.piontCut()")
    public void after() {
        System.out.println("After");
    }

    @Around("com.hwq.fundamment.springaop.AspectUser.piontCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("消耗时间:={}", (end - start));
        return proceed;
    }
}
