package com.ds.patterns.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	private static String sort(String inputStr) {
		
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for(int i=0; i < inputStr.length(); i++){
			charFrequencyMap.put(inputStr.charAt(i), charFrequencyMap.getOrDefault(inputStr.charAt(i), 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
		
		for(Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()){
			maxHeap.add(entry);
		}
		
		StringBuilder result = new StringBuilder();
		
		while(!maxHeap.isEmpty()){
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for(int i=0; i < entry.getValue(); i++){
				result.append(entry.getKey());
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(sort("Programming"));
		System.out.println(sort("abcbab"));
	}
}
