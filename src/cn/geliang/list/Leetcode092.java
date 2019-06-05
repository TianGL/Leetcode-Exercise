package cn.geliang.list;

public class Leetcode092 {
	// 20190512
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre = null;
		ListNode cur = head;
		int i = 0;
		for(; i < m-1; ++i ) {
			pre = cur;
			cur = cur.next;
		}
		ListNode preHead = pre;
		ListNode endNode = cur;
		ListNode pos = cur;
		for(;i < n; ++i) {
			cur = pos;
			ListNode next = pos.next;
			pos.next = pre;
			pre = pos;
			pos = next;
		}
		if(preHead != null) {
			preHead.next = cur;
			endNode.next = pos;
			return head;
		} else {
			endNode.next = pos;
			return cur;
		}
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

}
