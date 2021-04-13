package org.xinyu.leetcode.linkedlist.leetcode203;

public class ListNode {
    protected int val;
    protected ListNode next;

    protected ListNode() {
    }

    protected ListNode(int val) {
        this.val = val;
    }

    protected ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
