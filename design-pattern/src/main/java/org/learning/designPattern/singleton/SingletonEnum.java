package org.learning.designPattern.singleton;

public enum SingletonEnum {
    INSTANCE;

    private SingletonEnum getInstance() {
        return SingletonEnum.INSTANCE;
    }

    private void doSomething() {

    }
}
