package org.learing.spring.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int[] B = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                B[j] = A[j];
            }
            result.add(PrefixesDiv(B));
        }
        return result;
    }

    public boolean PrefixesDiv(int[] A) {
        List<Integer> ou = new ArrayList<>();
        List<Integer> qi = new ArrayList<>();
        boolean flag = false;
        for (int len = A.length - 1; len >= 0; len--) {
            if (!flag) {
                qi.add(A[len]);
            } else {
                ou.add(A[len]);
            }

            flag = reveseFlag(flag);
        }
        int ouSum = 0;
        flag = true;
        for (int i = ou.size() - 1; i >= 0; i--) {
            if (flag) {
                ouSum += ou.get(i);
            } else {
                ouSum -= ou.get(i);
            }
            flag = reveseFlag(flag);
        }
        int qiSum = 0;
        flag = true;
        for (int i = qi.size() - 1; i >= 0; i--) {
            if (flag) {
                qiSum += qi.get(i);
            } else {
                qiSum -= qi.get(i);
            }
            flag = reveseFlag(flag);
        }

        return (qiSum * 2 + ouSum) % 5 == 0;
    }

    public boolean reveseFlag(boolean flag) {
        if (flag == true) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        Boolean booleans = PrefixesDiv(new int[]{1, 1, 0, 0, 0, 1});
        System.out.println("pause");
    }
}
