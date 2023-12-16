package com.ds.patterns.cyclicSort;

import java.util.Arrays;

public class FindMissingNumbers {
	
	private static int findMissingNumber(int[] nums) {
		
		int i = 0;
		int missingIndex = -1;
		
		while(i < nums.length) {
			
			if(nums[i] == 0) {
				missingIndex = i;
				i++;
				continue;
			}
			
			int j = nums[i] - 1;
			
			if(nums[i] != nums[j]) {
				swap(nums, i, j);
			} else {
				i++;
			}
			
		}
		
		if(missingIndex == -1) {
			return missingIndex;
		}
		
		return missingIndex+1;
	}
	
	private static int findMissingNumberGrokking(int[] nums) {
		
		int i = 0;
		while( i < nums.length) {
			int j = nums[i];
			
			if( nums[i] < nums.length && nums[i] != nums[j]) {
				swap(nums, i, j);
			}else {
				i++;
			}
		}
		
		for(i=0; i< nums.length; i++) {
			if(i != nums[i]) {
				return i;
			}
		}
		
		return nums.length;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{4, 0, 3, 1};
		System.out.println(FindMissingNumbers.findMissingNumberGrokking(arr));
		
		arr = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
		System.out.println(FindMissingNumbers.findMissingNumberGrokking(arr));
		
		arr = new int[]{1, 5, 6, 4, 3, 2};
		System.out.println(FindMissingNumbers.findMissingNumberGrokking(arr));
	
	}

}
