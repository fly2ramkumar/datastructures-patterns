package com.ds.patterns.twopointers;

import java.util.Arrays;

public class TripletWithMinimumSum {
	
	private static int findTripletsCount(int[] arr, int targetSum) {
		
		int tripletSum = 0;
		Arrays.sort(arr);
		
		for(int i=0; i< arr.length-2; i++) {
			
			int left = i+1; int right = arr.length - 1;
			
			//int sum = arr[i] + arr[left] + arr[right];
			
			while((arr[i] + arr[left] + arr[right]) > targetSum) {
				right--;
			}
			
			System.out.println("arr[i] - "+arr[i]+" arr[left] - "+arr[left]+" arr[right] - "+arr[right]);
			while(left < right) {
				for(int j=right; j >left; j--) {
					
					int sum = arr[i] + arr[left] + arr[j];
					System.out.println("arr[i] - "+arr[i]+" arr[left] - "+arr[left]+" arr[j] - "+arr[j]+" sum - "+sum);
					if(sum < targetSum) {
						tripletSum++;
					}
				}
				left++;
			}
			
			System.out.println();
		}
		
		return tripletSum;
	}

	public static void main(String[] args) {
		System.out.println(TripletWithMinimumSum.findTripletsCount(new int[] {-1, 4, 2, 1, 3}, 5));
		System.out.println(TripletWithMinimumSum.findTripletsCount(new int[] {-1, 0, 2, 3}, 3));
	}
}
