package com.ds.patterns.cyclicSort;

public class FindDuplicateNumber {
	
	private static int find(int[] nums) {
		
		int i = 0;
		
		while(i < nums.length) {
			int j = nums[i] - 1;
						
			if(nums[i] != nums[j]) {
				swap(nums, i, j);
			} else {
				
				if(j != i ) {
					return nums[i];
				}
				
				i++;
			}
		}
				
		return -1;
	}
	
	private static int findGrokking(int[] nums) {
			
		int i = 0;
		
		while(i < nums.length) {
			
			if(nums[i] != i+1) {
				
				if(nums[i] != nums[nums[i]-1]) {
					swap(nums, i, nums[i]-1);
				} else {
					return nums[i];
				}
				
			}else {
				i++;
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
		
		int[] arr = new int[]{1, 4, 4, 3, 2};
		System.out.println(FindDuplicateNumber.findGrokking(arr));
		
		arr = new int[]{2, 1, 3, 3, 5, 4};
		System.out.println(FindDuplicateNumber.findGrokking(arr));
		
		arr = new int[]{2, 4, 1, 4, 4};
		System.out.println(FindDuplicateNumber.findGrokking(arr));
	
	}

}
