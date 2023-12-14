package com.ds.patterns.twopointers;

import java.util.Arrays;

public class DutchNationalFlag {
	
	private static int[] sortInPlace(int[] arr) {
		
		int left = 0; 
		int right = arr.length - 1;
		
		for(int i=0; i< arr.length; i++) {
			
			System.out.println("i ----- "+i);
			
			while(arr[i] == 0 || arr[i] == 2) {
				
				System.out.println("i - "+i+" arr[i] - "+arr[i]+"left - "+left+" right - "+right);
				System.out.println(Arrays.toString(arr));
				
				if(left < right) {
					if(arr[i] == 0) {
						if(i < left) {
							arr[i] = arr[left];
							arr[left] = 0;
							left++;
						}else {
							break;
						}
						
					
					}else {
						if(i < right) {
							arr[i] = arr[right];
							arr[right] = 2;
							right--;
						}else {
							break;
						}
					}	
				}
			}			
		}	
		
		return arr;
	}
	
	private static int[] sortInPlace1(int[] arr) {
		
		int low = 0; 
		int high = arr.length - 1;
		
		for(int i=0; i<=high;) {
			
			if(arr[i] == 0) {
				swap(arr, i, low);
				i++;
				low++;
			}else  if(arr[i] == 1) {
				i++;
				
			} else {
				swap(arr, i, high);
				high--;
			}			
		}
		
		return arr;
	}
	
	private static void swap(int[] arr, int index, int key) {
		int temp = arr[key];
		arr[key] = arr[index];
		arr[index] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(DutchNationalFlag.sortInPlace1(new int[] {1, 0, 2, 1, 0})));
		System.out.println(Arrays.toString(DutchNationalFlag.sortInPlace1(new int[] {2, 2, 0, 1, 2, 0})));
	}
	
}
