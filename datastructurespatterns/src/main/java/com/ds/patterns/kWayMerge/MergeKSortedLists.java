package com.ds.patterns.kWayMerge;

import java.util.PriorityQueue;

class ListNode {
	int value;
	ListNode next;

	public ListNode(int value) {
		this.value = value;
	}
}

public class MergeKSortedLists {

	private static ListNode merge(ListNode[] lists) {

		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
				(listNode1, listNode2) -> listNode1.value - listNode2.value);

		for (ListNode listNode : lists)
			minHeap.add(listNode);

		ListNode listHead = null, listTail = null;

		while (!minHeap.isEmpty()) {

			ListNode node = minHeap.poll();

			if (listHead == null) {
				listHead = listTail = node;

			} else {
				listTail.next = node;
				listTail = listTail.next;
			}

			if (node.next != null)
				minHeap.add(node.next);
		}

		return listHead;
	}

	public static void main(String[] args) {

		// 2 6 8 3 6 7 1 3 4

		ListNode listNode1 = new ListNode(2);
		listNode1.next = new ListNode(6);
		listNode1.next.next = new ListNode(8);

		ListNode listNode2 = new ListNode(3);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(7);

		ListNode listNode3 = new ListNode(1);
		listNode3.next = new ListNode(3);
		listNode3.next.next = new ListNode(4);

		ListNode result = MergeKSortedLists.merge(new ListNode[] { listNode1, listNode2, listNode3 });

		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}

	}
}
