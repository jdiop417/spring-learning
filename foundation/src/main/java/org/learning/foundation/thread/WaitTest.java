package org.learning.foundation.thread;

/**
 * http://www.51gjie.com/java/732.html
 */
public class WaitTest implements Runnable {
    public static int shareVar = 0;

    public static void main(String[] args) {
        WaitTest r = new WaitTest();
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }

    @Override
    public synchronized void run() {
        if (shareVar == 0) {
            for (int i = 0; i < 10; i++) {
                if (shareVar++ == 5) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (shareVar != 0) {
            System.out.println(Thread.currentThread().getName() + " shareVar=" + shareVar);
            this.notify();
        }
    }


}
