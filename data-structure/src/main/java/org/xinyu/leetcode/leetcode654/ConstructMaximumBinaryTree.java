package org.xinyu.leetcode.leetcode654;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int asInt = Arrays.stream(nums).max().getAsInt();
        TreeNode root = new TreeNode(asInt);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < asInt) {
                TreeNode n = new TreeNode(nums[i]);

            }
        }
        return root;

    }

    public void create(TreeNode root, int max, int[] nums) {


    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}