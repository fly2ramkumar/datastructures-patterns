package com.ds.patterns.cyclicSort;

import java.util.Arrays;

public class FindCorruptPair {
	
	private static int[] find(int[] nums) {
		
		int i = 0;
		
		while(i < nums.length) {
			if(nums[i] != nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			} else {
				i++;
			}
		}
		
		for(i=0; i<nums.length;i++) {
			
			if(nums[i] != i+1) {
				return new int[] {nums[i], i+1};
			}
		}
		
		return new int[] {};
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{3, 1, 2, 5, 2};
		System.out.println(Arrays.toString(FindCorruptPair.find(arr)));
		
		arr = new int[]{3, 1, 2, 3, 6, 4};
		System.out.println(Arrays.toString(FindCorruptPair.find(arr)));
		
	
	}

}
