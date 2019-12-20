package org.learning.spring.exception.oom;

public class StackOverFlowDemo {
    public static void main(String[] args) {
        stackOverFlow();
    }

    private static void stackOverFlow() {
        stackOverFlow();
    }
}
