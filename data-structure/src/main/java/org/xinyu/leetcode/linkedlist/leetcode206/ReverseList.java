package org.xinyu.leetcode.linkedlist.leetcode206;


public class ReverseList {

    /**
     * 双指针
     * 直接循环 因为末尾节点为null
     * 直接构造第一个节点为null 然后从头开始遍历
     * 如 1->2->3->4->5->null
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //当前指针
        ListNode curr = null;
        //上一指针
        ListNode pre = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (pre != null) {
            //获取下一节点
            ListNode next = pre.next;
            //下一节点为一个节点
            pre.next = curr;
            //上一节点为当前节点
            curr = pre;
            //获取下一节点
            pre = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        reverseList(head1);

        ListNode test1 = new ListNode(2);
        ListNode test2 = test1;
        test2.next = new ListNode(10);
        System.out.println(test1.next.val);
    }
}
