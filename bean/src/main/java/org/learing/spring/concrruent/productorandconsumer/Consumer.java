package org.learing.spring.concrruent.productorandconsumer;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                clerk.sale();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
