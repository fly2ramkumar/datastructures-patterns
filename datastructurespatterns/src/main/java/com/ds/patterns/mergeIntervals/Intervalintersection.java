package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Intervalintersection {

	private static List<Interval> findIntersectionIntervals(List<Interval> listOne, List<Interval> listTwo) {

		if (listOne == null || listOne.isEmpty()) {
			return listTwo;
		}

		if (listTwo == null || listTwo.isEmpty()) {
			return listOne;
		}
		
		List<Interval> intersectionList = new ArrayList<>();

		int firstCount = 0;
		int secondCount = 0;
				
		while(firstCount < listOne.size() && secondCount < listTwo.size()) {
			
			Interval firstinterval = listOne.get(firstCount);
			Interval secondinterval = listTwo.get(secondCount);
			
			if((firstinterval.getStart() >= secondinterval.getStart() && firstinterval.getStart() <= secondinterval.getEnd())
					|| (secondinterval.getStart() >= firstinterval.getStart() && secondinterval.getStart() <= firstinterval.getEnd())){
				
				int start = Math.max(firstinterval.getStart(), secondinterval.getStart());
				int end = Math.min(firstinterval.getEnd(), secondinterval.getEnd());
				
				intersectionList.add(new Interval(start, end));
				
			}

			if(firstinterval.getEnd() < secondinterval.getEnd()) {
				firstCount++;
			}else {
				secondCount++;
			}
			
		}

		return intersectionList;
	}

	public static void main(String[] args) {

		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 6));
		input.add(new Interval(7, 9));
		
		List<Interval> input1 = new ArrayList<>();
		input1.add(new Interval(2, 3));
		input1.add(new Interval(5, 7));

		System.out.print("Intersected Intervals : ");
		for (Interval interval : Intervalintersection.findIntersectionIntervals(input, input1)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		System.out.println();

		input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(9, 12));

		input1 = new ArrayList<>();
		input1.add(new Interval(5, 10));
		
		System.out.print("Intersected Intervals : ");

		for (Interval interval : Intervalintersection.findIntersectionIntervals(input, input1)) {
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		}
		System.out.println();
		System.out.println();

	}

}
