package org.learing.spring.hashmap;

import java.util.HashMap;

public class hashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> param = new HashMap<>();
        param.put(1, 1);
        param.put(1, 2);
        System.out.println(param.get(1));
    }
}
