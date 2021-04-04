package org.xinyu.tree;

public class BinTree {

  // 有一个根节点
  public TreeNode root;

  public static int index;

  public BinTree(TreeNode root) {
    this.root = root;
  }

  private TreeNode initTree(int[] a) {
    TreeNode root = null;
    if (a[index] != '#') {
      root = new TreeNode(a[index]);
      index++;
      root.setLeft(initTree(a));
      index++;
      root.setRight(initTree(a));
    }
    return root;
  }

  // 先序遍历
  void prevOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.getData() + ",");
    prevOrder(root.getLeft());
    prevOrder(root.getRight());
  }

  // 中序遍历
  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.getLeft());
    System.out.print(root.getData() + ",");
    inOrder(root.getRight());
  }

  // 后序遍历
  public void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.getLeft());
    postOrder(root.getRight());
    System.out.print(root.getData() + ",");
  }
  // 获得高度
  public int getHeight() {
    TreeNode cur = this.root;
    int height = 0;
    while (cur != null) {
      cur = cur.getLeft();
      height++;
    }
    return height;
  }
  // 获得叶子数
  public int getLeaf(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.getRight() == null && root.getRight() == null) {
      System.out.println("Leaf:" + root.getData());
      return 1;
    }
    return getLeaf(root.getLeft()) + getLeaf(root.getRight());
  }
  // 获得第K层节点数
  public int getNodeKNum(TreeNode root, int k) {
    if (k == 1) {
      if (root == null) {
        return 0;
      }
      System.out.println("K Node:" + root.getData());
      return 1;
    }
    return getNodeKNum(root.getLeft(), k - 1) + getNodeKNum(root.getRight(), k - 1);
  }
  // 查找某个节点
  public TreeNode findNode(TreeNode root, int x) {
    if (root == null) {
      return null;
    } else if (root.getData() == x) {
      return root;
    }
    TreeNode leftNode = findNode(root.getLeft(), x);
    if (null != leftNode) {
      return leftNode;
    }
    TreeNode rightNode = findNode(root.getRight(), x);
    if (null != rightNode) {
      return rightNode;
    }
    return null;
  }
  // 返回某节点的父节点
  public TreeNode getParent(TreeNode root, int x) {
    if (root == null) {
      return null;
    }
    TreeNode childL = root.getLeft();
    TreeNode childR = root.getRight();
    if (childL != null && childL.getData() == x) {
      return root;
    }
    if (childR != null && childR.getData() == x) {
      return root;
    }
    TreeNode parentL = getParent(root.getLeft(), x);
    if (parentL != null) {
      return parentL;
    }
    TreeNode parentR = getParent(root.getRight(), x);
    if (parentR != null) {
      return parentR;
    }
    return null;
  }
}
