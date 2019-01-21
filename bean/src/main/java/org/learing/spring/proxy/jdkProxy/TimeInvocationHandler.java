package org.learing.spring.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

    private Object target;

    public TimeInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long beginTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("The move time:" + (endTime - beginTime));
        return null;
    }
}
