package org.learning.foundation.thread.holdlock;


public class HoldLockDemo implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public static void main(String[] args) {
        String lockA = "a";
        String lockB = "b";
        new Thread(new HoldLockDemo(lockA, lockB)).start();
        new Thread(new HoldLockDemo(lockB, lockA)).start();
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("已获取锁" + lockA + "，尝试获取锁" + lockB);
            synchronized (lockB) {
                System.out.println("已获取锁" + lockB + "，尝试获取锁" + lockA);
            }
        }
    }
}
