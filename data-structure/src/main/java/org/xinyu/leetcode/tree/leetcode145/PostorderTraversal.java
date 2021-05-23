package org.xinyu.leetcode.tree.leetcode145;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.树的后续遍历
 */
public class PostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public static void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }
}
