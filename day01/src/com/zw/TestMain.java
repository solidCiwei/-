package com.zw;

/**
 * <p> TestMain </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 13:07
 */
public class TestMain {

    public static void main(String[] args) {
//        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.delete(0);
//        linkedList.addAtHead(1);
//        System.out.println("linkedList.size = " + linkedList.size);
//        System.out.println("linkedList.get(0) = " + linkedList.get(0));
//        linkedList.addAtTail(19);
//        System.out.println("linkedList.size = " + linkedList.size);
//        System.out.println("linkedList.get(2) = " + linkedList.get(1));
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addOfIndex(0,10);
//        doubleLinkedList.addOfIndex(1,20);
//        doubleLinkedList.addOfIndex(2,5);
//        doubleLinkedList.addOfIndex(3,1);
//        doubleLinkedList.addOfIndex(4,8);
//        System.out.println("doubleLinkedList.size = " + doubleLinkedList.size);
//        System.out.println("doubleLinkedList.getOfIndex(4) = " + doubleLinkedList.getOfIndex(4));
        doubleLinkedList.deleteOfIndex(0);
        System.out.println("doubleLinkedList.size = " + doubleLinkedList.size);

    }
}
