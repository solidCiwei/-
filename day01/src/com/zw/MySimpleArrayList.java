package com.zw;

/**
 * <p> MyArrayList </p >
 * 一个简易的数组，支持扩容
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 17:37
 */
public class MySimpleArrayList {

    /**
     * 数组长度
     */
    int length;

    /**
     * 数组中的元素
     */
    int[] obj = {};

    /**
     * 数组中的元素个数
     */
    int size;

    public MySimpleArrayList() {

    }

    public MySimpleArrayList(int size) {
        this.obj = new int[size];
        this.length = size;
    }

    /**
     * 访问索引并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("-1");
        }
        return obj[index];
    }

    /**
     * 数组中添加元素
     *
     * @param index
     */
    public boolean add(int index, int val) {
        if (length == size) throw new RuntimeException("数组已满");
        if (index < 0) throw new IndexOutOfBoundsException("-1");
        for (int i = size; i > index; i--) {
            obj[i] = obj[i - 1];
        }
        obj[index] = val;
        size++;
        return true;
    }

    /**
     * 删除指定下标元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("-1");
        }
        //删除元素移动位置
        for (int i = index + 1; i < size; i++) {
            obj[i - 1] = obj[i];
        }
        size--;
        return false;
    }

}
