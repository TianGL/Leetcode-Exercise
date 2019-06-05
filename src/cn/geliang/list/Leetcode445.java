package cn.geliang.list;

import java.util.Stack;

public class Leetcode445 {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	// 20190513
	// ¿˚”√’ª
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		while(cur1 != null) {
			stack1.push(cur1.val);
			cur1 = cur1.next;
		}
		while(cur2 != null) {
			stack2.push(cur2.val);
			cur2 = cur2.next;
		}
		
		Stack<Integer> ansStack = new Stack<Integer>();
		int redus = 0;
		while(!stack1.empty() || !stack2.empty() || redus !=0) {
			int ans = redus;
			if(stack1.empty() && stack2.empty()) {
				
			} else if(stack1.empty()) {
				ans += stack2.pop();
			} else if (stack2.empty()) {
				ans += stack1.pop();
			} else {
				ans += stack1.pop() + stack2.pop();
			}
			ansStack.push(ans % 10);
			redus = ans/10;
		}
		
		ListNode preHead = new ListNode(0);
		ListNode cur = preHead;
		while(ansStack.size() != 0) {
			cur.next = new ListNode(ansStack.pop());
			cur = cur.next;
		}
		return preHead.next;
	}

}
