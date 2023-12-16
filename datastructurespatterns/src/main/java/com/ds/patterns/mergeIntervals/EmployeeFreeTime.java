package com.ds.patterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval{
	Interval interval;
	int employeeIndex;
	int intervalIndex;
	
	public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
		super();
		this.interval = interval;
		this.employeeIndex = employeeIndex;
		this.intervalIndex = intervalIndex;
	}
}

public class EmployeeFreeTime {
	
	private static List<Interval> findEmployeeFreeHours(List<List<Interval>> schedule) {
		
		List<Interval> result = new ArrayList<Interval>();
		
		PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<EmployeeInterval>((a,b) -> Integer.compare(a.interval.start, b.interval.start));
		
		for(int i=0; i< schedule.size(); i++) {
			minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
		}
		
		Interval previousinterval = minHeap.peek().interval;
		
		while(!minHeap.isEmpty()) {
			
			EmployeeInterval queueTop = minHeap.poll();
			
			System.out.println("Previousinterval. start - "+previousinterval.getStart()+" end - "+previousinterval.getEnd());
			System.out.println("queueTop. start - "+queueTop.interval.getStart()+" end - "+queueTop.interval.getEnd());
			
			if(previousinterval.end < queueTop.interval.getStart()) {
				System.out.println("if --- ");
				result.add(new Interval(previousinterval.end, queueTop.interval.getStart()));
				previousinterval = queueTop.interval;
			} else {
				
				if(previousinterval.end < queueTop.interval.end) {
					System.out.println("else if--- ");
					previousinterval = queueTop.interval;
				}			
			}
			
			List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
			if(employeeSchedule.size() > queueTop.intervalIndex+1) {
				System.out.println("Inside minHeap offer");
				minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex+1), queueTop.employeeIndex, queueTop.intervalIndex+1));
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		List<List<Interval>> input = new ArrayList<>();
		input.add(Arrays.asList(new Interval(1, 3), new Interval(9, 12)) );
		input.add(Arrays.asList(new Interval(2, 4), new Interval(6, 8)) );

		System.out.print("Employee Free Hours : ");
		for(Interval interval : EmployeeFreeTime.findEmployeeFreeHours(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		/*input = new ArrayList<>();
		input.add(Arrays.asList(new Interval(1, 3), new Interval(5, 6)) );
		input.add(Arrays.asList(new Interval(2, 3), new Interval(6, 8)) );
		
		System.out.print("Employee Free Hours : ");		
		for(Interval interval : EmployeeFreeTime.findEmployeeFreeHours(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println();
		System.out.println();
		
		input = new ArrayList<>();
		input.add(Arrays.asList(new Interval(1, 3)));
		input.add(Arrays.asList(new Interval(2, 4), new Interval(3, 5), new Interval(7, 9) ));
		
		System.out.print("Employee Free Hours : ");		
		for(Interval interval : EmployeeFreeTime.findEmployeeFreeHours(input)) {
			System.out.print("[" + interval.start+","+interval.end+"] ");
		}
		System.out.println(); */
		
	}

}
