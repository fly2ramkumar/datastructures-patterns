package com.ds.patterns.twopointers;

public class RemoveDuplicates {
	
	private static int removeDuplicates(int[] arr) {
		
		int nextNonDuplicateNumber =  1;
		
		for(int i=1; i< arr.length; i++) {
			
			System.out.println("arr[nextNonDuplicateNumber] - "+arr[nextNonDuplicateNumber]+" : arr[i] - "+arr[i]);
			
			if(arr[nextNonDuplicateNumber - 1] != arr[i]) {
				arr[nextNonDuplicateNumber] = arr[i];
				nextNonDuplicateNumber++;
			}
		}
		return nextNonDuplicateNumber;
	}
	
	public static void main(String[] args) {
		System.out.println(RemoveDuplicates.removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9}));
	}

}
