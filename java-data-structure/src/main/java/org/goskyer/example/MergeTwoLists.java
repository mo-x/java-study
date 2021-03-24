package org.goskyer.example;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>示例：
 *
 * <p>输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode temp;
    if (l1.val < l2.val) {
      temp = l1;
      temp.next = mergeTwoLists(l1.next, l2);
    } else {
      temp = l2;
      temp.next = mergeTwoLists(l1, l2.next);
    }
    return temp;
  }

  public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

    // 设置一个新的链表（合并后的）的头结点
    ListNode temp = new ListNode(-1);
    // result代表返回的头结点
    ListNode result = temp;
    // 如果l1 l2 都不为null，则进行比较
    // 如果l1 小于 l2  则将temp的 next 指向 此时l1的节点，然后l1在后移一位，同时更新temp的值。
    // l2 同理
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
        temp = temp.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
        temp = temp.next;
      }
    }

    // 如果l1  l2 有一方变成了null 则 将此时的temp的next指向另一方的剩下的节点（即将剩余的节点接在temp后面）
    if (l1 == null) {
      temp.next = l2;
    }
    if (l2 == null) {
      temp.next = l1;
    }
    // 返回头结点
    return result.next;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(4);
    listNode.next = listNode1;
    listNode1.next = listNode2;

    ListNode node = new ListNode(1);
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(4);
    node.next = node1;
    node1.next = node2;
    ListNode listNode3 = mergeTwoLists(listNode, node);
    System.out.println(listNode3);
    ListNode listNode4 = mergeTwoLists1(listNode, node);
    System.out.println(listNode4);
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
