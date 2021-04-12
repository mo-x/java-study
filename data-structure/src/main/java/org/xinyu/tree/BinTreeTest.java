package org.xinyu.tree;

public class BinTreeTest {

    public static void main(String[] args) {
        //
        TreeNode root = new TreeNode(1);

        TreeNode rootL = new TreeNode(2);
        root.setLeft(rootL);
        TreeNode treeNode1 = new TreeNode(4);
        rootL.setLeft((treeNode1));
        treeNode1.setLeft(new TreeNode(9));
        rootL.setRight(new TreeNode(5));

        TreeNode rootR = new TreeNode(3);
        root.setRight(rootR);
        TreeNode treeNode = new TreeNode(6);
        rootR.setLeft(treeNode);

        treeNode.setLeft(new TreeNode(7));

        BinTree binTree = new BinTree(root);
//        binTree.prevOrder(root);
//        System.out.println();
        binTree.inOrder(root);
        System.out.println();
        binTree.postOrder(root);
    }
}
