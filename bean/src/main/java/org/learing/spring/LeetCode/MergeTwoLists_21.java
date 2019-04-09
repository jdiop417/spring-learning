package org.learing.spring.LeetCode;

import org.junit.Test;

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = l1;
        ListNode preNode = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preNode = l1;
                l1 = l1.next;
                continue;
            }

            ListNode tmp = l2;
            l2 = l2.next;
            tmp.next = l1;
            if (preNode == null) {
                l3 = tmp;
            } else {
                preNode.next = tmp;
            }
            preNode = tmp;
        }
        if (l1 == null) {
            preNode.next = l2;
        }
        return l3;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.parseFromStr("124");
        ListNode l2 = ListNode.parseFromStr("134");
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println("dd");

    }
}
