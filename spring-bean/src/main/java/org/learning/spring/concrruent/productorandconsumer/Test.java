package org.learning.spring.concrruent.productorandconsumer;

public class Test {
    /**
     * 测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor, "生产者A").start();
        new Thread(consumer, "消费者者B").start();

        new Thread(productor, "生产者C").start();
        new Thread(consumer, "消费者者D").start();

    }
}
