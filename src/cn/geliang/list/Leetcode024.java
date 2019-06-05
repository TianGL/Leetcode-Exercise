package cn.geliang.list;


public class Leetcode024 {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	// 20190514
	public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        while(node.next != null && node.next.next != null) {
        	ListNode node1 = node.next;
        	ListNode node2 = node1.next;
        	ListNode next = node2.next;
        	
        	node.next = node2;
        	node2.next = node1;
        	node1.next = next;
        	
        	node = node1;
        }
        ListNode resNode = dummyHead.next;
        dummyHead.next = null;
        return resNode;
    }
}
