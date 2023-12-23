package com.ds.patterns.modifiedBinarySearch;

import java.util.Arrays;

public class NumberRange {
	
	// Custom implementation
	private static int[] findRangeMatchingwithKey(int[] inputArray, int key) {
		
		int start = 0;
		int end = inputArray.length - 1;
		
		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(inputArray[middle] == key) {
				
				int startPos = middle;
				int endPos = middle;
				
				while(startPos >= start) {
					if(inputArray[startPos -1] == key) {
						startPos -= 1;
					}else {
						break;
					}
				}
				
				while(endPos <= end) {
					if(inputArray[endPos + 1] == key) {
						endPos += 1;
					}else {
						break;
					}
				}
				
				return new int[] {startPos, endPos};
			}
			
			if(key > inputArray[middle]) {
				start = middle + 1;
			}else {
				end = middle - 1;
			}
			
		}
		
		return new int[] {-1, -1};
	}
	
	private static int[] findRange(int[] inputArray, int key) {
		
		int[] result = new int[] {-1, -1};
		
		int startIndex = find(inputArray, key, false);
		if(startIndex != -1) {
			int endIndex = find(inputArray, key, true);
			return new int[] {startIndex, endIndex};
		}
		
		return result;
	}
	
	private static int find(int[] inputArray, int key, boolean isFindMaxIndex) {
		
		int keyIndex = -1;
		int start = 0;
		int end = inputArray.length - 1;
		
		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(key > inputArray[middle]) {
				start = middle + 1;
				
			} else if(key < inputArray[middle]) {
				end = middle - 1;
			
			} else {
				keyIndex = middle;
				
				if(isFindMaxIndex) {
					start = middle + 1;
				}else {
					end = middle - 1;
				}
			}			
		}
		
		return keyIndex;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRange(new int[] {4, 6, 6, 6, 9}, 6)));
		System.out.println(Arrays.toString(findRange(new int[] {1, 3, 8, 10, 15}, 10)));
		System.out.println(Arrays.toString(findRange(new int[] {1, 3, 8, 10, 15}, 12)));
	}

}
