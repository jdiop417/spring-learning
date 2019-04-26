package org.learing.spring.singleton;

public class LazyInitializationHolderSingleton {

    private static class instanceHolder {
        private static final LazyInitializationHolderSingleton INSTANCE = new LazyInitializationHolderSingleton();
    }

    private LazyInitializationHolderSingleton() {
    }

    public static LazyInitializationHolderSingleton getInstance() {
        return instanceHolder.INSTANCE;
    }

}
