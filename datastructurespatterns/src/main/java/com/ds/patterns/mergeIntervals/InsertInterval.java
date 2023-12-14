package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class InsertInterval {
	
	private static List<Interval> InsertAndMerge(List<Interval> intervalList, Interval interval){
		
		if(Objects.isNull(interval)) {
			return intervalList;
		}
		
		if(intervalList == null || intervalList.isEmpty()) {
			return Arrays.asList(interval);
		}
				
		List<Interval> mergedIntervals = new ArrayList<>();
		
		int i = 0;
		
		while(i < intervalList.size()  && intervalList.get(i).getEnd() < interval.getStart()) {
			mergedIntervals.add(new Interval(intervalList.get(i).getStart(), intervalList.get(i).getEnd()));
			i++;
		}
		
		while(i < intervalList.size()  && intervalList.get(i).getStart() <= interval.getEnd()) {
			interval.setStart(Math.min(intervalList.get(i).getStart(), interval.getStart()));
			interval.setEnd(Math.max(intervalList.get(i).getEnd(), interval.getEnd()));
			i++;
		}
		
		mergedIntervals.add(new Interval(interval.getStart(), interval.getEnd()));
		
		while(i < intervalList.size()) {
			mergedIntervals.add(new Interval(intervalList.get(i).getStart(), intervalList.get(i).getEnd()));
			i++;
		}
		
		return mergedIntervals;
	}
	
	public static void main(String[] args) {
		
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");		
		for(Interval interval : InsertInterval.InsertAndMerge(input, new Interval(4, 6))) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");
		
		for(Interval interval : InsertInterval.InsertAndMerge(input, new Interval(4, 10))) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
		System.out.print("Merged Intervals : ");
		
		for(Interval interval : InsertInterval.InsertAndMerge(input, new Interval(1, 4))) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		
	}

}
