package org.xinyu.example.linkedlist.leetcode203;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        //返回结果
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        //上一个节点
        ListNode prev = head;
        //当前节点
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;

    }
}
