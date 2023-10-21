package com.ds.patterns.slidingwindow.temp;

public class MaxiumumSumOfSubArray {
	
	private static int calculateMaximumSumOfSubArray(int[] array, int k) {
		
		int windowSum = 0;
		int windowStart = 0;
		int maximumSum = -1;
		
		for(int windowEnd = 0; windowEnd <= array.length -1; windowEnd++) {
			windowSum += array[windowEnd];
			
			if(windowEnd >= k-1) {
				
				maximumSum = Math.max(windowSum, maximumSum);
				
				windowSum -= array[windowStart];
				windowStart++;
			}
		}
		
		return maximumSum;
	}
	
	public static void main(String[] args) {
		
		System.out.println(MaxiumumSumOfSubArray.calculateMaximumSumOfSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3));
		
		System.out.println(MaxiumumSumOfSubArray.calculateMaximumSumOfSubArray(new int[] {2, 3, 4, 1, 5}, 2));
		
	}

}
