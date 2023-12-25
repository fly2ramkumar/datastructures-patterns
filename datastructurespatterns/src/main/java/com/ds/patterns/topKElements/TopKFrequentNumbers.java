package com.ds.patterns.topKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
	
	private static List<Integer> findTopK(int[] nums, int k) {
		
		HashMap<Integer, Integer> numFrequencyMap = new HashMap<>();
		for(int i=0; i< nums.length; i++) {
			numFrequencyMap.put(nums[i], numFrequencyMap.getOrDefault(nums[i], 0)+ 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>((e1, e2) -> e1.getValue() - e2.getValue());
		
		for(Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
			minHeap.add(entry);
			
			if(minHeap.size() > k)
				minHeap.poll();
		}
		
		List<Integer> topNumbers = new ArrayList<Integer>(k);
		while(!minHeap.isEmpty()) {
			topNumbers.add(minHeap.poll().getKey());
		}
		
		return topNumbers;
	}
	
	public static void main(String[] args) {
		System.out.println(findTopK(new int[] {1, 3, 5, 12, 11, 12, 11}, 2).toString());
	}

}
