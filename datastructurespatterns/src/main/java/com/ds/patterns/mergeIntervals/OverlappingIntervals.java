package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OverlappingIntervals {
	
	private static boolean isOverlap(List<Interval> intervals){
		
		if(intervals.size() < 2) {
			return false;
		}
			
		Collections.sort(intervals,  (a, b) -> Integer.compare(a.start, b.start) );
		
		
		Iterator<Interval> intervalIterator= intervals.iterator();
		Interval interval = intervalIterator.next();
		int end = interval.end;
		
		while(intervalIterator.hasNext()) {
			interval = intervalIterator.next();
			
			//System.out.println("start - "+start+" . end - "+end);
			
			if(interval.start < end) {
				return true;
				
			}
			
			end = interval.end;
		}
		
		return false;
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
		
		System.out.println("is Overlap "+OverlappingIntervals.isOverlap(input));		
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
		System.out.println("is Overlap "+OverlappingIntervals.isOverlap(input));
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
		System.out.println("is Overlap "+OverlappingIntervals.isOverlap(input));
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 9));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println("is Overlap "+OverlappingIntervals.isOverlap(input));
		System.out.println();
		
		
	}

}
