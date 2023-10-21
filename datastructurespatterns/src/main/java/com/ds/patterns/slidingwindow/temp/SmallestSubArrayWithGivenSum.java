package com.ds.patterns.slidingwindow.temp;

public class SmallestSubArrayWithGivenSum {
	
	private static int calculateSmallestSubArrayWithGivenSum(int[] array, int sum) {
		
		int windowSum = 0;
		int minLength = Integer.MAX_VALUE;
		int windowStart = 0;
		
		for(int windowEnd = 0; windowEnd < array.length; windowEnd++) {
			
			windowSum += array[windowEnd];
			
			while(windowSum >= sum) {
				minLength = Math.min(minLength, ((windowEnd - windowStart)+1));
				windowSum -= array[windowStart];
				windowStart++;
			}
			
		}
		
		return Math.min(minLength, Integer.MAX_VALUE);
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(SmallestSubArrayWithGivenSum.calculateSmallestSubArrayWithGivenSum(new int[] {2, 1, 5, 2, 3, 2}, 7));
		System.out.println(SmallestSubArrayWithGivenSum.calculateSmallestSubArrayWithGivenSum(new int[] {2, 1, 5, 2, 8}, 7));
		System.out.println(SmallestSubArrayWithGivenSum.calculateSmallestSubArrayWithGivenSum(new int[] {3, 4, 1, 1, 6}, 8));
	}

}
