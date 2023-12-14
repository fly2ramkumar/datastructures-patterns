package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPULoad {
	
	private static int findMaximumCPULoad(List<CPULoad> cpuLoadList) {
		
		if(cpuLoadList == null || cpuLoadList.isEmpty()) {
			return 0;
		}
		
		if(cpuLoadList.size() == 1) {
			return cpuLoadList.get(0).getCpu();
		}
		
		int maxCPULoad = 0;
		
		Collections.sort(cpuLoadList, (a,b) -> Integer.compare(a.getStart(), b.getStart()));
		
		Iterator<CPULoad> cpuLoadIterator = cpuLoadList.iterator();
		CPULoad cpuLoad = cpuLoadIterator.next();
		int end = cpuLoad.getEnd();
		int cpu = cpuLoad.getCpu();
		
		while(cpuLoadIterator.hasNext()) {
			
			cpuLoad = cpuLoadIterator.next();
			
			if(cpuLoad.getStart() <= end) {
				cpu = cpu + cpuLoad.getCpu();
			}else {
				cpu = cpuLoad.getCpu();
			}
			
			maxCPULoad = Integer.max(maxCPULoad, cpu);
			
		}
		
		return maxCPULoad;
	}
	
	
	private static int findMaximumCPULoadGrokking(List<CPULoad> cpuLoadList) {
		
		if(cpuLoadList == null || cpuLoadList.isEmpty()) {
			return 0;
		}
		
		if(cpuLoadList.size() == 1) {
			return cpuLoadList.get(0).getCpu();
		}
				
		Collections.sort(cpuLoadList, (a,b) -> Integer.compare(a.getStart(), b.getStart()));
		
		int maxCPULoad = 0;
		int currentCPULoad = 0;
		
		PriorityQueue<CPULoad> minHeap = new PriorityQueue<CPULoad>(cpuLoadList.size(), (a,b) -> Integer.compare(a.end, b.end)); 
		
		for(CPULoad cpuLoad : cpuLoadList) {
	
			while(!minHeap.isEmpty() && cpuLoad.getStart() > minHeap.peek().getEnd()) {
				currentCPULoad -= minHeap.poll().getCpu();
			}
			
			minHeap.offer(cpuLoad);
			currentCPULoad += cpuLoad.getCpu();
			maxCPULoad = Integer.max(maxCPULoad, currentCPULoad);
			
		}
				
		return maxCPULoad;
	}
	
	public static void main(String[] args) {
		List<CPULoad> input = new ArrayList<>();
		input.add(new CPULoad(1, 4, 3));
		input.add(new CPULoad(2, 5, 4));
		input.add(new CPULoad(7, 9, 6));
		
		System.out.print("Input : ");		
		for(CPULoad cpuLoad : input) {
			System.out.print("[" + cpuLoad.start+","+cpuLoad.end+","+cpuLoad.cpu+"] ");
		}
		System.out.println();
		
		System.out.println("Maximum CPU Load - "+MaximumCPULoad.findMaximumCPULoadGrokking(input));		
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new CPULoad(6, 7, 10));
		input.add(new CPULoad(2, 4, 11));
		input.add(new CPULoad(8, 12, 15));
		
		System.out.print("Input : ");		
		for(CPULoad cpuLoad : input) {
			System.out.print("[" + cpuLoad.start+","+cpuLoad.end+","+cpuLoad.cpu+"] ");
		}
		System.out.println();

		System.out.println("Maximum CPU Load -  "+MaximumCPULoad.findMaximumCPULoadGrokking(input));
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new CPULoad(1, 4, 2));
		input.add(new CPULoad(2, 4, 1));
		input.add(new CPULoad(3, 6, 5));
		
		System.out.print("Input : ");		
		for(CPULoad cpuLoad : input) {
			System.out.print("[" + cpuLoad.start+","+cpuLoad.end+","+cpuLoad.cpu+"] ");
		}
		System.out.println();

		System.out.println("Maximum CPU Load -  "+MaximumCPULoad.findMaximumCPULoadGrokking(input));
		System.out.println();
		
	}

	
	

}
