package org.learning.spring.exception.oom;

public class CannotCreateNewNativeThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread" + i
            ).start();
        }
    }
}
