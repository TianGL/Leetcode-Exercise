package cn.geliang.list;


public class Leetcode025 {
	
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	// 20190514
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) {
			return head;
		}
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode node = dummyHead;
		while(node.next != null) {
			boolean isValid = true;
			ListNode next = node.next;
			// �ж��Ƿ񻹳���K���ڵ�û�з�ת
			for(int i = 0; i < k; ++i) {
				if(next == null) {
					isValid = false;
					break;
				}
				next = next.next;
			}
			if(!isValid) { // ʣ��ڵ㲻��k��������Ҫ��ת
				break;
			}
			
			// ��תk���ڵ�
			ListNode end = node.next;
			ListNode pre = end;
			ListNode cur = pre.next;
			for(int i = 1; i < k; ++i) {
				ListNode curNext = cur.next;
				cur.next = pre;
				pre = cur;
				cur = curNext;
			}
			node.next = pre;
			end.next = next;
			
			node = end;	
		}
		
		ListNode resNode = dummyHead.next;
		dummyHead.next = null;
		return resNode;
	}
	
}
