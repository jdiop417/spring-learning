package org.learning.foundation.concrruent;

public class SleepTest implements Runnable {
    public static void main(String[] args) {
        Runnable r = new SleepTest();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int k = 0; k < 5; k++) {
            if (k == 2) {
                try {
                    Thread.currentThread().sleep(5000);
                } catch (Exception e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + k);
        }
    }
}
