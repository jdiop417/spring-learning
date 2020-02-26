package org.learning.foundation.concrruent.productorandconsumer;

/**
 * 员工
 */
public class Clerk {

    private static final int MAX_PRODUCT_NUM = 1;

    private int product = 0;

    // 买
    public synchronized void get() throws InterruptedException {
        while (product >= MAX_PRODUCT_NUM) {
            System.out.println("产品已满！");
            this.wait();
        }
        System.out.println("产品数量：" + ++product);
        this.notifyAll();
    }

    //卖
    public synchronized void sale() throws InterruptedException {
        while (product <= 0) {
            System.out.println("产品缺货！");
            this.wait();
        }
        System.out.println("产品数量：" + --product);
        this.notifyAll();
    }
}
