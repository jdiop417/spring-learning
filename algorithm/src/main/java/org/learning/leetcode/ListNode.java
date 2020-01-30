package org.learning.leetcode;


import org.springframework.util.StringUtils;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static ListNode parseFromStr(String str) {
        ListNode result = null;
        if (StringUtils.isEmpty(str)) {
            return result;
        }

        ListNode lastNode = null;
        for (int i = 0, len = str.length(); i < len; i++) {
            int num = str.charAt(i) - '0';
            if (lastNode == null) {
                result = new ListNode(num);
                lastNode = result;
                continue;
            }
            ListNode curNode = new ListNode(num);
            lastNode.next = curNode;
            lastNode = curNode;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = parseFromStr("423");
        System.out.println(listNode.toString());

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if (this == null) {
            return sb.toString();
        }

        ListNode node = this;
        while (node != null) {
            sb.append(node.val + (node.next == null ? "" : "->"));
            node = node.next;
        }
        return sb.toString();
    }

}
