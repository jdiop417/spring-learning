package org.learning.spring.thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
        t1.join();
        System.out.println(String.format(" %s thread end\n", Thread.currentThread().getName()));

    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(String.format(" %s thread start\n", this.getName()));
            for (int i = 0; i < 1000000; i++) {

            }

            System.out.println(String.format(" %s thread end\n", this.getName()));

        }
    }

}
