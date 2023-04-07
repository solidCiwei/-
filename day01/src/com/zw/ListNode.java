package com.zw;

/**
 * <p> ListNode </p >
 * 单链表节点
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 11:05
 */
public class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }
}
