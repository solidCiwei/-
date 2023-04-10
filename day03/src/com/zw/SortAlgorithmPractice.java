package com.zw;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p> SortAlgorithmPractice </p >
 * 排序算法
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/9 16:01
 */
public class SortAlgorithmPractice {


    @Test
    public void test01() {
        int[] arr = {3, 1, 2, 5, 6, 4};
//        bubbleSort(arr);
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        insertSort(arr);
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 时间复杂度O(n^2) 最佳时间复杂度O(n) 最坏时间复杂度O(n^2)
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 插入排序
     */
    public void insertSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * 不安全的排序
     *
     * @param arr 数组
     */
    public void selectSort(int[] arr) {
        if (arr.length <= 1) return;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 二叉树前序遍历-递归版
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        preorderTree(root, result);
        return result;
    }

    public void preorderTree(TreeNode root, List<Integer> result) {
        if (root == null) return;
        //中间节点
        result.add(root.val);
        preorderTree(root.left, result);
        preorderTree(root.right, result);
    }

    /**
     * 二叉树后序遍历-递归版
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        postorderTree(root, result);
        return result;
    }

    public void postorderTree(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderTree(root.left, result);
        postorderTree(root.right, result);
        result.add(root.val);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        inorderTree(root, result);
        return result;
    }

    public void inorderTree(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTree(root.left, result);
        result.add(root.val);
        inorderTree(root.right, result);
    }

    /**
     * 前序遍历-遍历法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    /**
     * 中序遍历-遍历法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                TreeNode top = stack.pop();
                if (top.right != null) stack.push(top.right);
                stack.push(top);
                stack.push(null);
                if (top.left != null) stack.push(top.left);
            } else {
                stack.pop();
                TreeNode n = stack.pop();
                result.add(n.val);
            }
        }
        return result;
    }

    /**
     * 前序遍历-标记遍历法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                TreeNode r = stack.pop();
                result.add(r.val);
            }
        }
        return result;
    }

    /**
     * 后序遍历法-标记遍历法
     *
     * @param root
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top != null) {
                stack.pop();
                stack.push(top);
                stack.push(null);
                if (top.right != null) stack.push(top.right);
                if (top.left != null) stack.push(top.left);
            } else {
                stack.pop();
                TreeNode r = stack.pop();
                result.add(r.val);
            }
        }
        return result;
    }
}
