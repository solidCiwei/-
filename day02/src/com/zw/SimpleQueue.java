package com.zw;

/**
 * <p> SimpleQueue </p >
 * 一个简单的双端队列，队列顶端维护最小值
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 16:34
 */
public class SimpleQueue {

    /**
     * 头节点
     */
    QueueNode head;

    /**
     * 尾节点
     */
    QueueNode tail;

    /**
     * 元素个数
     */
    int size;

    public SimpleQueue() {
        tail = new QueueNode(0);
        head = new QueueNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 队列中添加元素，如果小于队头元素则弹出直到大于队头元素或队列为空
     *
     * @param val
     */
    public void add(int val) {
        if (size != 0) {
            int top = peek();
            if (val < top) {
                //元素弹出队列
                while (!isEmpty()) {
                    int n = head.next.val;
                    //当找到小于值结束循环
                    if (n <= val) {
                        break;
                    }
                    remove();
                }
            }
        }
        QueueNode node = new QueueNode(val);
        //新节点前置设置
        node.pre = tail.pre;
        //新节点后置设置
        node.next = tail;
        //新节点前置节点与新节点关联
        tail.pre.next = node;
        //新节点后置节点与新节点关联
        tail.pre = node;
        size++;
    }

    /**
     * 移除队头最小元素
     */
    public void remove() {
        if (size == 0) return;
        head = head.next;
        size--;
    }

    public int peek() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("-1");
        return head.next.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    class QueueNode {
        int val;

        QueueNode pre;

        QueueNode next;

        public QueueNode(int val) {
            this.val = val;
        }
    }

}
