package org.learing.spring.LeetCode;

import org.junit.Test;

public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];
        if (lists.length == 1) {
            return result;
        }
        for (int i = 1; i < lists.length; i++) {
            result= mergeTwoLists(result, lists[i]);
        }
        return result;

    }


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
        ListNode l1 = null;
        ListNode l2 = ListNode.parseFromStr("1");
        ListNode[] lists = new ListNode[]{l1, l2};
        l1 = mergeKLists(lists);
        System.out.println(l1.toString());
    }

}
