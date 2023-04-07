package com.zw;

import java.util.ArrayList;
import java.util.List;

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
//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addOfIndex(0,10);
//        doubleLinkedList.addOfIndex(1,20);
//        doubleLinkedList.addOfIndex(2,5);
//        doubleLinkedList.addOfIndex(3,1);
//        doubleLinkedList.addOfIndex(4,8);
//        System.out.println("doubleLinkedList.size = " + doubleLinkedList.size);
//        System.out.println("doubleLinkedList.getOfIndex(4) = " + doubleLinkedList.getOfIndex(4));
//        doubleLinkedList.deleteOfIndex(0);
//        System.out.println("doubleLinkedList.size = " + doubleLinkedList.size);
//        MySimpleArrayList arrayList = new MySimpleArrayList(10);
//        for (int i = 0; i < 10; i++) {
//            arrayList.add(i,10+i);
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println("arrayList.find(i) = " + arrayList.find(i));
//        }
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        System.out.println("arrayList.isEmpty() = " + arrayList.isEmpty());
        for (int i = 0; i < 15; i++) {
            arrayList.add(i, i + 10);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println("arrayList.get(i) = " + arrayList.get(i));
        }
        arrayList.remove(1);
        for (int i = 0; i < arrayList.size; i++) {
            System.out.println("arrayList.get(i) = " + arrayList.get(i));
        }
        System.out.println("arrayList.get(1) = " + arrayList.get(1));
        System.out.println("arrayList.getCapacity() = " + arrayList.getCapacity());
        System.out.println("arrayList.contains(14) = " + arrayList.contains(14));
        System.out.println("arrayList.isEmpty() = " + arrayList.isEmpty());
    }
}
