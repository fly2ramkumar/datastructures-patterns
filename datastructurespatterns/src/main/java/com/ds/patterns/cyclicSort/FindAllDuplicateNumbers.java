package com.ds.patterns.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicateNumbers {

	private static Set<Integer> find(int[] nums) {

		int i = 0;
		Set<Integer> duplicateNumberSet = new HashSet<>();

		while (i < nums.length) {

			if (nums[i] != i + 1) {

				if (nums[i] != nums[nums[i] - 1]) {
					swap(nums, i, nums[i] - 1);
				} else {
					duplicateNumberSet.add(nums[i]);
					i++;
				}

			} else {
				i++;
			}
		}

		return duplicateNumberSet;
	}

	private static List<Integer> findGrokking(int[] nums) {

		int i = 0;

		while (i < nums.length) {

			if (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}

		}
		
		List<Integer> duplicateNumbers = new ArrayList<>();
		
		for(i=0; i < nums.length; i++) {
			System.out.println(nums[i]);
			if(nums[i] !=  i+1) {
				duplicateNumbers.add(nums[i]);
			}
		}

		return duplicateNumbers;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 4, 4, 5, 5 };
		System.out.println(FindAllDuplicateNumbers.findGrokking(arr).toString());

		arr = new int[] { 5, 4, 7, 2, 3, 5, 3 };
		System.out.println(FindAllDuplicateNumbers.findGrokking(arr).toString());

	}

}
