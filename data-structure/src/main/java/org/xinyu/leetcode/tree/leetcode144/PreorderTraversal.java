package org.xinyu.leetcode.tree.leetcode144;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode144题目 二叉树的先序遍历
 */
public class PreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preNode(root, list);
        return list;
    }

    public static void preNode(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preNode(root.left, list);
            preNode(root.right, list);
        }
    }


}
