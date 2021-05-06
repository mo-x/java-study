package org.xinyu.leetcode.tree.leetcoce559;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {


    public int maxDepth(Node root) {
        //1.确定结束条件
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        //2.确定单次
        List<Integer> height = new LinkedList<>();
        for (Node node : root.children) {
            height.add(maxDepth(node));
        }
        return Collections.max(height) + 1;
    }

    public static void main(String[] args) {

    }

}


class Node {
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