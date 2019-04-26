package org.learing.spring.singleton;

public enum SingletonEnum {
    INSTANCE;

    private SingletonEnum getInstance() {
        return SingletonEnum.INSTANCE;
    }

    private void doSomething() {

    }
}
