package org.learning.spring.thread;

/**
 * http://www.51gjie.com/java/732.html
 */

public class SleepTest implements Runnable {

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

    public static void main(String[] args) {
        Runnable r = new SleepTest();
        Thread t1 = new Thread(r, "t1_name");
        Thread t2 = new Thread(r, "t2_name");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
