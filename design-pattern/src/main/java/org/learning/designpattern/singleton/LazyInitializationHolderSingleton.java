package org.learning.designpattern.singleton;

public class LazyInitializationHolderSingleton {

    private LazyInitializationHolderSingleton() {
    }

    public static LazyInitializationHolderSingleton getInstance() {
        return instanceHolder.INSTANCE;
    }

    private static class instanceHolder {
        private static final LazyInitializationHolderSingleton INSTANCE = new LazyInitializationHolderSingleton();
    }

}
