package com.ds.patterns.topKElements;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {
	
	int[] numbers;
	int k;
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);  
	
	public KthLargestNumberInStream(int[] numbers, int k) {
		this.numbers = numbers;
		this.k = k;
		
		for(int i=0; i < numbers.length; i++) {
			add(numbers[i])	;
		}
	}
	
	public int add(int num) {		
		minHeap.add(num);
		
		if(minHeap.size() > this.k)
			minHeap.poll();
				
		return minHeap.peek();
	}
		
	public static void main(String[] args) {
		KthLargestNumberInStream kthlargestNumberInStream = new KthLargestNumberInStream(new int[] {12, 11, 5, 3, 2, 1}, 4);
		
		System.out.println(kthlargestNumberInStream.add(6));
		System.out.println(kthlargestNumberInStream.add(12));
		System.out.println(kthlargestNumberInStream.add(4));
		
		
	}

}
