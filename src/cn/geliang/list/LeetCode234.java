package cn.geliang.list;

public class LeetCode234 {
    public static void main(String[] args) {
        int[] array = {1,2,2,13};
        ListNode head = ListUtil.buildList(array);
        LeetCode234 sol = new LeetCode234();
        System.out.println(sol.isPalindrome(head));

    }

    // 20190603
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        // 前半部分链表
        ListNode left = reverseList(head);
        // 判断链表奇偶长度
        ListNode leftNode = left;
        ListNode rightNode = slow;

        while (leftNode != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        // 判断链表左右长度是否相等，右侧长度一定大于等于左侧长度
        if(rightNode != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if(slow.val != left.val) {
                return false;
            }
            slow = slow.next;
            left = left.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
