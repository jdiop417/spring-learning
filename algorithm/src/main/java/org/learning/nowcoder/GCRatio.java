package org.learning.nowcoder;


import java.util.Scanner;

/**
 * 题目：牛客网-华为面试题-DNA序列
 * <p>
 * 本题疑惑：
 * 要求：给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。那么子序列>=最小子序列长度
 * 测试案例：子序列固定
 * <p>
 * 牛客网这个坑货，在线自测的坑：
 * 1.类名必需为Main
 * 2.有main方法
 * 3.输入输出
 */
public class GCRatio {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //多个测试案例
        while (input.hasNext()) {
            //输入数据：一个输入参数就是一行
            String s = input.next();
            int len = input.nextInt();

            //输出结果
            System.out.println(gcRatio(s, len));
        }
    }

    public static String gcRatio(String s, int fixlen) {

        int maxCount = 0;
        int beginIndex = 0;
        for (int i = 0; i < s.length() - fixlen; i++) {

            int tmpCount = 0;
            String substr = s.substring(i, i + fixlen);
            for (int j = 0; j < substr.length(); j++) {
                char c = substr.charAt(j);
                if (c == 'C' || c == 'G') {
                    tmpCount++;
                }
            }

            if (tmpCount > maxCount) {
                maxCount = tmpCount;
                beginIndex = i;
            }

        }
        return s.substring(beginIndex, beginIndex + fixlen);
    }
}

