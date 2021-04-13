package org.xinyu.leetcode.tree.leetcode110;

/**
 * leetcode110 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <img alt="althernative text" src ="" />
 */
public class IsBalanced {


    public static boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }


    public static int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.right), depth(node.left)) + 1;
    }

    /**
     * 自下而上来遍历
     *
     * @param root
     * @return
     */
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(4);
        l1.left = l2;
        System.out.println(getTreeDepth(root));
        System.out.println();


    }


}
