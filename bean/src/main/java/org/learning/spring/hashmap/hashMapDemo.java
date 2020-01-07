package org.learning.spring.hashmap;

import java.util.HashMap;

/**
 * https://tech.meituan.com/java_hashmap.html
 */
public class hashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> param = new HashMap<>(9);
        param.put(1, null);
        param.put(2, null);
        param.put(null, 3);
        param.forEach((name, value) -> System.out.println(name + "->" + value));
    }
}
