package org.xinyu.leetcode.tree.leetcode100;


/**
 * leetcode 100 相同的树
 * <p>
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * <p>
 */
public class IsSameTree {


    /**
     * 通过递归 循环比较左子树和右子树上的值是否相等
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;

        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        p.val = 1;

        TreeNode q = new TreeNode();
        q.val = 1;

        TreeNode p1 = new TreeNode();
        p1.val = 2;

        TreeNode q1 = new TreeNode();
        q1.val = 2;


        p.left = p1;
        q.left = q1;

        System.out.println(isSameTree(p, q));


    }
}
