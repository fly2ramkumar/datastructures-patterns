package com.ds.patterns.twopointers;

import java.util.Arrays;

public class SortedSquareArray {
	
	private static int[] calculateSortedSquareArray(int[] arr) {
		
		int[] sqArray = new int[arr.length];
		int left = 0, right = arr.length - 1;
		int highestSquareIdx = arr.length - 1;
		
		while(left < right) {
			
			int leftsquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];
			
			if(leftsquare > rightSquare) {
				sqArray[highestSquareIdx--] = leftsquare;
				left++;
			}else {
				sqArray[highestSquareIdx--] = rightSquare;
				right--;
			}
			
		}
		
		return sqArray;
	}
	
	public static void main(String[] args) {
		
		int[] outArray = SortedSquareArray.calculateSortedSquareArray(new int[] {-2, -1, 0, 3, 4});	
        System.out.println(Arrays.toString(outArray));
        
        outArray = SortedSquareArray.calculateSortedSquareArray(new int[] {-3, -1, 0, 1, 2});		
        System.out.println(Arrays.toString(outArray));

	}
}
