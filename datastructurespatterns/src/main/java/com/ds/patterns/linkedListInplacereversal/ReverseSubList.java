package com.ds.patterns.linkedListInplacereversal;

public class ReverseSubList {
	
	private static ListNode reverse(ListNode head, int p, int q) {
		
		if(p == q) {
			return head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		
		for(int i=0; current != null && i < p-1; i++) {
			previous = current;
			current = current.next;
		}
		
		System.out.println("previous.value - "+previous.value);
		System.out.println("current.value - "+current.value);
		
		ListNode firstPart = previous;
		ListNode lastPart = current;
		
		ListNode next = null;
		
		for(int i =0; current != null && i < q-p+1; i++) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		System.out.println("firstPart.value after reverse - "+firstPart.value);
		System.out.println("lastPart.value after reverse - "+lastPart.value);
		System.out.println("previous.value after reverse - "+previous.value);
		System.out.println("current.value after reverse - "+current.value);
		
		if(firstPart != null) {
			firstPart.next = previous;
		}else {
			head = previous;
		}
		
		lastPart.next = current;
		
		return head;
	}
	
	private static void print(ListNode head) {
		while(head != null) {
			System.out.print(head.value+", ");
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
		
		System.out.print("Input - ");
		print(head);
		
		head = reverse(head, 2, 4);
		
		System.out.print("Output - ");
		print(head);
		
	}

}
