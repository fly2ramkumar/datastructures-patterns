package com.ds.patterns.twopointers;

import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {

	private static int[] findPairWithTargetSum(int[] arr, int targetSum) {

		int left = 0, right = arr.length - 1;

		while (left < right) {
			
			int currentSum = arr[left] + arr[right];

			if (targetSum == currentSum) {
				return new int[] { left, right };
			}

			if (targetSum > currentSum) {
				left++;
			}

			if (targetSum < currentSum) {
				right--;
			}

		}

		return new int[] {-1, -1};
	}
	
	private static int[] findPairWithTargetSumAlternate(int[] arr, int targetSum) {

		Map<Integer, Integer> nums = new HashMap<>();
		
		for(int i=0; i< arr.length; i++) {
			
			if(nums.containsKey(targetSum - arr[i])) {
				return new int[] {nums.get(targetSum - arr[i]), i};
			}
			
			nums.put(arr[i], i);
		}
		
		return new int[] {-1, -1};
	}

	
	public static void main(String[] args) {
		int result[] = PairWithTargetSum.findPairWithTargetSum(new int[] {1,2,3,4,6}, 6);
		System.out.println(result[0]+" : "+result[1]);
		
		int result1[] = PairWithTargetSum.findPairWithTargetSumAlternate(new int[] {1,2,3,4,6}, 6);
		System.out.println(result1[0]+" : "+result1[1]);
	}
}
