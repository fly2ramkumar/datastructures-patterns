package com.ds.patterns.slowandfastpointers;

public class LinkedListRearrange {
	
	private static void rearrange(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode headSecondHalf = reverse(slow);
		ListNode headFirstHalf = head;
		
		System.out.print("headFirstHalf full - ");
		print(headFirstHalf);
		
		System.out.print("headSecondHalf full - ");
		print(headSecondHalf);
		
		System.out.print("head after reverse - ");
		print(head);
				
		System.out.println();
		
		while(headFirstHalf != null && headSecondHalf != null) {
			
			System.out.println("headFirstHalf value - "+headFirstHalf.value+" headSecondHalf value -  "+headSecondHalf.value);
			
			ListNode temp = headFirstHalf.next;
			headFirstHalf.next = headSecondHalf;
			headFirstHalf = temp;
			
			System.out.print("first half and temp - ");
			print(headFirstHalf);
			
			System.out.print("second half- ");
			print(headSecondHalf);
			
			System.out.print("head - ");
			print(head);
			
			System.out.println();
			
			temp = headSecondHalf.next;
			headSecondHalf.next = headFirstHalf;
			headSecondHalf = temp;
			
			System.out.print("second half and temp - ");
			print(headSecondHalf);
			
			System.out.print("first half - ");
			print(headFirstHalf);
			
			System.out.print("head - ");
			print(head);
			
			
			System.out.println("Iteration completed");
			System.out.println();
		}
		
		System.out.print("head before- ");
		print(head);
		
		System.out.print("headFirstHalf before - ");
		print(headFirstHalf);
		
		if(headFirstHalf != null) {
			headFirstHalf.next = null;
		}
		
		System.out.print("head after- ");
		print(head);
		
		System.out.print("headFirstHalf after - ");
		print(headFirstHalf);
	}
	
	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	/*
	 * private static void printHead(ListNode head) { int count = 1; while(head !=
	 * null && count < 10) { System.out.print(head.value+", "); head = head.next;
	 * count++; } System.out.println(); }
	 */	
	private static void print(ListNode head) {
		int count = 1;
		while(head != null && count < 10) {
			System.out.print(head.value+", ");
			head = head.next;
			count++;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		
		print(head);
		System.out.println();
		
		LinkedListRearrange.rearrange(head);
		
		print(head);
		
		
		
		
	}

}
