package com.zw;

import java.util.List;

/**
 * <p> Node </p >
 *
 * @author zw
 * @version 1.0
 * @date 2023/4/10 21:08
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
