package com.zw;

/**
 * <p> LRUListNode </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 21:16
 */
public class LRUListNode<T> {

    /**
     * 下一个节点
     */
    private LRUListNode<T> next;

    /**
     * 值
     */
    private T e;

    public LRUListNode(T e) {
        this.e = e;
    }

    public LRUListNode(T e, LRUListNode next) {
        this.e = e;
        this.next = next;
    }

    public LRUListNode getNext() {
        return next;
    }

    public void setNext(LRUListNode next) {
        this.next = next;
    }

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }

}
