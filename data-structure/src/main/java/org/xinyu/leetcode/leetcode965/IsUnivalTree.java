package org.xinyu.leetcode.leetcode965;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashSet;
import java.util.Set;

public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        isSame(root, set);
        return set.size() == 1;

    }

    public static void isSame(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        if (set.size() > 1) {
            return;
        }
        isSame(root.left, set);
        isSame(root.right, set);
    }


    private static void isSame(TreeNode root, int val, boolean isSame) {
        if (root == null) {
            return;
        }
        if (root.val != val) {
            isSame = false;
        }
        isSame(root.left, val, isSame);
        isSame(root.right, val, isSame);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}