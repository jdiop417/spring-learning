package org.learing.spring.proxy.jdkProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Class<? extends Car> cls = car.getClass();
        Moveable moveInstance = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), new TimeInvocationHandler(car));
        moveInstance.move();
    }
}
