package com.ds.patterns.topKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SchedulingTasks {
	
	private static int scheduleTasks(char[] tasks, int k) {
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for(int i=0; i< tasks.length; i++)
			frequencyMap.put(tasks[i], frequencyMap.getOrDefault(tasks[i], 0) + 1);
		
		System.out.println("frequencyMap -- "+frequencyMap.toString());
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
		maxHeap.addAll(frequencyMap.entrySet());
		
		
		
		int intervalCount = 0;
		
		while(!maxHeap.isEmpty()) {	
			System.out.println(" --------- Iteration starts --------- ");
			int n = k + 1;
			List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
			
			for(; n > 0 && !maxHeap.isEmpty(); n--) {
				intervalCount++;
				
				Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
				
				System.out.println("before - currentEntry -- "+currentEntry.toString()+" intervalCount - "+intervalCount);
				
				if(currentEntry.getValue() > 1) {
					currentEntry.setValue(currentEntry.getValue() - 1);
					waitList.add(currentEntry);
				}
				System.out.println("after - currentEntry -- "+currentEntry.toString()+" waitList - "+waitList.toString());
				System.out.println();
				
			}
			
			System.out.println("waitList -- "+waitList.toString());
			
			maxHeap.addAll(waitList);
			
			if(!maxHeap.isEmpty())
				intervalCount += n;
			
			System.out.println(" --------- Iteration ends --------- intervalCount -  "+intervalCount);
			System.out.println();
		}
		
		return intervalCount;
	}
	
	public static void main(String[] args) {
		System.out.println(scheduleTasks(new char[] {'a', 'a', 'a', 'b', 'c', 'c'}, 2));
		System.out.println(scheduleTasks(new char[] {'a', 'b', 'a'}, 3));
	}

}
