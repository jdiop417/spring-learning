package org.learning.spring.exception.oom;

/**
 * -Xms1m  -Xmx1m
 */
public class JavaHeapSpeaceDemo {
    public static void main(String[] args) {
        while (true) {
            byte[] bytes = new byte[80 * 1024 * 1024];
        }
    }
}
