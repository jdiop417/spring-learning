package org.learning.nowcoder;

import java.util.Scanner;

public class LenOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(lenOfLastWord(s));
        }
    }

    public static int lenOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String trim = ' ' + s.trim();
        int lastBlankIndex = 0;
        char[] chars = trim.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                lastBlankIndex = i;
            }
        }

        int length = trim.substring(lastBlankIndex + 1).length();
        return length;
    }
}
