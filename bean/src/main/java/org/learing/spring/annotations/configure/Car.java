package org.learing.spring.annotations.configure;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    public Car() {
        System.out.println("car....constronct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("car....destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car....init");
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
