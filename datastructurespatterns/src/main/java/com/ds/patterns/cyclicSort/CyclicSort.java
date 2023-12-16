package com.ds.patterns.cyclicSort;

import java.util.Arrays;

public class CyclicSort {
	
	private static void sort(int[] nums) {
		
		int i = 0;
		
		while(i < nums.length) {
			int j = nums[i] - 1;
			
			if(nums[i] != nums[j]) {
				swap(nums, i, j);
			} else {
				i++;
			}
			
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{3, 1, 5, 4, 2};
		CyclicSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[]{2, 6, 4, 3, 1, 5};
		CyclicSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[]{1, 5, 6, 4, 3, 2};
		CyclicSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	
	}

}
