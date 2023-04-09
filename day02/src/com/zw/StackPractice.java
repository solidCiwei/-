package com.zw;

import org.testng.annotations.Test;

import java.util.Stack;

/**
 * <p> StackPractice </p >
 * 有关栈的一些练习题
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/8 15:59
 */
public class StackPractice {

    @Test
    public void test01() {
//        String s = "(";
//        System.out.println("isValid(s) = " + isValid(s));
    }

    /**
     * 有效括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    /**
     * 括号匹配
     * 优化版，逻辑更加清晰，结构更好
     *
     * @param s
     * @return
     */
    public boolean isValidV2(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push('[');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }


    /**
     * 最小栈
     * 常数时间获取栈中最小值
     */
    class MinStack {

        StackNode head;


        int size;

        class StackNode {
            int val;

            int minVal;

            StackNode next;

            public StackNode(int val, int minVal) {
                this.val = val;
                this.minVal = minVal;
            }

        }

        public MinStack() {
            head = new StackNode(0, 0);
        }

        /**
         * 添加节点至头部
         *
         * @param val
         */
        public void push(int val) {
            StackNode node;
            if (size == 0) {
                node = new StackNode(val, val);
            } else {
                node = new StackNode(val, Math.min(head.next.minVal, val));
            }
            node.next = head.next;
            head.next = node;
            size++;
        }

        public void pop() {
            if (size == 0) return;
            head = head.next;
            size--;
        }

        public int top() {
            if (head.next == null) throw new RuntimeException("empty stack");
            return head.next.val;
        }

        public int getMin() {
            return head.next.minVal;
        }
    }

    /**
     * 双栈实现队列
     */
    class MyQueue {


        //输入栈
        Stack<Integer> inStack;

        //输出栈
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * 入队方法
         *
         * @param x
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * 出队方法
         *
         * @return
         */
        public int pop() {
            //如果输出栈为空，则将输入栈数据全部导出至输入栈
            stackOutPut();
            return outStack.pop();
        }

        /**
         * 返回队列开头元素
         *
         * @return
         */
        public int peek() {
            stackOutPut();
            return outStack.peek();
        }

        /**
         * 如果队列为空则返回true，否则false
         *
         * @return
         */
        public boolean empty() {
            if (inStack.empty() && outStack.empty()) {
                return true;
            }
            return false;
        }

        public void stackOutPut() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }

}
