package com.ds.patterns.slowandfastpointers;

public class FindHappyNumber {
	
	private static boolean isHappyNumber(int num) {
		
		if(num < 0) {
			return false;
		}
		
		int slow = num;
		int fast = num;
		
		do {
			slow = getSumOfSquares(slow);
			fast = getSumOfSquares(getSumOfSquares(fast));
			
		}while(slow != fast);
		
		if(slow == 1) {
			return true;
		}
		
		return false;
	}
	
	private static int getSumOfSquares(int num) {		
		int digit = 0;
		int sum = 0;
		
		while(num > 0) {
			digit = num % 10;			
			sum += digit * digit;
			num /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappyNumber(23));
		System.out.println(isHappyNumber(12));
	}

}
