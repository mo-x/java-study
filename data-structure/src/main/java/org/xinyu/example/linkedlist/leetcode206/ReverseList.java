package org.xinyu.example.linkedlist.leetcode206;


public class ReverseList {

    /**
     * 直接循环 因为末尾节点为null
     * 直接构造第一个节点为null 然后从头开始遍历
     * 如 1->2->3->4->5->null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            //获取下一节点
            ListNode next = curr.next;
            //下一节点为当前第一个节点
            curr.next = prev;
            //上一节点为当前节点
            prev = curr;
            //获取下一节点
            curr = next;
        }
        return prev;
    }
}
