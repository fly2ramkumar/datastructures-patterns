package com.ds.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
	
	private static List<List<Integer>> findTipletsSumToZero(int[] arr) {
		
		List<List<Integer>> resultList = new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0; i < arr.length -2; i++) {
			
			if(i > 0 && arr[i] == arr[i-1]) {
				continue;
			}
			
			resultList.addAll(addTripletToList(i+1, -arr[i], arr));
		}
		
		return resultList;
	}
	
	private static List<List<Integer>> addTripletToList(int left, int targetSum, int[] arr) {
		
		List<List<Integer>> resultList = new ArrayList<>();
		int right = arr.length - 1;
		
		
		while(left < right) {
			int currentSum = arr[left] + arr[right];
			
			if(currentSum == targetSum) {
				
				resultList.add(Arrays.asList(-targetSum, arr[left], arr[right]));
				left++;
				right--;
				
				while(left < right && arr[left] == arr[left-1]) {
					left++;
				}
				
				while(left < right && arr[right] == arr[right+1]) {
					right--;
				}
			
			}else if(currentSum < targetSum) {
				left++;
				
			}else {
				right--;
			
			}
		}

		return resultList;
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> resultList = TripletSumToZero.findTipletsSumToZero(new int[] {-3, 0, 1, 2, -1, 1, -2});
		System.out.println(resultList.toString());
	}

}
