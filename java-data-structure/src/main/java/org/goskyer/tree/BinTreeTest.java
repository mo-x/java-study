package org.goskyer.tree;

public class BinTreeTest {

  public static void main(String[] args) {
    //
    TreeNode root = new TreeNode(1);

    root.setLeft(new TreeNode(2));
    root.setRight(new TreeNode(3));
    root.getLeft().setLeft(new TreeNode(4));
    root.getLeft().setRight(new TreeNode(5));

    root.getRight().setRight(new TreeNode(6));
    root.getRight().setLeft(new TreeNode(7));

    BinTree binTree = new BinTree(root);
    //    binTree.prevOrder(root);
    System.out.println();
    binTree.inOrder(root);
    /*   System.out.println();
    binTree.postOrder(root);*/
  }
}
