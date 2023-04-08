package com.zw;

/**
 * <p> LRULinkedList </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/7 21:16
 */
public class LRULinkedList<T> {


    private final static int DEFAULT_SIZE = 10;


    /**
     * 头节点
     */
    LRUListNode<T> head;

    /**
     * 元素个数
     */
    private Integer size;

    /**
     * 容量
     */
    private Integer capacity;

    public LRULinkedList() {
        this.head = new LRUListNode<>();
        size = 0;
        capacity = DEFAULT_SIZE;
    }


    /**
     * 队列中添加节点
     *
     * @param t
     */
    public void add(T t) {
        //查询元素是否存在数组中
        LRUListNode data = findPre(t);
        //等于空说明不存在于数组中
        if (data == null) {
            if (size >= capacity) {
                //删除尾部元素
                delEndElement();
            }
            //插入节点位于头部
            addByIndex(0, t);
        } else {
            //删除节点原来位置
            delElement(data);
            //插入节点至头部
            addByIndex(0, t);
        }
    }

    /**
     * 删除元素
     *
     * @param node
     */
    public void delElement(LRUListNode<T> node) {
        LRUListNode temp = node.getNext();
        node.setNext(temp.getNext());
        temp = null;
        size--;
    }

    /**
     * 删除尾部节点
     */
    public void delEndElement() {
        if (head.getNext() == null) return;
        LRUListNode cur = head;
        //获取最后一个节点的前驱，即倒数第二个节点
        while (cur.getNext().getNext() != null) {
            cur = cur.getNext();
        }
        //删除节点
        LRUListNode temp = cur.getNext();
        cur.setNext(null);
        //释放内存
        temp = null;
        size--;

    }

    /**
     * 根据下标插入节点
     *
     * @param index 下标
     */
    private void addByIndex(int index, T t) {
        if (index > size) {
            throw new IndexOutOfBoundsException("-1");
        }
        LRUListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        LRUListNode<T> addNode = new LRUListNode<>(t);
        addNode.setNext(cur.getNext());
        cur.setNext(addNode);
        size++;
    }

    /**
     * 找到操作节点的前驱节点
     *
     * @param t
     * @return
     */
    public LRUListNode findPre(T t) {
        LRUListNode<T> cur = head;
        while (cur.getNext() != null) {
            if (cur.getNext().getE() == t) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public void printAll() {
        LRUListNode node = head.getNext();
        while (node != null) {
            System.out.print(node.getE() + ",");
            node = node.getNext();
        }
        System.out.println();
    }
}
