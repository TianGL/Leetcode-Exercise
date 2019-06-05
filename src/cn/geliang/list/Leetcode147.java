package cn.geliang.list;

public class Leetcode147 {

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 20190514
	public ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode node = head;
		ListNode cur = node.next; // 待插入节点
		while (cur != null) {
			ListNode next = cur.next;
			ListNode point = dummyHead;
			while (point.next != cur) { // 待插入节点之前的节点
				if (point.next.val > cur.val) {
					ListNode curNext = point.next;
					point.next = cur;
					cur.next = curNext;
					point = cur.next;
					while (point.next != cur) {
						point = point.next;
					}
					point.next = next;
					break;
				}
				point = point.next;
			}

			cur = next;
		}
		ListNode resNode = dummyHead.next;
		dummyHead.next = null;
		return resNode;
	}
	
	// 20190514 
	public ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyHead = new ListNode(-1);
		ListNode node = head;
		while(node != null) {
			ListNode cur = dummyHead;
			while(cur.next != null && cur.next.val < node.val) {
				cur = cur.next;
			}
			ListNode next = cur.next;
			cur.next = node;
			node = node.next;
			cur.next.next = next;
			
		}
		ListNode resNode = dummyHead.next;
		dummyHead.next = null;
		return resNode;
		
		
	}

}
