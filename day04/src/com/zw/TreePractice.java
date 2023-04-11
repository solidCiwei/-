package com.zw;

import java.util.*;

/**
 * <p> TreePractice </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/10 21:31
 */
public class TreePractice {

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = queue.poll();
            if (pre.left != null) queue.add(pre.left);
            if (pre.right != null) queue.add(pre.right);
            for (int i = 1; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                pre.next = node;
                pre = pre.next;
            }

        }
        return root;
    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int length = Math.max(left, right) + 1;
        return length;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    /**
     * 翻转二叉树
     * 无法使用中序遍历，树节点交换两次
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        swapNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void swapNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 对称二叉树-遍历法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    /**
     * 递归
     *
     * @param left
     * @param right
     * @return
     */
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;
        boolean l = compare(left.left, right.right);
        boolean r = compare(left.right, right.left);
        return l && r;
    }

    /**
     * 二叉树展开为链表
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> result = new ArrayList<>();
        preTree(root, result);
        if (result.size() <= 1) return;
        TreeNode pre = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            pre.right = result.get(i);
            pre.left = null;
            pre = pre.right;
        }
    }

    public void preTree(TreeNode root, List<TreeNode> result) {
        if (root == null) return;
        result.add(root);
        preTree(root.left, result);
        preTree(root.right, result);
    }

    int ans;

    /**
     * 二叉树的直径
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    /**
     * 环形链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 根据前序与中序构建二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 构建树方法
     *
     * @param preorder
     * @param pBegin
     * @param pEnd
     * @param inorder
     * @param iBegin
     * @param iEnd
     * @return
     */
    public TreeNode build(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd) {
        if (pBegin >= pEnd || iBegin >= iEnd) {
            return null;
        }
        //拆分前序遍历第一个节点获取中间节点
        int center = preorder[pBegin];
        //获取中间节点处于中序中的位置
        Integer index = map.get(center);
        TreeNode root = new TreeNode(center);
        //计算中序中左右节点个数用于拆分
        int leftCount = index - iBegin;
        //左节点
        root.left = build(preorder, pBegin + 1, pBegin + leftCount + 1, inorder, iBegin, center);
        //右节点
        root.right = build(preorder, pBegin + leftCount + 1, pEnd, inorder, center+1, iEnd);
        return root;
    }
}
