package com.zw;

/**
 * <p> SimpleStack </p >
 * 一个简单的基于数组的栈实现
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 09:56
 */
public class SimpleStack {

    /**
     * 栈默认大小
     */
    private final int DEFAULT_SIZE = 10;
    /**
     * 数组个数
     */
    private int[] obj;

    /**
     * 栈中元素个数
     */
    private int size;

    /**
     * 栈容量
     */
    private int capacity;

    public SimpleStack() {
        obj = new int[DEFAULT_SIZE];
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    public SimpleStack(int capacity) {
        obj = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void push(int val) {
        //判断栈容量
        if (size == capacity) {
            System.out.println("栈已满 = " + "栈已满");
            return;
        }
        obj[size] = val;
        size++;
    }

    /**
     * 弹出栈
     *
     * @return
     */
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int n = obj[size - 1];
        size--;
        return n;
    }

    public int peek() {
        if (size == 0) return -1;
        return obj[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
