package com.zw;

/**
 * <p> Test01 </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 09:08
 */
public class Test01 {

    public static void main(String[] args) {
        LRULinkedList<String> linkedList = new LRULinkedList<>();
        for (int i = 0; i < 20; i++) {
            linkedList.add("s" + i);
            linkedList.printAll();
        }
        linkedList.add("s10");
        linkedList.printAll();
        linkedList.add("s15");
        linkedList.printAll();

    }
}
