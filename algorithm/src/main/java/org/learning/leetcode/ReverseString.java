package org.learning.leetcode;

public class ReverseString {
    public static void main(String[] args) {
        char[] str = new char[]{'h', 'e', 'l', 'l', 'l', 'o'};
        reverseString(str);
        System.out.println("");

    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }


}
