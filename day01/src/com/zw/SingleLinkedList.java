package com.zw;

/**
 * <p> SingleLinkedList </p >
 * 单链表实现
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 11:28
 */
public class SingleLinkedList {
    //链表长度
    int size;
    //链表虚拟头节点
    ListNode head;

    public SingleLinkedList() {
        this.head = new ListNode(0);
        size = 0;
    }

    /**
     * 链表头节点添加元素
     *
     * @param val
     */
    public void addAtHead(int val) {
        add(0, val);
    }

    /**
     * 链表尾部添加节点
     *
     * @param val
     */
    public void addAtTail(int val) {
        add(size, val);
    }

    /**
     * 指定下标的元素后添加元素
     * 时间复杂度分析： 最佳情况插入头时间，复杂度为O(1)，最坏情况插入尾部，复杂度为O(n)
     *
     * @param index
     * @param val
     */
    public void add(int index, int val) {
        //下标超过数组长度执行结束
        if (index > size) return;
        //当下标小于等于0时将节点作为头节点
        if (index < 0) index = 0;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = cur.next;
        cur.next = addNode;
        size++;
    }

    /**
     * 删除指定下标节点元素
     * 时间复杂度分析，最佳情况删除头为O(1)，最坏情况删除尾为O(n)
     *
     * @param index
     */
    public void delete(int index) {
        //如果下标超过链表长度则直接返回
        if (index > size || index < 0) return;
        //链表中无元素时删除直接返回
        if (size == 0) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    /**
     * 返回指定下标节点值
     * 查头O(1)查尾O(n)
     *
     * @param index
     * @return
     */
    public int get(int index) {
        //当下标不在链表范围内返回-1
        if (index >= size || index < 0) return -1;
        ListNode cur = head;
        //为什么是等于？
        //因为有虚拟节点存在，所以不加等于获取的其实是前驱节点
        //例如下标为0时，如果没有等于情况获取的则是虚拟节点因此需要加上等于
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}
