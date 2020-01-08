package org.learning.leetcode;


import org.junit.Test;

public class IsPowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {

            return (n & n - 1) == 0;
        } else {
            return (n & n - 1) != 0;
        }

    }

    @Test
    public void test() {
        boolean powerOfTwo = isPowerOfTwo(-1);
        System.out.println(powerOfTwo);
    }

}
