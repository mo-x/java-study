package org.xinyu.leetcode.tree.leetcode102;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrder {

    /**
     * 利用队列做树的层级遍历 层级遍历即广度优先
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> r = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //获取头节点并移除队列
                TreeNode node = queue.remove();
                integers.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!integers.isEmpty()) {
                r.add(integers);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> lists = levelOrder(root);
    }
}
