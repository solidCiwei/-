package com.zw;

import java.util.Stack;

/**
 * <p> SimpleLinkedStack </p >
 * 一个简单的链式栈
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 10:22
 */
public class SimpleLinkedStack {

    /**
     * 虚拟头节点
     */
    StackNode head;

    /**
     * 容量
     */
    int capacity;

    /**
     * 栈元素个数
     */
    int size;

    public SimpleLinkedStack() {
        head = new StackNode(0);
        this.capacity = 10;
        this.size = 0;
    }

    public void push(int val) {
        if (size==capacity) return;
        StackNode node = new StackNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public int pop(){
        if (head.next==null)return -1;
        //获取头节点值
        int r = head.next.val;
        //删除顶部节点
        head.next = head.next.next;
        return r;
    }

    public boolean isEmpty(){
        return head.next==null;
    }

    public int peek(){
        if (head.next==null) return -1;
        return head.next.val;
    }
}
