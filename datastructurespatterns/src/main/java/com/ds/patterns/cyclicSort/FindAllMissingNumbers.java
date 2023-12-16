package com.ds.patterns.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumbers {

	private static List<Integer> missingNumbers(int[] nums) {		
		int i = 0;
		List<Integer> results = new ArrayList<>();
		
		while(i < nums.length) {
			int j = nums[i] - 1;
			
			if(nums[i] != nums[j]) {
				swap(nums, i, j);
			} else {
				i++;
			}
		}
		
		for(i=0; i < nums.length; i++) {
			if(nums[i] != i+1) {
				results.add(i+1);
			}
		}
		
		return results;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
		List<Integer> results = FindAllMissingNumbers.missingNumbers(arr);
		System.out.println(results.toString());
		
		arr = new int[]{2, 4, 1, 2};
		results = FindAllMissingNumbers.missingNumbers(arr);
		System.out.println(results.toString());
		
		arr = new int[]{2, 3, 2, 1};
		results = FindAllMissingNumbers.missingNumbers(arr);
		System.out.println(results.toString());
	
	}



}
