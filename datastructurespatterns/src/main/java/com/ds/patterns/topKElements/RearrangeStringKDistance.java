package com.ds.patterns.topKElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class RearrangeStringKDistance {
	
	private static String rearrange(String str, int k) {
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for(int i=0; i< str.length(); i++) {
			frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
		}
		
		StringBuilder resultString = new StringBuilder();		
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue() );
		maxHeap.addAll(frequencyMap.entrySet());
		
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		
		while(!maxHeap.isEmpty()) {			
			Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
			resultString.append(currentEntry.getKey());
			currentEntry.setValue(currentEntry.getValue() - 1);
			
			queue.offer(currentEntry);
			
			if(queue.size() == k) {
				Map.Entry<Character, Integer> entry = queue.poll();
				if(entry.getValue() > 0)
					maxHeap.add(entry);
			}
		}
		
		return resultString.length() == str.length() ? resultString.toString() : "";
		
	}
	
	public static void main(String[] args) {
		System.out.println(rearrange("mmpp", 2));
		System.out.println(rearrange("Programming", 3));
		System.out.println(rearrange("aab", 2));
		System.out.println(rearrange("aappa", 3));
	}

}
