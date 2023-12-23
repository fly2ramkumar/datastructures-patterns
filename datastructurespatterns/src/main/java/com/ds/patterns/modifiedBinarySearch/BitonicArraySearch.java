package com.ds.patterns.modifiedBinarySearch;

public class BitonicArraySearch {
	
	private static int search(int[] inputArray, int key) {
		
		int maxIndex = findMaximumindex(inputArray);
		//System.out.println("maxIndex -- "+maxIndex);
		
		int start = 0;
		int end = maxIndex;
		int result = searchEachHalf(inputArray, key, start, end);
		if(result != -1) {
			return result;
		}
		
		start = maxIndex + 1;
		end = inputArray.length - 1;
		
		return searchEachHalf(inputArray, key, start, end);
	}	
	
	public static int findMaximumindex(int[] inputArray) {
		int start = 0;
		int end = inputArray.length - 1;
		
		while(start < end) {
			int middle = start + (end - start) / 2;
			
			if(inputArray[middle] > inputArray[middle + 1]) {
				end = middle;
			}else {
				start = middle + 1;
			}			
		}

		return start;
	}
	
	private static int searchEachHalf(int[] inputArray, int key, int start, int end) {

		while(start <= end) {
			//System.out.println("start - "+start+" : end - "+end);
			int middle = start + (end - start) / 2;
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			} else if(key < inputArray[middle]) {
				end = middle -1;
			} else {
				//System.out.println("Inside actual  val - "+middle);
				return middle;
			}			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("Output 1 - "+search(new int[] {1, 3, 8, 4, 3}, 4));
		System.out.println("Output 2 - "+search(new int[] {3, 8, 3, 1}, 8));
		System.out.println("Output 3 - "+search(new int[] {1, 3, 8, 12}, 12));
		System.out.println("Output 4 - "+search(new int[] {10, 9, 8}, 10));
	}

}
