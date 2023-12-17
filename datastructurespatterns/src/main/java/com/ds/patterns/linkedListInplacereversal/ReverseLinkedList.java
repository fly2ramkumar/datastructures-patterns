package com.ds.patterns.linkedListInplacereversal;


public class ReverseLinkedList {
	
	private static ListNode reverse(ListNode head) {
		
		ListNode prev = null;
		ListNode next = null;
		
		while(head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	private static void print(ListNode head) {
		while(head != null) {
			System.out.print(head.value+", ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		
		System.out.print("Input - ");
		print(head);
		
		head = reverse(head);
		
		System.out.print("Output - ");
		print(head);
		
	}

}
