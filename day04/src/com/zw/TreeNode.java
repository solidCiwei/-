package com.zw;

/**
 * <p> TreeNode </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/10 21:48
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
