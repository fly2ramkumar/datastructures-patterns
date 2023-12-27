package com.ds.patterns.topKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Distance {
	
	int number;
	int distance;
	
	public Distance(int number, int distance) {
		this.number = number;
		this.distance = distance;
	}
	
}

//For Binary search approach
class Entry{
	int key;
	int value;
	
	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class KClosestNumbers {
	 
	// Own implementation. O(NlogN)
	private static List<Integer> find(int[] nums, int k, int x){		
		PriorityQueue<Distance> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);
		
		for(int i=0; i< nums.length; i++) {
			maxHeap.add(new Distance(nums[i], Math.abs(x - nums[i])));
			
			if(maxHeap.size() > k)
				maxHeap.poll();
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!maxHeap.isEmpty()) {
			result.add(maxHeap.poll().number);
		}
		
		return result;
	}
	
	
	private static List<Integer> findClosestElements(int[] nums, int k, Integer x) {
		
		int index = binarySearch(nums, x);
		int low = index - k, high = index + k;
		System.out.println("index - "+index+" low - "+low+" high - "+high);
		
		low = Math.max(low, 0);
		high = Math.min(high, nums.length - 1);
		System.out.println("After -  low - "+low+" high - "+high);
		
		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((n1, n2) -> n1.key - n2.key);
		
		for(int i=low; i<= high; i++) {
			minHeap.add(new Entry(Math.abs(nums[i] - x), i));
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			result.add(nums[minHeap.poll().value]);
		}
		
		Collections.sort(result);
		return result;
	}
	
	
	private static int binarySearch(int[] nums, int target) {
		
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(nums[mid] == target) {
				return mid;
			}
			
			if(nums[mid] < target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		if(low > 0) {
			return low - 1;
		}
		
		return low;		
	}

	public static void main(String[] args) {
		//System.out.println(find(new int[] {5, 6, 7, 8, 9}, 3, 7));
		//System.out.println(find(new int[] {2, 4, 5, 6, 9}, 3, 6));
		//System.out.println(find(new int[] {2, 4, 5, 6, 9}, 3, 10));
	 
		System.out.println(findClosestElements(new int[] {5, 6, 7, 8, 9}, 3, 7));
		System.out.println(findClosestElements(new int[] {2, 4, 5, 6, 9}, 3, 6));
		System.out.println(findClosestElements(new int[] {2, 4, 5, 6, 9}, 3, 10));
	
	}
	
}
