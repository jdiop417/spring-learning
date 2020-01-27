package org.learning.spring.concrruent;

public class YieldTest implements Runnable {
    public void run() {
        for (int k = 0; k < 10; k++) {
            if (k == 5 && Thread.currentThread().getName().equals("t1")) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + " : " + k);
        }
    }

    public static void main(String[] args) {
        Runnable r = new YieldTest();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
