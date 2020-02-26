package org.learning.foundation.singleton;

public final class LazyThreadNotSafeSingleton {
    private static LazyThreadNotSafeSingleton INSTANCE = null;

    private LazyThreadNotSafeSingleton() {

    }

    public LazyThreadNotSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyThreadNotSafeSingleton();
        }
        return INSTANCE;
    }
}
