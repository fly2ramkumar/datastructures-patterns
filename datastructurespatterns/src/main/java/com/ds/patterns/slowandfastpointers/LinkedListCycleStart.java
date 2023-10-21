package com.ds.patterns.slowandfastpointers;

import java.util.Optional;

public class LinkedListCycleStart {
	
	private static Optional<ListNode> startOfLinkedListCycle(ListNode head) {
		
		int cycleLength = LinkedListCycleLength.cycleLength(head);
		
		if(cycleLength == 0) {
			return Optional.empty();
		}
		
		int tempSequence = 0;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(tempSequence < cycleLength) {
			fast = fast.next;
			tempSequence++;
		}
		
		System.out.println("cycleLength - "+cycleLength+" fast "+ fast.value);
		
		
		System.out.println("Initial slow - "+slow.value+" fast "+ fast.value);
		
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
			System.out.println("Iteration slow - "+slow.value+" fast "+ fast.value);
		}	
		
		return Optional.of(slow);
	}
	
	private static void printResult(Optional<ListNode> resultNode) {
		
		if(resultNode.isPresent()) {
			System.out.println("Cycle start Node - "+resultNode.get().value);
		}else {
			System.out.println("Linked list has no cycle");
		}
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		Optional<ListNode> resultNode = LinkedListCycleStart.startOfLinkedListCycle(head);
		printResult(resultNode);
		
		head.next.next.next.next.next.next = head.next.next;
		resultNode = LinkedListCycleStart.startOfLinkedListCycle(head);
		printResult(resultNode);
		
		head.next.next.next.next.next.next = head.next.next.next;
		resultNode = LinkedListCycleStart.startOfLinkedListCycle(head);
		printResult(resultNode);
		
	}
	
	

}
