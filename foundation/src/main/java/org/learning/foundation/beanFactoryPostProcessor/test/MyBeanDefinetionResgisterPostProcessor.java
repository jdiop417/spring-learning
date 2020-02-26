package org.learning.foundation.beanFactoryPostProcessor.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinetionResgisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinetionResgisterPostProcessor....postProcessBeanDefinitionRegistry中bean的数量：" + registry.getBeanDefinitionCount());
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("MyBeanDefinetionResgisterPostProcessor....postProcessBeanFactory：" + beanFactory.getBeanDefinitionCount());


    }
}
