package com.ds.patterns.topKElements;

import java.util.PriorityQueue;

public class SumOfElements {
	
	private static int findSum(int[] nums, int k1, int k2) {
		
		if(k1 < 0 || k2 < 0 || k1  > nums.length || k2 > nums.length || k1 > k2)
			return 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
		
		int noOfElements = nums.length - k1;
		
		for(int i=0; i < noOfElements; i++) {
			minHeap.add(nums[i]);
		}
		
		for(int i=noOfElements; i < nums.length; i++) {
			
			if(nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		
		int sum = 0;
		while( k2 - k1 -1  > 0 && !minHeap.isEmpty()) {
			System.out.println("minHeap.peek - "+minHeap.peek());
			sum = sum + minHeap.poll();
			k2--;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(SumOfElements.findSum(new int[] {1, 3, 12, 5, 15, 11}, 3, 6));
		System.out.println(SumOfElements.findSum(new int[] {3, 5, 8, 7}, 1, 4));
	}

}
