package com.ds.patterns.modifiedBinarySearch;

public class CeilingOfANumber {

	// custom implementation	
	private static int findCeiling(int[] inputArray, int key) {
		
		if(inputArray == null || inputArray.length < 1) 
			return -1;
		
		int start = 0;
		int end = inputArray.length - 1;
		
		if(key < inputArray[start]) 
			return 0;
				
		if(key > inputArray[end])
			return -1;
		
		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(inputArray[middle] == key)
				return middle;
			
			if(inputArray[middle] < key && inputArray[middle + 1] > key)
				return middle + 1;
			
			if(inputArray[middle] > key && inputArray[middle-1] < key)
				return middle;
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}					
			
		}
		
		return -1;
	}
	
	private static int findCeilingGrokking(int[] inputArray, int key) {
		
		if(inputArray == null || inputArray.length < 1) 
			return -1;
		
		int start = 0;
		int end = inputArray.length - 1;
		
		if(key < inputArray[start]) 
			return 0;
				
		if(key > inputArray[end])
			return -1;
		
		while(start <= end) {
			int middle = start + (end - start) / 2;
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			} else if(key < inputArray[middle]) {
				end = middle - 1;
			} else {
				return middle;
			}
		}
		
		return start;
		
	}
	
	public static void main(String[] args) {
		System.out.println(findCeilingGrokking(new int[] {4, 6, 10}, 6));
		System.out.println(findCeilingGrokking(new int[] {1, 3, 8, 10, 15}, 12));
		System.out.println(findCeilingGrokking(new int[] {4, 6, 10}, 17));
		System.out.println(findCeilingGrokking(new int[] {4, 6, 10}, -1));
		System.out.println(findCeilingGrokking(new int[] {1, 3, 5, 7, 9, 11, 13, 15}, 12));
		System.out.println(findCeilingGrokking(new int[] {1, 3, 5, 7, 9, 11, 13, 15}, 14));
	}
	
}
