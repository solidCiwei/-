package com.zw;

/**
 * <p> Test </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/22 15:58
 */
public class Test {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println("lruCache.get(4) = " + lruCache.get(4));    // 返回 -1 (未找到)
        System.out.println("lruCache.get(3) = " + lruCache.get(3));    // 返回 -1 (未找到)
        System.out.println("lruCache.get(2) = " + lruCache.get(2));    // 返回 -1 (未找到)
        System.out.println("lruCache.get(1) = " + lruCache.get(1));    // 返回 -1 (未找到)
        lruCache.put(5,5);
        System.out.println("lruCache.get(1) = " + lruCache.get(1));
        System.out.println("lruCache.get(2) = " + lruCache.get(2));
        System.out.println("lruCache.get(3) = " + lruCache.get(3));
        System.out.println("lruCache.get(4) = " + lruCache.get(4));
        System.out.println("lruCache.get(5) = " + lruCache.get(5));
//        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println("lruCache.get(1) = " + lruCache.get(1));    // 返回 -1 (未找到)
//        System.out.println("lruCache.get(3) = " + lruCache.get(3));    // 返回 3
//        System.out.println("lruCache.get(4) = " + lruCache.get(4));    // 返回 4
    }
}
