package cn.geliang.list;

public class Leetcode019 {
    // 20190522
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n + 1; ++i) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        if(delNode != null) {
            p.next = delNode.next;
            delNode.next = null;
        }
        ListNode resNode = dummy.next;
        dummy.next = null;
        return resNode;
    }
}
