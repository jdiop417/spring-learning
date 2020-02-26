package org.learning.spring.thread.Interview;


public class Odd implements Runnable {

    private static int value = 0;

    public static void main(String[] args) {
        Runnable runnable = new Odd();
        Thread thread1 = new Thread(runnable, "t0");
        Thread thread2 = new Thread(runnable, "t1");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (value++));
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
