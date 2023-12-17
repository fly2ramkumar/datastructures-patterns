package com.ds.patterns.linkedListInplacereversal;

public class ReverseKElementSubList {

	private static ListNode reverse(ListNode head, int k) {
		
		if(k <= 1 || head == null)
			return head;
		
		ListNode current = head, previous= null;
		
		while(true) {
			
			ListNode lastNodeOfPreviousPart = previous;
			ListNode lastNodeOfSubList = current;
			ListNode next = null;
			
			for (int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			
			if(lastNodeOfPreviousPart != null) {
				lastNodeOfPreviousPart.next = previous;
			}else {
				head = previous;
			}
			
			System.out.println("lastNodeOfSubList value before - "+lastNodeOfSubList.value);
			lastNodeOfSubList.next = current;
			
			System.out.println("lastNodeOfSubList value after - "+lastNodeOfSubList.value);
			
			if(current == null)
				break;
			
			previous = lastNodeOfSubList;
		}
		
		return head;
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.value + ", ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		System.out.print("Input - ");
		print(head);

		head = reverse(head, 3);

		System.out.print("Output - ");
		print(head);

	}

}
