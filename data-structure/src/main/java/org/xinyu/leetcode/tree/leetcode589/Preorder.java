package org.xinyu.leetcode.tree.leetcode589;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 * <p>
 * <p>
 */
public class Preorder {

    /**
     * 使用递归解法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> r = new ArrayList<>();
        preNode(r, root);
        return r;
    }


    public void preNode(List<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node n : node.children) {
            preNode(list, n);
        }
    }

    /**
     * 使用栈实现
     * 利用栈先进后出的特点 将子节点 从右至左放入栈中
     *
     * @param root
     * @return
     */
    public static List<Integer> preorder1(Node root) {
        if (root == null) return new ArrayList<>(0);
        //使用栈实现
        Deque<Node> result = new LinkedList<>();
        result.add(root);
        List<Integer> r = new ArrayList<>();
        while (!result.isEmpty()) {
            Node poll = result.pop();
            r.add(poll.val);
            List<Node> children = poll.children;
            if (children != null) {
                //将孩子节点从右至左放至栈顶
                //
                for (int i = children.size() - 1; i >= 0; i--) {
                    result.push(children.get(i));
                }
            }

        }
        return r;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n4 = new Node(2);
        Node n5 = new Node(4);

        List<Node> c1 = new ArrayList<>(3);
        c1.add(n1);
        c1.add(n4);
        c1.add(n5);
        root.children = c1;

        List<Node> c2 = new ArrayList<>(2);
        c2.add(n2);
        c2.add(n3);
        n1.children = c2;
        List<Integer> integers = preorder1(root);
        Object[] objects = integers.stream().toArray();
        System.out.println(Arrays.toString(objects));

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
};