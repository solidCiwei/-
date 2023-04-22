package com.zw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> LRUCache </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/22 15:29
 */
public class LRUCache {

    Node head;
    Node tail;

    Map<Integer, Node> cache;

    int capacity;

    int size;

    private class Node {
        int key;

        int value;

        Node next;

        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (size == 0 || !cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        //移动节点的前驱的下一个节点指向该节点的下一个节点
        node.pre.next = node.next;
        //移动节点的后置的前驱指向该节点的前置
        node.next.pre = node.pre;
        //修改节点的值
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        return node.value;
    }

    public void put(int key, int value) {
        //判断是否存在，不存在直接插入头
        if (!cache.containsKey(key)) {
            //去除尾部元素
            if (size == capacity) {
                //替换尾部元素并且移动
                cache.remove(tail.pre.key);
                Node tempN = tail.pre;
                tempN.key = key;
                tempN.value = value;
                cache.put(key,tempN);
                get(key);
            }else {
                Node temp = head.next;
                //放入头
                head.next = new Node(key, value);
                head.next.pre = head;
                head.next.next = temp;
                temp.pre = head.next;
                //放入缓存
                cache.put(key, head.next);
                size++;
            }
        } else {
            cache.get(key).value = value;
            get(key);
        }
    }

}
