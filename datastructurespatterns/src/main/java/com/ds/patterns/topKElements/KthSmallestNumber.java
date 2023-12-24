package com.ds.patterns.topKElements;

import java.util.PriorityQueue;

public class KthSmallestNumber {
	
	private static int find(int[] nums, int k) {

		if (nums == null || nums.length < 1 || k < 1)
			return -1;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int i = 0; i < nums.length; i++) {
			minHeap.add(nums[i]);
		}

		int count = 0;
		int result = 0;

		while (count < k) {
			result = minHeap.poll();
			count++;
		}

		return result;
	}
	
	private static int findgrokking(int[] nums, int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		
		for(int i=0; i<k; i++) {
			maxHeap.add(nums[i]);
		}
		
		for(int i=k; i < nums.length; i++) {
			if(nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		System.out.println(KthSmallestNumber.findgrokking(new int[] { 1, 5, 12, 2, 11, 5 }, 3));
		System.out.println(KthSmallestNumber.findgrokking(new int[] { 1, 5, 12, 2, 11, 5 }, 4));
		System.out.println(KthSmallestNumber.findgrokking(new int[] { 5, 12, 11, -1, 12 }, 3));
	}

}
