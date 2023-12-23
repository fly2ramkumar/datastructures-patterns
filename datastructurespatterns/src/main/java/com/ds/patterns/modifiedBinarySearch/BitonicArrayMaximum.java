package com.ds.patterns.modifiedBinarySearch;

public class BitonicArrayMaximum {
	
	public static int findMaximum(int[] inputArray) {
		
		
		int start = 0;
		int end = inputArray.length - 1;
		
		while(start < end) {
			
			System.out.println("start - "+start+" : end - "+end);
			
			int middle = start + (end - start) / 2;
			
			if(inputArray[middle] > inputArray[middle + 1]) {
				end = middle;
			}else {
				start = middle + 1;
			}
			
		}
		
		return inputArray[start];
	}
	
	public static void main(String[] args) {
		System.out.println(findMaximum(new int[] {1, 3, 8, 12}));
	}

}
