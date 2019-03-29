package org.learing.spring.LeetCode;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = getNodeListByValue(421L);
        ListNode l2 = getNodeListByValue(431L);
        ListNode l3 = mergeTwoLists(l1, l2);

        System.out.println("pause");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        int offset = 0;
        ListNode last = null;
        while (l1 != null || l2 != null || offset > 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;

            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += offset;
            int cur = sum >= 10 ? sum % 10 : sum;
            offset = sum / 10;
            ListNode tmpNode = new ListNode(cur);
            if (l3 == null) {
                l3 = tmpNode;
            } else {
                last.next = tmpNode;
            }
            last = tmpNode;

        }
        return l3;
    }


    public static ListNode getNodeListByValue(Long value) {
        if (value == 0) {
            return new ListNode(0);
        }

        ListNode lastListNode = null;
        ListNode curListNode = null;
        while (value != 0) {
            int nodeVal = value.intValue() % 10;
            value /= 10;
            ListNode tmpLinkNode = new ListNode(nodeVal);
            if (curListNode == null) {
                curListNode = tmpLinkNode;
            } else {
                lastListNode.next = tmpLinkNode;
            }
            lastListNode = tmpLinkNode;
        }
        return curListNode;
    }

    public static ListNode reveseListNode(ListNode l) {
        ListNode rl = null;
        while (l != null) {
            ListNode firstNode = new ListNode(l.val);
            if (rl == null) {
                rl = firstNode;
            } else {
                firstNode.next = rl;
            }
            l = l.next;
            rl = firstNode;
        }

        return rl;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode rl = null;
        while (head != null) {
            ListNode firstNode = new ListNode(head.val);
            if (rl == null) {
                rl = firstNode;
            } else {
                firstNode.next = rl;
            }
            head = head.next;
            rl = firstNode;
        }

        return rl;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

}
