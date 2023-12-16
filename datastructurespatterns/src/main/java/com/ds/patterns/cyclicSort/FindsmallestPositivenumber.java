package com.ds.patterns.cyclicSort;

public class FindsmallestPositivenumber {

	private static int find(int[] nums) {
		int i = 0;

		while (i < nums.length) {
			
			if(nums[i] < 1 || nums[i] > nums.length) {
				i++;
				continue;
			}
			
			if (nums[i] != nums[nums[i] - 1]) {
					swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		
		for(i=0; i< nums.length; i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		
		return -1;
	}
	
	

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { -3, 1, 5, 4, 2 };
		System.out.println(FindsmallestPositivenumber.find(arr));

		arr = new int[] { 3, -2, 0, 1, 2 };
		System.out.println(FindsmallestPositivenumber.find(arr));

		arr = new int[] { 3, 2, 5, 1 };
		System.out.println(FindsmallestPositivenumber.find(arr));

	}

}
