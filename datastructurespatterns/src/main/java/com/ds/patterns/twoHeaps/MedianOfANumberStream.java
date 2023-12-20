package com.ds.patterns.twoHeaps;

import java.util.PriorityQueue;

public class MedianOfANumberStream {
	
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;
	
	public MedianOfANumberStream() {
		maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
		minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
	}
	
	private void insertNum(int num) {
		
		if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		}else {
			minHeap.add(num);
		}
		
		if(maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
			
		} else if(maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
		
		System.out.println("Inserted "+num);
		
	}
	
	private double findMedian() {
		if(maxHeap.size() == minHeap.size())
			return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
		
		return maxHeap.peek();
	}
	
	public static void main(String[] args) {
		MedianOfANumberStream medianOfANumberStream = new MedianOfANumberStream();
		medianOfANumberStream.insertNum(3);
		medianOfANumberStream.insertNum(1);
		System.out.println("Median - "+medianOfANumberStream.findMedian());
		medianOfANumberStream.insertNum(5);
		System.out.println("Median - "+medianOfANumberStream.findMedian());
		medianOfANumberStream.insertNum(4);
		System.out.println("Median - "+medianOfANumberStream.findMedian());
	}

}
