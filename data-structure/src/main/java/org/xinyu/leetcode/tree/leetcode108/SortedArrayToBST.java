package org.xinyu.leetcode.tree.leetcode108;

public class SortedArrayToBST {


    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //构造左节点
        root.left = helper(nums, left, mid - 1);
        //构造右节点
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }


}
