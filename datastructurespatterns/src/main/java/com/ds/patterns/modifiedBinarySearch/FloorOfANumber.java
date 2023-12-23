package com.ds.patterns.modifiedBinarySearch;

public class FloorOfANumber {
	
	private static int findFloor(int[] inputArray, int key) {
		
		if(inputArray == null || inputArray.length < 1) 
			return -1;
		
		int start = 0;
		int end = inputArray.length - 1;
		
		if(key < inputArray[start]) 
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
		
		return end;
		
	}
	
	public static void main(String[] args) {
		System.out.println(findFloor(new int[] {4, 6, 10}, 6));
		System.out.println(findFloor(new int[] {1, 3, 8, 10, 15}, 12));
		System.out.println(findFloor(new int[] {4, 6, 10}, 17));
		System.out.println(findFloor(new int[] {4, 6, 10}, -1));
		System.out.println(findFloor(new int[] {1, 3, 5, 7, 9, 11, 13, 15}, 12));
		System.out.println(findFloor(new int[] {1, 3, 5, 7, 9, 11, 13, 15}, 14));
	}

}
