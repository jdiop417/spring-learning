package org.learning.designPattern.proxy.jdkProxy;

public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Moving.....");
    }
}
