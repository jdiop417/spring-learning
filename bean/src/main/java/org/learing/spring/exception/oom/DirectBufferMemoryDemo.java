package org.learing.spring.exception.oom;

import java.nio.ByteBuffer;

/**
 * -Xmx10M -Xms10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirtMemory:" + sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024 + "M");
        ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
