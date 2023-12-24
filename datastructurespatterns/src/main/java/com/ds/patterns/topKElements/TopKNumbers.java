package com.ds.patterns.topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {
	
	private static List<Integer> find(int[] nums, int k){
		
		if(nums == null || nums.length < 1 || k < 1)
			return new ArrayList<>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
		
		for(int i=0; i < k; i++) {
			minHeap.add(nums[i]);
		}
		
		for(int i=k; i< nums.length; i++) {
			if(nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		
		return new ArrayList<Integer>(minHeap);
	}
	
	public static void main(String[] args) {
		System.out.println(TopKNumbers.find(new int[] {3, 1, 5, 12, 2, 11}, 3).toString());
		System.out.println(TopKNumbers.find(new int[] {5, 12, 11, -1, 12}, 3).toString());
	}

}
