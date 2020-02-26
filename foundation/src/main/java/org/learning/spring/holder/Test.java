package org.learning.spring.holder;

import javax.xml.ws.Holder;

public class Test {
    public static void main(String[] args) {
        Integer a = new Integer(12233456);
        chang(a);
        System.out.println("fianl:" + a + "," + a.hashCode());
        System.out.println("--------------------");


        Integer b = new Integer(1);
        Holder<Integer> c = new Holder<>(b);
        chang2(c);
        System.out.println("final:" + c.value);
    }

    private static void chang(Integer aa) {
        System.out.println("before:" + aa);
        aa = new Integer(12345678);
        System.out.println("after:" + aa + "," + aa.hashCode());
    }

    private static void chang2(Holder<Integer> bb) {
        System.out.println("before:" + bb.value);
        bb.value = 10;
        System.out.println("after:" + bb.value);
    }


}
