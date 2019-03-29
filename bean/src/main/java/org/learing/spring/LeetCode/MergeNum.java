package org.learing.spring.LeetCode;

public class MergeNum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int index = m + n - 1;
        m--;
        n--;
        for (int i = m > n ? m : n; i >= 0; i--) {
            while (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[index--] = nums1[m--];
                    continue;
                }
                nums1[index--] = nums2[n--];
            }
            if (n >= 0) {
                for (int j = 0; j <= n; j++) {
                    nums1[j] = nums2[j];
                }
            }
        }
    }
}
