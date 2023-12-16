package com.ds.patterns.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindKMissingPositiveNumbers {

	private static List<Integer> find(int[] nums, int k) {
		int i = 0;
		
		List<Integer> missingNumbers = new ArrayList<>();
		
		int maximumNum = 0;

		while (i < nums.length) {
			
			maximumNum = Integer.max(maximumNum, nums[i]);

			if (nums[i] < 1 || nums[i] > nums.length) {
				i++;
				continue;
			}

			if (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}

		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				if(missingNumbers.size() < k) {
					missingNumbers.add(i+1);
				}
				
			}
		}
		
		while(missingNumbers.size() < k) {
			missingNumbers.add(maximumNum+1);
			maximumNum++;
		}

		return missingNumbers;
	}
	
	private static List<Integer> findGrokking(int[] nums, int k) {
		int i = 0;

		while (i < nums.length) {			
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		
		List<Integer> missingNumbers = new ArrayList<>();
		Set<Integer> additionalNumbers = new HashSet<>();

		for (i = 0; i < nums.length && missingNumbers.size() < k; i++) {
			if (nums[i] != i + 1) {
				missingNumbers.add(i+1);
				additionalNumbers.add(nums[i]);
			}
		}
		
		for(i=1; missingNumbers.size() < k; i++ ) {
			int currentNum = i + nums.length;
			if(!additionalNumbers.contains(currentNum)) {
				missingNumbers.add(currentNum);
			}
		}

		return missingNumbers;
	}
	

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 3, -1, 4, 5, 5 };
		System.out.println(FindKMissingPositiveNumbers.findGrokking(arr, 3).toString());

		arr = new int[] { 2, 3, 4 };
		System.out.println(FindKMissingPositiveNumbers.findGrokking(arr, 3).toString());

		arr = new int[] { -2, -3, 4 };
		System.out.println(FindKMissingPositiveNumbers.findGrokking(arr, 2).toString());

	}

}
