package org.learning.foundation.exception.oom;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * -Xmx10M -Xms10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        int i = 0;
        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Exception e) {
            System.out.println("*********** i=" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
