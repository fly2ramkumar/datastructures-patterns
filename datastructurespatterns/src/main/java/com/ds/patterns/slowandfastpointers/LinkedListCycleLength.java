package com.ds.patterns.slowandfastpointers;

public class LinkedListCycleLength {

	public static int cycleLength(ListNode head) {
			
		ListNode fast = head;
		ListNode slow = head;
		boolean isCycle = false;
		
		while(fast != null && fast.next != null ) {
			
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				isCycle = true;
				break;
			}
		}
		
		if(!isCycle) {
			return 0;
		}
		
		
		
		ListNode current = slow;
		int length = 0;
		
		do {
			length++;
			current = current.next;
		} while(current != slow) ;
		
		return length;
			
			
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		System.out.println(LinkedListCycleLength.cycleLength(head));
		
		head.next.next.next.next.next.next = head.next.next;
		System.out.println(LinkedListCycleLength.cycleLength(head));
		
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println(LinkedListCycleLength.cycleLength(head));
		
	}
	
}
