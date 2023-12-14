package com.ds.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindQuadrapleForTarget {
	
	private static List<List<Integer>> findQuadraple(int[] arr, int target){
		
		List<List<Integer>> outputList = new ArrayList<>();
		Arrays.sort(arr);
 		
		for(int i=0; i< arr.length-3; i++) {
			
			if(i>0 && arr[i] == arr[i-1]) {
				continue;
			}
			
			findTriple(arr, i, target, outputList);
		}
		
		return outputList;
	}
	
	private static void findTriple(int[] arr, int quadIndex, int target, List<List<Integer>> outputList){		
		for(int i=quadIndex+1; i< arr.length-2; i++) {
			
			if(i>0 && arr[i] == arr[i-1]) {
				continue;
			}
			
			findTripleForTarget(arr, quadIndex, i, target, outputList);
		}
	}
	
	private static void findTripleForTarget(int[] arr, int quadIndex, int tripleIndex, int target, List<List<Integer>> outputList){	
		
		int left = tripleIndex + 1;
		int right = arr.length-1;
		
		while(left < right) {
			
			int sum = arr[quadIndex] + arr[tripleIndex] + arr[left] + arr[right];
			
			if(sum == target) {
				outputList.add(Arrays.asList(arr[quadIndex], arr[tripleIndex], arr[left], arr[right]));
				left++;
				right--;
				
				while(arr[left] == arr[left-1] && left < right) {
					left++;
				}
				
				while(arr[right] == arr[right+1] && left < right) {
					right--;
				}
				
			}else if (sum > target) {
				right--;
			
			}else {
				left++;
				
			}			
		}		
	}
	
	public static void main(String[] args) {
		System.out.println(FindQuadrapleForTarget.findQuadraple(new int[] {4, 1, 2, -1, 1, -3}, 1));
		System.out.println(FindQuadrapleForTarget.findQuadraple(new int[] {2, 0, -1, 1, -2, 2}, 2));
	}

}
