package org.xinyu.example.linkedlist.leetcode83;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 */
public class DeleteDuplicates {


    /**
     * 利用set集合去完成去重
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        //上一个节点
        ListNode pre = head;
        //当前节点
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr.val)) {
                //如果包含了值就将指针指向下一节点
                pre.next = curr.next;
            } else {
                pre = curr;
                set.add(curr.val);
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 直接遍历链表 比较当前节点和next节点值
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        deleteDuplicates(head1);

    }
}
