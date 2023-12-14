package com.ds.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {
	
	private static int findTripletSumCloseToTarget(int[] arr, int targetSum) {
		
		List<List<Integer>> allTripletsList = new ArrayList<>();
		Arrays.sort(arr);
		
		int closestSum = Integer.MAX_VALUE;
		
		for(int i=0; i < arr.length - 2; i++) {
			
			if(i> 0 && arr[i] == arr[i-1]) {
				continue;
			}
			
			int left = i+1;
			int right = arr.length - 1;
			
			while(left < right) {
				
				int currentSum = arr[i] + arr[left] + arr[right];
				
				if(currentSum == targetSum) {
					return currentSum;
				}
				
				if(Math.abs(targetSum-currentSum) < Math.abs(targetSum-closestSum)) {
					closestSum = currentSum;
				}
				
				if(currentSum < targetSum) {
					left++;
				}else {
					right--;
				}
				
				
			}
		}
		
		return closestSum;
}
	
	
	
	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.findTripletSumCloseToTarget(new int[] {-2, 0, 1, 2}, 2));
	}

}
