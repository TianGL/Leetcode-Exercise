package cn.geliang.list;

import java.util.List;

public class Leetcode143 {
    // 20190523
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        // 1 从中间拆分两个链表
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 反转右侧链表
        pre = null;
        ListNode right = reverseList(slow);
        ListNode left = head;
        while(left != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            pre = right;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
        if(pre != null && right != null) {
            pre.next = right;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
