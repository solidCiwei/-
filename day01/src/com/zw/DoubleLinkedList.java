package com.zw;

import java.util.List;

/**
 * <p> DoubleLinkedList </p >
 * 双端列表
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 14:51
 */
public class DoubleLinkedList {

    /**
     * 链表长度
     */
    int size;

    /**
     * 头节点
     */
    DoubleListNode head;

    /**
     * 尾节点
     */
    DoubleListNode tail;

    public DoubleLinkedList() {
        head = new DoubleListNode(0);
        tail = new DoubleListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 头部添加节点
     */
    public void addAtHead(int val) {
        addOfIndex(0, val);
    }

    /**
     * 尾部添加节点
     */
    public void addAtTail(int val) {
        addOfIndex(size, val);
    }

    /**
     * 指定下标的节点添加元素
     *
     * @param index
     */
    public void addOfIndex(int index, int val) {
        //处理下标超出异常
        if (index > size) throw new IndexOutOfBoundsException("-1");
        //当下标小于等于0时从头出发
        if (index < 0) index = 0;
        DoubleListNode cur = head;
        //判断下标位置分别从头尾出发遍历
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size; i >= index; i--) {
                cur = cur.pre;
            }
        }
        DoubleListNode addNode = new DoubleListNode(val);
        //新节点后指针指向前置节点的后一个节点
        addNode.next = cur.next;
        //新节点前指针指向前置节点
        addNode.pre = cur;
        //修改新节点的后置节点的前指针
        cur.next.pre = addNode;
        //修改新节点前置节点的指针
        cur.next = addNode;
        size++;
    }

    /**
     * 根据下标获取值
     *
     * @param index 下标
     * @return
     */
    public int getOfIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("-1");
        DoubleListNode cur = head;
        //判断下标位置分别从头尾出发遍历
        if (index <= size / 2) {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.next.val;
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    /**
     * 根据下标删除节点值
     *
     * @param index
     */
    public void deleteOfIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("-1");
        if (size == 0) throw new RuntimeException("empty linked list");
        DoubleListNode cur = head;
        if (index <= size / 2) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i < size - index+1; i++) {
                cur = cur.pre;
            }
        }
        cur.next.next.pre = cur;
        cur.next = cur.next.next;
        size--;
    }
}
