package org.learning.spring.thread.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(2, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3), new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 0; i < 20; i++) {
                myExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myExecutor != null) {
                myExecutor.shutdown();
            }
        }

    }
}
