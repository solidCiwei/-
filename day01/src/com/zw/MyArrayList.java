package com.zw;

/**
 * <p> MyArrayList </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 19:06
 */
public class MyArrayList<T> {

    /**
     * 数组内容
     */
    T[] t;

    /**
     * 元素个数
     */
    int size;

    /**
     * 默认数组大小
     */
    private final int DEFAULT_SIZE = 10;

    private final Integer MAX_SIZE = Integer.MAX_VALUE - 1;

    /**
     * 有参数构造方法，可初始化数组大小
     *
     * @param capacity
     */
    public MyArrayList(int capacity) {
        t = (T[]) new Object[capacity];
        size = capacity;
    }

    /**
     * 无参构造方法指定初始化大小
     */
    public MyArrayList() {
        t = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * 数组指定下标添加元素方法
     *
     * @param index
     * @param val
     * @return
     */
    public boolean add(int index, T val) {
        checkIndex(index);
        //判断是否需要扩容
        if (size == t.length) {
            //进行数组扩容
            resize(size * 2);
        }
        //移动数组元素
        for (int i = size; i > index; i--) {
            t[i] = t[i - 1];
        }
        t[index] = val;
        size++;
        return true;
    }

    /**
     * 删除指定下标元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndexForRemove(index);
        T del = get(index);
        for (int i = index + 1; i < size; i++) {
            t[i - 1] = t[i];
        }
        size--;
        t[size] = null;
        if (size == t.length / 4 && t.length / 2 != 0) {
            resize(t.length / 2);
        }
        return del;
    }

    /**
     * 删除数组中指定元素
     *
     * @param e
     * @return
     */
    public void remove(T e) {
        int index = get(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除末尾元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 获取指定下标元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return t[index];
    }

    /**
     * 设置指定下标元素
     *
     * @param index
     * @param e
     * @return
     */
    public boolean set(int index, T e) {
        checkIndex(index);
        t[index] = e;
        return true;
    }

    /**
     * 获取指定元素下标
     *
     * @param e
     * @return
     */
    public int get(T e) {
        for (int i = 0; i < size; i++) {
            if (t[i] == e) return i;
        }
        return -1;
    }

    /**
     * 获取数组元素个数
     *
     * @return
     */
    public int getCapacity() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    /**
     * 查看数组是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        if (get(e) != -1) return true;
        return false;
    }


    /**
     * 数组头部添加元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 数组尾部添加元素
     *
     * @param e
     */
    public void addTail(T e) {
        add(size, e);
    }

    private void resize(int rSize) {
        //设置数组长度上限
        rSize = rSize > MAX_SIZE ? MAX_SIZE : rSize;
        T[] copyArr = (T[]) new Object[rSize];

        for (int i = 0; i < t.length; i++) {
            copyArr[i] = t[i];
        }
        t = copyArr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("添加失败！下标越界！");
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("添加失败！下标越界！");
    }
}