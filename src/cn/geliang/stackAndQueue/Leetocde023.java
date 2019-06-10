package cn.geliang.stackAndQueue;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetocde023 {
    // samart
    public ListNode mergeKLists00(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeCompare());
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        while (pq.size() != 0) {
            cur.next = pq.poll();
            cur=cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }

    // 20190610
    public ListNode mergeKLists(ListNode[] lists) {
        boolean isValid = true;

        // 确定合法链表数目
        int n = 0;
        for (ListNode node : lists) {
            if (node != null) {
                n++;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeCompare());
        int count = 0;
        while (true) {
            int idx = -1;
            // 遍历，寻找最小节点
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null) {
                    if (idx == -1) {
                        idx = i;
                    } else {
                        if (lists[idx].val > lists[i].val) {
                            idx = i;
                        }
                    }
                }
            }
            if (idx == -1) {
                break;
            }

            ListNode nextNode = lists[idx];
            lists[idx] = lists[idx].next;
            nextNode.next = null;
            if (pq.size() == n) {
                if (pq.peek().val <= nextNode.val) {
                    cur.next = pq.poll();
                    pq.offer(nextNode);
                } else {
                    cur.next = nextNode;
                }
                cur = cur.next;
            } else {
                pq.offer(nextNode);
            }
        }

        while (pq.size() != 0) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        ListNode resHead = dummy.next;
        dummy.next = null;
        return resHead;
    }

    private class ListNodeCompare implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) {
        Leetocde023 sol = new Leetocde023();
        ListNode[] lists = new ListNode[3];
        int[] a1 = {-9,-1,-1,0,3,3,3};
        int[] a2 = {-6,1};
        int[] a3 = {9,2};
        lists[0] = buildList(a1);
        lists[1] = buildList(a2);
        lists[2] = buildList(a3);
//        ListNode res = sol.mergeKLists(lists);
//        printList(res);
        printList(sol.mergeKLists00(lists));

    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        for (int i = 0; i < arr.length; ++i) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode node = head;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (node != null) {
            arr.add(node.val);
            node = node.next;
        }
        System.out.println(arr);
    }

}
