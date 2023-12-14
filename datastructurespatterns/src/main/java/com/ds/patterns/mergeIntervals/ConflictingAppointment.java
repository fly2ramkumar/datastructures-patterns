package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConflictingAppointment {
	
	private static boolean isConflictingAppointments(List<Interval> intervalList) {
		
		Collections.sort(intervalList, (a,b) -> Integer.compare(a.getStart(), b.getStart()));
		
		Iterator<Interval> intervaliterator = intervalList.iterator();
		Interval interval = intervaliterator.next();
		
		int end = interval.getEnd();
		
		while(intervaliterator.hasNext()) {
			
			interval = intervaliterator.next();
			
			if(interval.getStart() < end) {
				System.out.println("interval.getStart() -  "+interval.getStart()+" end - "+end);
				return false;
			}
			
			end = interval.getEnd();
			
		}
		
		return true;
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
		
		System.out.println("is Overlap "+ConflictingAppointment.isConflictingAppointments(input));		
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
		System.out.println("is Overlap "+ConflictingAppointment.isConflictingAppointments(input));
		System.out.println();
		
		input = new ArrayList<>();
		input.add(new Interval(4, 5));
		input.add(new Interval(2, 2));
		input.add(new Interval(3, 6));
		
		System.out.print("Input : ");		
		for(Interval interval : input) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}

		System.out.println();
		System.out.println("is Overlap "+ConflictingAppointment.isConflictingAppointments(input));
		System.out.println();
	}

}
