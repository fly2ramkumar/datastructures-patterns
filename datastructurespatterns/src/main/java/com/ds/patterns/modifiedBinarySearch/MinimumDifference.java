package com.ds.patterns.modifiedBinarySearch;

public class MinimumDifference {
	
	private static int find(int[] inputArray, int key) {
		
		int start = 0;
		int end = inputArray.length - 1;
		
		if(key < inputArray[start])
			return inputArray[start];
		
		if(key > inputArray[end]) {
			return inputArray[end];
		}
		
		while(start <= end) {
			int middle = start + (end - start) / 2;
			
			if(key == inputArray[middle])
				return inputArray[middle];
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			}else {
				end = middle - 1;
			}
			
		}
		
		//System.out.println(start+" : "+end);
		
		int startDiff = Math.abs(inputArray[start]- key);
		int endDiff = Math.abs(key - inputArray[end]);
		
		//System.out.println(startDiff+" : "+endDiff);
		
		if(endDiff < startDiff)
			return inputArray[end];
		
		return inputArray[start];
	}
	
	public static void main(String[] args) {
		System.out.println(find(new int[] {4, 6, 10}, 7));
		System.out.println(find(new int[] {4, 6, 10}, 4));
		System.out.println(find(new int[] {1, 3, 8, 10, 15}, 12));
		System.out.println(find(new int[] {4, 6, 10}, 17));

	}

}
