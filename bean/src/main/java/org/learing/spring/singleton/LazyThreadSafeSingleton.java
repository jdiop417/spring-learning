package org.learing.spring.singleton;

public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton INSTANCE = null;

    private LazyThreadSafeSingleton() {

    }

    public synchronized LazyThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyThreadSafeSingleton();
        }
        return INSTANCE;
    }
}
