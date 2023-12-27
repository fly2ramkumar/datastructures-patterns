package com.ds.patterns.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
	
	private static int findMaximum(int[] nums, int k) {
		
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for(int i=0; i< nums.length; i++) {
			frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
		}
		
		int maxDistinctElement = 0;
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>((e1, e2) -> e1.getValue() - e2.getValue());
		
		for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if(entry.getValue() == 1) {
				maxDistinctElement++;
			}else {
				minHeap.add(entry);
			}
		}
		
		while(!minHeap.isEmpty() && k > 0) {
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			k -= entry.getValue() - 1;
			
			if(k >= 0)
				maxDistinctElement++;
		}
		
		if(k > 0)
			maxDistinctElement -= k;
		
		return maxDistinctElement;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaximum(new int[] {7, 3, 5, 8, 5, 3, 3}, 2));
		System.out.println(findMaximum(new int[] {3, 5, 12, 11, 12}, 3));
		System.out.println(findMaximum(new int[] {1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2));
	}
	

}
