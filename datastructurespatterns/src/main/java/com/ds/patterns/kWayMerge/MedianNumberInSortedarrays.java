package com.ds.patterns.kWayMerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class MedianNumberInSortedarrays {
	
	private static double findMedianNumber(List<Integer[]> lists) {
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>((node1, node2) -> lists.get(node1.arrayIndex)[node1.elementIndex] - lists.get(node2.arrayIndex)[node2.elementIndex]);
		
		int totalListSize = 0;
		for(int i=0; i< lists.size(); i++) {
			if(lists.get(i) != null) {
				minHeap.add(new Node(0, i));
				totalListSize += lists.get(i).length;
			}
		}
		
		int median = (totalListSize / 2) + 1;
		
		int elementCount = 0, element = 0, previousElement = 0;
		while(!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			element = lists.get(node.arrayIndex)[node.elementIndex];
			
			if(++elementCount == median) {
				
				if(totalListSize %2 == 0) {
					System.out.println("element - "+element+" previousElement - "+previousElement);
					return (new Double(element) + new Double(previousElement)) / 2;
					
				} else {
					return element;
				}
			}
			
			previousElement = element;
			
			node.elementIndex++;
			if(lists.get(node.arrayIndex).length > node.elementIndex)
				minHeap.add(node);
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		Integer[] array1 = new Integer[] {2, 6};
		Integer[] array2 = new Integer[] {3, 6, 7};
		Integer[] array3 = new Integer[] {1, 3, 4};
		
		System.out.println(MedianNumberInSortedarrays.findMedianNumber(Arrays.asList(array1, array2, array3)));
		
		
	}

}
