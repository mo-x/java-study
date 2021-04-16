package org.xinyu.leetcode.tree.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<List<Integer>> r = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();

        }
        return new ArrayList<>();

    }
}
