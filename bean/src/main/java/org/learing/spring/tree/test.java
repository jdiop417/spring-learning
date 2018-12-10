package org.learing.spring.tree;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.right = treeNode6;

        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;

        preorderTraversal(treeNode1);
        System.out.println("用二叉树的前序遍历表示一个虚链表（二叉树的left表示链表的next）");
        TreeNode node = treeNode1;
        while (node != null) {
            System.out.println(node.val);
            node = node.left;
        }
    }


    public static void preorderTraversal(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = rootNode;
        TreeNode tmp = rootNode;//最后一个访问的左节点
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.val);
                stack.push(node);
                tmp = node;
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                tmp.left = node.right;
                node = node.right;

            }
        }
    }
}
