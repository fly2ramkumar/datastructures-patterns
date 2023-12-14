package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class MinimumMeetingRooms {
	
	private static int findMinimumMeetingRooms(List<Interval> intervalList) {
		
		if(intervalList == null || intervalList.isEmpty()) {
			return 0;
		}
		
		if(intervalList.size() == 1) {
			return 1;
		}
		
		intervalList = intervalList.stream()
			.sorted(Comparator.comparing(Interval::getStart)
				.thenComparing(Interval::getEnd))
			.collect(Collectors.toList());
		
		
	
		System.out.print("Sorted : ");		
		for(Interval interval : intervalList) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		
		int minCount = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(intervalList.get(0).getEnd());
		
		for(int i=1; i< intervalList.size(); i++) {                         
			
			if(intervalList.get(i).getStart() < queue.peek()) {
				queue.add(intervalList.get(i).getEnd());
			} else {
				queue.remove();
				queue.add(intervalList.get(i).getEnd());
			}
		}
		
		return queue.size();
	}
	
	private static int findMinimumMeetingRoomsGrokking(List<Interval> intervalList) {
		
		if(intervalList == null || intervalList.isEmpty()) {
			return 0;
		}
		
		if(intervalList.size() == 1) {
			return 1;
		}
		
		int minRooms = 0;
		Collections.sort(intervalList, (a,b) -> Integer.compare(a.getStart(), b.getStart()));
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervalList.size(), (a,b) -> Integer.compare(a.getEnd(), b.getEnd()));				
				
		for(Interval interval : intervalList) {
			
			System.out.println("start - "+interval.getStart()+" end - "+interval.getEnd()+ " minHeap size - "+minHeap.size());
			
			while(!minHeap.isEmpty() && interval.getStart() >= minHeap.peek().getEnd()) {
				minHeap.poll();
			}
			
			minHeap.offer(interval);
			minRooms = Math.max(minRooms, minHeap.size());
		}
		
		return minRooms;
	}
	
	public static void main(String[] args) {
		/*List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.println("Minimum meeting rooms - "+MinimumMeetingRooms.findMinimumMeetingRoomsGrokking(input));		
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(8, 12));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}

		System.out.println();
		System.out.println("Minimum meeting rooms -  "+MinimumMeetingRooms.findMinimumMeetingRoomsGrokking(input));
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 3));
		input.add(new Interval(3, 6));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}

		System.out.println();
		System.out.println("Minimum meeting rooms -  "+MinimumMeetingRooms.findMinimumMeetingRoomsGrokking(input));
		System.out.println();*/
		
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(4, 5));
		input.add(new Interval(2, 4));
		input.add(new Interval(2, 3));		
		input.add(new Interval(3, 5));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}

		System.out.println();
		System.out.println("Minimum meeting rooms -  "+MinimumMeetingRooms.findMinimumMeetingRoomsGrokking(input));
		System.out.println();
	}


}
