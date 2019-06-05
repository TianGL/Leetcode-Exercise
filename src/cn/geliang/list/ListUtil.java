package cn.geliang.list;

import java.util.ArrayList;

public class ListUtil {
	public static ListNode buildList(int[] arr) {
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		for(int i = 0; i < arr.length; ++i) {
			node.next = new ListNode(arr[i]);
			node = node.next;
		}
		return dummy.next;
	}
	
	public static void printList(ListNode head) {
		ListNode node = head;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(node != null) {
			arr.add(node.val);
			node = node.next;
		}
		System.out.println(arr);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
