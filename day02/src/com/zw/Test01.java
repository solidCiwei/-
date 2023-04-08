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
//        LRULinkedList<String> linkedList = new LRULinkedList<>();
//        for (int i = 0; i < 20; i++) {
//            linkedList.add("s" + i);
//            linkedList.printAll();
//        }
//        linkedList.add("s10");
//        linkedList.printAll();
//        linkedList.add("s15");
//        linkedList.printAll();
//        SimpleStack stack = new SimpleStack();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i);
//        }
//        System.out.println("stack.peek() = " + stack.peek());
//        while (!stack.isEmpty()){
//            System.out.println("stack.pop() = " + stack.pop());
//        }
//        SimpleLinkedStack stack = new SimpleLinkedStack();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i+"");
//        }
//        System.out.println("stack.peek() = " + stack.peek());
//        while (!stack.isEmpty()){
//            System.out.println("stack.pop() = " + stack.pop());
//        }
        SimpleBrowserGo browserGo = new SimpleBrowserGo();
        browserGo.open("https://www.baidu.com");
        browserGo.open("https://www.baidu.com/cn");
        browserGo.open("https://www.baidu.com/asd");
        browserGo.open("https://www.baidu.com/qwe");
        browserGo.goBack();
        browserGo.goBack();
        browserGo.goForward();
        browserGo.open("https://www.baidu.com/top");
        System.out.println("browserGo.goForward() = " + browserGo.goForward());
        browserGo.goBack();
        browserGo.goForward();
    }
}
