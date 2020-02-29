package org.learning.other;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 题目：有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一个方法，计算小孩有多少中上楼梯的方式。
 */
public class CountWays {

    public int count(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return count(n - 1) + count(n - 2) + count(n - 3);
        }
    }


    public int countDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > 0) {
            return map[n];
        } else {
            map[n] = countDP(n - 1, map) + countDP(n - 2, map) + countDP(n - 3, map);
            return map[n];
        }
    }

    @Test
    public void test() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        //递归
        System.out.println(count(20));
        System.out.println("cost:" + stopwatch.elapsed(TimeUnit.MICROSECONDS));

        //动态规划
        System.out.println(countDP(20, new int[21]));
        System.out.println("cost:" + stopwatch.elapsed(TimeUnit.MICROSECONDS));

    }
}
