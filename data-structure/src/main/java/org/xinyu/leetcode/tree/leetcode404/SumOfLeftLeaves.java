package org.xinyu.leetcode.tree.leetcode404;


public class SumOfLeftLeaves {


    public static int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;
        if (root.left != null) {
            //如果左节点没有任何子节点,说明左节点是左叶子节点,加入sum
            if (root.left.right == null && root.left.left == null) {
                sum = sum + root.left.val;
            }
            //如果左节点有子节点,向下递归
            else {
                sum = sum + sumOfLeftLeaves(root.left);
            }
        }
        //向右递归
        if (root.right != null) {
            sum = sum + sumOfLeftLeaves(root.right);
        }
        //把总和返回去
        return sum;

    }

    public static int sum(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        if (node.left != null) {

            sum += node.left.val;
        }

        if (node.left == null && node.right == null) {
            return sum;
        }
        if (node.left != null) {
            sum = sum + node.left.val;
        }
        return sum(node.left, sum) + sum(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode = new TreeNode(19);
        TreeNode l2 = new TreeNode(5);
        root.left = treeNode;
        treeNode.left = l2;
        System.out.println(sumOfLeftLeaves(root));
    }


    static class TreeNode {
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
}
