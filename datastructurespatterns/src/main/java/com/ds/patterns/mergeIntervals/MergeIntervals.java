package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
	
	
	private static List<Interval> merge(List<Interval> intervals){
		
		if(intervals.size() < 2) {
			return intervals;
		}
			
		Collections.sort(intervals,  (a, b) -> Integer.compare(a.start, b.start) );
		
		List<Interval> mergedIntervals = new ArrayList<>();
		Iterator<Interval> intervalIterator= intervals.iterator();
		Interval interval = intervalIterator.next();
		int start = interval.start;
		int end = interval.end;
		
		while(intervalIterator.hasNext()) {
			
			interval = intervalIterator.next();
			
			//System.out.println("start - "+start+" . end - "+end);
			
			if(interval.start < end) {
				end = Math.max(interval.end, end);
				
			}else {
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		mergedIntervals.add(new Interval(start, end));
		
		return mergedIntervals;
	}
	
	public static void main(String[] args) {
		
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");		
		for(Interval interval : MergeIntervals.merge(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");
		
		for(Interval interval : MergeIntervals.merge(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");
		
		for(Interval interval : MergeIntervals.merge(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
	}

}
