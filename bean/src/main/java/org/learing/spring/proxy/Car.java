package org.learing.spring.proxy;

public class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Moving.....");
    }
}
