package com.ds.patterns.modifiedBinarySearch;

public class RotatedArrayCount {
	
	// custom implementation
	private static int findCount(int[] inputArray) {
		
		int start = 0;
		int end = inputArray.length - 1;
		
		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;
		
		while(start <= end) {
		
			int middle = start + (end - start) / 2;
			
			if(inputArray[start] <= inputArray[middle]) {
				if(inputArray[start] < minValue) {
					minValue = inputArray[start];
					minIndex = start;
				}
				
				start = middle + 1;
			} else {
				
				if(inputArray[middle] < minValue ) {
					minValue = inputArray[middle];
					minIndex = middle;
				}
				
				end = middle - 1;
			}
			
		}
		
		return minIndex;
	}
	
	private static int findCountGrokking(int[] inputArray) {
		int start = 0;
		int end = inputArray.length - 1;
				
		while(start <= end) {
		
			int middle = start + (end - start) / 2;
			
			if(middle < end && inputArray[middle] > inputArray[middle + 1]) {
				return middle + 1;
			}
			
			if(middle > start && inputArray[middle - 1] > inputArray[middle]) {
				return middle;
			}
			
			if(inputArray[start] < inputArray[middle]) {
				start = middle + 1;
			} else {				
				end = middle - 1;
			}
			
		}
		
		return 0;	
	}
	
	public static void main(String[] args) {
		System.out.println(findCountGrokking(new int[] {10, 15, 1, 3, 8}));
		System.out.println(findCountGrokking(new int[] {4, 5, 7, 9, 10, -1, 2}));
	}

}
