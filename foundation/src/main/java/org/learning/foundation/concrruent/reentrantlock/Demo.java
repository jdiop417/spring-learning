package org.learning.foundation.concrruent.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程按顺序调用：实现A->B->C三个线程启动，A打印5次，B打印10次，C打印15次。A打印5次，B打印10次，C打印15次。。。。。持续10轮
 */
public class Demo {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private int num = 1; //信号量/标志位：1代表A线程，2代表B线程，3代码C线程

    private Condition condition1 = reentrantLock.newCondition();
    private Condition condition2 = reentrantLock.newCondition();
    private Condition condition3 = reentrantLock.newCondition();

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }

    public void print5() throws InterruptedException {
        reentrantLock.lock();
        while (num != 1) {
            condition1.await();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        num = 2;
        condition2.signal();
        reentrantLock.unlock();
    }

    public void print10() throws InterruptedException {
        reentrantLock.lock();
        while (num != 2) {
            condition2.await();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        num = 3;
        condition3.signal();
        reentrantLock.unlock();
    }

    public void print15() throws InterruptedException {
        reentrantLock.lock();
        while (num != 3) {
            condition3.await();
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        num = 1;
        condition1.signal();
        reentrantLock.unlock();
    }

}
