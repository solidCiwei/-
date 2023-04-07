package com.zw;

/**
 * <p> LinkedListPractice </p >
 * 链表题目练习
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 21:27
 */
public class LinkedListPractice {


    /**
     * 合并两个有序的链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }
        while (cur1 != null) {
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        return result.next;

    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 链表中是否存在环，存在环则返回环的入口否则返回null
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //相遇出现环
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        //无环返回空
        return null;
    }

    /**
     * 链表的中间节点
     * 朴素解法
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int index = size / 2;
        cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 快慢指针解法
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 删除倒数第n个节点
     * 双指针解法
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode slow = dump;
        ListNode fast = dump;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dump.next;
    }

}
