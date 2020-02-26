package org.learning.foundation.singleton;

public enum SingletonEnum {
    INSTANCE;

    private SingletonEnum getInstance() {
        return SingletonEnum.INSTANCE;
    }

    private void doSomething() {

    }
}
