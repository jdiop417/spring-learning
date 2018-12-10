package org.learing.spring.tree;

import lombok.Data;

@Data
public class TreeNode {
    public int val;

    //左子树
    public TreeNode left;

    //右子树
    public TreeNode right;

    //构造方法
    public TreeNode(int x) {
        val = x;
    }
}
