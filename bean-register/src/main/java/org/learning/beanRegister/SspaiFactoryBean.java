package org.learning.beanRegister;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

@Setter
public class SspaiFactoryBean implements FactoryBean<Object> {

    String url;

    Class<?> type;

    public SspaiFactoryBean() {
    }

    @Override
    public Object getObject() {
        SspaiHandler sspaiHandler = new SspaiHandler(url, type);
        return Proxy.newProxyInstance(SspaiFactoryBean.class.getClassLoader(), new Class[]{type}, sspaiHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return SspaiService.class;
    }


}
