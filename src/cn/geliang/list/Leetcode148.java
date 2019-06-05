package cn.geliang.list;

// 两种方法
public class Leetcode148 {

	public static void main(String[] args) {

		int[] arr = { -1, 5, 3, 4, 0 };
		ListNode head = ListUtil.buildList(arr);

		Leetcode148 sol = new Leetcode148();
		ListUtil.printList(sol.sortList(head));
		ListUtil.printList(sol.sortList2(head));
	}

	// 20190515
	// buttom to up
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		int len = 0;
		// 获取链表长度
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		// 自底向上归并
		for (int step = 1; step < len; step = step << 1) {
			ListNode pre = dummy;
			cur = pre.next;
			while (cur != null) {
				ListNode left = cur;
				ListNode right = split(left, step);
				cur = split(right, step);
				pre = merge(pre, left, right);
			}
		}
		ListNode resNode = dummy.next;
		dummy.next = null;
		return resNode;
	}

	/**
	 * 拆分链表
	 * 
	 * @param head 当前链表头
	 * @param len  拆分长度
	 * @return 下一段链表头
	 */
	private ListNode split(ListNode head, int len) {

		ListNode node = head;
		for (int i = 1; node != null && i < len; i++) {
			node = node.next;
		}
		if (node == null) {
			return null;
		}
		ListNode nextHead = null;
		if (node.next != null) {
			nextHead = node.next;
		}
		node.next = null;
		return nextHead;

	}

	/**
	 * 归并链表
	 * 
	 * @param pre   待归并链表的前头节点
	 * @param left
	 * @param right
	 * @return 归并后链表的尾节点
	 */
	private ListNode merge(ListNode pre, ListNode left, ListNode right) {
		ListNode node = pre;
		while (left != null || right != null) {
			if (left == null) {
				node.next = right;
				right = right.next;
			} else if (right == null) {
				node.next = left;
				left = left.next;
			} else {
				if (left.val <= right.val) {
					node.next = left;
					left = left.next;
				} else {
					node.next = right;
					right = right.next;
				}
			}
			node = node.next;
		}
		return node;
	}

	// 20190515
	// up to buttom 归并
	public ListNode sortList2(ListNode head) {
		
		if(head == null || head.next == null ) {
			return head;
		}
		
		ListNode pre = null, slow = head, fast = head;
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode left = sortList2(head);
		ListNode right = sortList2(slow);
		
		return merge(left, right);
	}
	
	/**
	 * 归并链表
	 * 
	 * @param pre   待归并链表的前头节点
	 * @param left
	 * @param right
	 * @return 归并后链表的尾节点
	 */
	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		while (left != null || right != null) {
			if (left == null) {
				node.next = right;
				right = right.next;
			} else if (right == null) {
				node.next = left;
				left = left.next;
			} else {
				if (left.val <= right.val) {
					node.next = left;
					left = left.next;
				} else {
					node.next = right;
					right = right.next;
				}
			}
			node = node.next;
		}
		return dummy.next;
	}

}
