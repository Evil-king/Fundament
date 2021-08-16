package com.hwq.fundament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.hwq.fundament.*")
@EnableAspectJAutoProxy
@EnableScheduling
public class FundammentApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FundammentApplication.class, args);
        SpringApplication springApplication = new SpringApplication(FundammentApplication.class);
        springApplication.run(args);

//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FundammentApplication.class, args);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            System.out.println(" bean名称：" + beanDefinitionNames[i]);
//        }

        /**
         * @SpringBootApplication 包装了 @SpringBootConfiguration-->（包含了 @Configuration） @EnableAutoConfiguration
         * 加载我们第三方的配置的启动
         *
         */

        /**
         * List<String> configurations = getCandidateConfigurations(annotationMetadata,
         * 				attributes);
         * 	获取当前spring.factories文件
         *
         * 	org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration,\
         *  org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration,\
         */

        /**
         * EventPublishingRunListener 给我们配置文件赋值
         */

        /**
         * SpringApplication.run(FundammentApplication.class, args); 这段代码可以分解为 new SpringApplication(primarySources).run(args);
         * 1、创建new SpringApplication
         * SpringApplication springApplication = new SpringApplication(FundammentApplication.class);
         * 2、调用run方法
         * springApplication.run();
         *
         * ClassUtils.isPresent(WEBFLUX_INDICATOR_CLASS, null)判断是不是响应式环境 并且不是jersey和servlet环境
         * static WebApplicationType deduceFromClasspath() {
         * 		if (ClassUtils.isPresent(WEBFLUX_INDICATOR_CLASS, null)
         * 				&& !ClassUtils.isPresent(WEBMVC_INDICATOR_CLASS, null)
         * 				&& !ClassUtils.isPresent(JERSEY_INDICATOR_CLASS, null)) {
         * 			return WebApplicationType.REACTIVE;
         *                }
         * 		for (String className : SERVLET_INDICATOR_CLASSES) {
         * 			if (!ClassUtils.isPresent(className, null)) {
         * 				return WebApplicationType.NONE;
         *            }
         *        }
         * 		return WebApplicationType.SERVLET;* 	}
         *
         *
         * 	WebApplicationType这个枚举类中定义了三个
         * 	NONE 不会嵌入我们的web服务器 最终通过外部tomcat服务器启动，
         * 	SERVLET 需要使用servlet服务器运行，
         * 	REACTIVE 使用响应式web启动
         *
         */
    }
}
