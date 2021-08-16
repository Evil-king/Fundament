package com.hwq.fundament.springioc.postprocessors;

import com.hwq.fundament.springioc.Example;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2020/2/7 0007 11:51
 * @Description:
 */
@Component
public class MyPostProcessors implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition)beanFactory.getBeanDefinition("fox");
        genericBeanDefinition.setBeanClass(Example.class);
    }
}
