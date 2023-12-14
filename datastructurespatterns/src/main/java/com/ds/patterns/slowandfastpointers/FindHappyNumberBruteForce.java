package com.ds.patterns.slowandfastpointers;

public class FindHappyNumberBruteForce {
	
	private static boolean isHappyNumber(int num) {
		
		if(num < 1) {
			return false;
		}
		
		ListNode head = new ListNode(num);
		ListNode current = head;
		int count = 0;
		
		
		while(num != 1) {
			
			num = getSumOfSquares(num);
			
			//System.out.println(num);
			current.next = new ListNode(num);
			current = current.next;
			count++;
			
			if(count % 5 == 0) {
				if(isCycle(head)) {
					return false;
				}
			}
		}
		
		return true;
	}
		
	private static int getSumOfSquares(int num) {
		
		int retVal = 0;
		String numString = Integer.toString(num);
		
		for(int i=0; i< numString.length(); i++) {
			Character numChar = numString.charAt(i);
			int numVal = Integer.parseInt(numChar.toString());
			retVal = retVal + (numVal * numVal);
		}
		
		return retVal;
	}
	
	private static boolean isCycle(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			//System.out.println(slow.value +" : "+fast.value);
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast != null) {
				if(slow.value == fast.value) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappyNumber(23));
		System.out.println(isHappyNumber(12));
	}

}
