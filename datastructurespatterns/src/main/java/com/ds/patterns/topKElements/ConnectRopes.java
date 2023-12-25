package com.ds.patterns.topKElements;

import java.util.PriorityQueue;

public class ConnectRopes {
	
	private static int connect(int[] nums) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
		
		for(int i=0; i < nums.length; i++) {
			minHeap.add(nums[i]);
		}
		
		int result = 0;
		int temp = 0;
		
		while(minHeap.size() > 1) {
			temp  = minHeap.poll() + minHeap.poll();		
			result += temp;
			
			System.out.println("temp - "+temp+" result - "+result);
			
			minHeap.add(temp);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		System.out.println("output - "+connect(new int[] {1, 3, 11, 5} ));
		System.out.println("output - "+connect(new int[] {3, 4, 5, 6} ));
		System.out.println("output - "+connect(new int[] {1, 3, 11, 5, 2} ));
	}
}