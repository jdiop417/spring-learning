package org.learning.foundation.proxy.jdkProxy;

public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Moving.....");
    }
}
