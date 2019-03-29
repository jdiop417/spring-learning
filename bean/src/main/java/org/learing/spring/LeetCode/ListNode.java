package org.learing.spring.LeetCode;


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

    public static String parseStr(ListNode node) {
        StringBuilder sb = new StringBuilder("");
        if (node == null) {
            return null;
        }
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }


}
