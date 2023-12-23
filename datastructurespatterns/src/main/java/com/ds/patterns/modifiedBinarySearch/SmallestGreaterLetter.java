package com.ds.patterns.modifiedBinarySearch;

public class SmallestGreaterLetter {
	
	private static char find(char[] inputArray, char key) {
		
		int start = 0;
		int end = inputArray.length - 1;
		
		if(key < inputArray[start] || key >= inputArray[end])
			return inputArray[start];
		
		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(key == inputArray[middle])
				return inputArray[middle + 1];
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			}else {
				end = middle - 1;
			}
		}
		
		return inputArray[start];
	}

	public static void main(String[] args) {
		System.out.println(find(new char[] {'a', 'c', 'f', 'h'}, 'f'));
		System.out.println(find(new char[] {'a', 'c', 'f', 'h'}, 'b'));
		System.out.println(find(new char[] {'a', 'c', 'f', 'h'}, 'm'));
		System.out.println(find(new char[] {'a', 'c', 'f', 'h'}, 'h'));
	}
}
