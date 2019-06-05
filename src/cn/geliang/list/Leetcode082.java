package cn.geliang.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Leetcode082 {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	// 20190513
	// ΩË÷˙≤È’“±Ì
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> record = new HashSet<Integer>();
        HashSet<Integer> dup = new HashSet<Integer>();
        ListNode node = head;
        while(node != null) {
        	if(record.contains(node.val) && !dup.contains(node.val)) {
        		dup.add(node.val);
        	} else if (!record.contains(node.val)) {
        		record.add(node.val);
        	}
        	node = node.next;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead;
        while(node != null && node.next != null) {
        	if(dup.contains(node.next.val)) {
        		ListNode delNode = node.next;
        		node.next = delNode.next;
        		delNode.next = null;
        	} else {
        		node = node.next;
        	}
        	
        }
        
        ListNode resNode = dummyHead.next;
        dummyHead.next = null;
        return resNode;
    }

}
