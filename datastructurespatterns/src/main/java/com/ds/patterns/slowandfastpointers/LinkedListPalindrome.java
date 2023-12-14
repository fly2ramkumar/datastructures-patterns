package com.ds.patterns.slowandfastpointers;

public class LinkedListPalindrome {
	
	private static boolean isPalindrome(ListNode head) {
		
		if(head == null || head.next == null) {
			return true;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode headSecondHalf = reverse(slow);
		ListNode copyHeadSecondHalf = headSecondHalf;
		
		
		
		
		return false;
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
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		
		System.out.println(LinkedListPalindrome.isPalindrome(head));
		
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(6);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(2);
		head1.next.next.next.next.next = new ListNode(2);
		
		System.out.println(LinkedListPalindrome.isPalindrome(head1));
		
	}

}
