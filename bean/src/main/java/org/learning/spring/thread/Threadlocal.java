package org.learning.spring.thread;

public class Threadlocal {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal<String> threadLocal = new ThreadLocal<>();
                threadLocal.set("This is thread local variable");
                System.out.print(threadLocal.get());
            }
        }).start();
    }
}
