package com.hwq.fundament.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @Auther: Administrator
 * @Date: 2020/2/9 0009 17:27
 * @Description: 按照EventPublishingRunListener 接口自定义并且实现SpringApplicationRunListener接口
 */

public class MyEventPublishingRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    @Override
    public void starting() {
        System.out.println(">>>>>>start<<<<<<<");
    }

    public MyEventPublishingRunListener(SpringApplication application, String[] args){
        this.application = application;
        this.args = args;
    }


    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        //配置文件读取到程序中，思路需要自己将本地文件读取到程序中，然后放入到SpringBoot容器中
        Properties properties = new Properties();
        try {
            //1、读取我们的my.properties文件
            properties.load(this.getClass().getClassLoader().getResourceAsStream("my.properties"));
            //2、读取名称为my
            PropertiesPropertySource propertySource = new PropertiesPropertySource("my",properties);
            //3、将资源添加到SpringBoot项目中
            MutablePropertySources propertySources = environment.getPropertySources();
            propertySources.addLast(propertySource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
