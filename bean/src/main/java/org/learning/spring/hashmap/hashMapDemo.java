package org.learning.spring.hashmap;

import java.util.HashMap;

/**
 * https://tech.meituan.com/java_hashmap.html
 */
public class hashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> param = new HashMap<>(9);
        param.put(1, 1);
        param.put(1, 2);
        System.out.println(param.get(1));
    }
}
