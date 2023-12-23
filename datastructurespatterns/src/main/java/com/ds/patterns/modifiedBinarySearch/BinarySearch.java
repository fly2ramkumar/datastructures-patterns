package com.ds.patterns.modifiedBinarySearch;

public class BinarySearch {
	
	private static int search(int[] inputArray, int key) {
		
		int start = 0;
		int end = inputArray.length - 1;
		
		boolean isAscending = inputArray[start] < inputArray[end];
		
		while(start <= end) {
			
			int middle = start + (end-start) / 2;
			
			if(key == inputArray[middle]) {
				return middle;
			}
			
			if(isAscending) {
				
				if(key < inputArray[middle]) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
				
			}else {
				
				if(key < inputArray[middle]) {
					start = middle + 1;
				} else {
					end = middle - 1;
				}
				
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[] {4, 6, 10}, 10));
		System.out.println(search(new int[] {1, 2, 3, 4, 5, 6, 7}, 5));
		System.out.println(search(new int[] {10, 6, 4}, 10));
		System.out.println(search(new int[] {10, 6, 4}, 4));
	}
	

}
