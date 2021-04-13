package org.xinyu.example.tree.leetcode104;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 *
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 */
public class MaxDepth {

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxDepth = Integer.MIN_VALUE;
        if (root.left != null) {
            maxDepth = Math.max(maxDepth(root.left), maxDepth);
        }
        if (root.right != null) {
            maxDepth = Math.max(maxDepth(root.right), maxDepth);
        }
        return maxDepth + 1;
    }
}
