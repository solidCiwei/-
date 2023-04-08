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
        head = new StackNode("");
        this.capacity = 10;
        this.size = 0;
    }

    public void push(String val) {
        if (size == capacity) return;
        StackNode node = new StackNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public String pop() {
        if (head.next == null) {
            throw new RuntimeException("error! is empty stack");
        }
        //获取头节点值
        String r = head.next.val;
        //删除顶部节点
        head.next = head.next.next;
        return r;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public String peek() {
        if (head.next == null) {
            throw new RuntimeException("error! is empty stack");
        }
        return head.next.val;
    }

    /**
     * 清空操作
     */
    public void clear() {
        this.head.next = null;
        size = 0;
    }
}
