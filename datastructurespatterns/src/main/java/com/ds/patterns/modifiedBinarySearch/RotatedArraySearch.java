package com.ds.patterns.modifiedBinarySearch;

public class RotatedArraySearch {

	private static int search(int[] inputArray, int key) {

		int start = 0;
		int end = inputArray.length - 1;

		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(inputArray[middle] == key)
				return middle;
			
			if(inputArray[start] <= inputArray[middle]) {
				
				if(key >= inputArray[start] && key < inputArray[middle]) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
				
			} else {
				
				if(key > inputArray[middle] && key <= inputArray[end]) {
					start = middle + 1;
				}else {
					end = middle - 1;
				}
			}
			
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		System.out.println(search(new int[] {10, 15, 1, 3, 8}, 15));
		System.out.println(search(new int[] {4, 5, 7, 9, 10, -1, 2}, 10));
	}
}
