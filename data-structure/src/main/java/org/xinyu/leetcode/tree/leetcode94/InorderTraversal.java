package org.xinyu.leetcode.tree.leetcode94;

import java.util.*;

public class InorderTraversal {


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        depth(root, r);
        return r;
    }

    public static void depth(TreeNode root, List<Integer> list) {
        if (root == null) return;
        depth(root.left, list);
        list.add(root.val);
        depth(root.right, list);
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = root.right;
            }
        }
        return res;
    }

}
