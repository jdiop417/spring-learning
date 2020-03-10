package org.learning.designPattern.strategy;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞~~~");
    }
}
