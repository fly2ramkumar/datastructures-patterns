package com.ds.patterns.kWayMerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node {
	
	int elementIndex;
	int arrayIndex;
	
	Node(int elementIndex, int arrayIndex){
		this.elementIndex = elementIndex;
		this.arrayIndex = arrayIndex;
	}
}

public class KthSmallestNumberinSortedArrays {
	
	private static int find(List<Integer[]> lists, int k) {
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>((node1, node2) -> lists.get(node1.arrayIndex)[node1.elementIndex] - lists.get(node2.arrayIndex)[node2.elementIndex]);
		
		for(int i=0; i< lists.size(); i++) {
			if(lists.get(i) != null)
				minHeap.add(new Node(0, i));
		}
		
		int numberCount = 0, result = 0;
		
		while(!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			
			result = lists.get(node.arrayIndex)[node.elementIndex];
			
			if(++numberCount == k) 
				break;
			
			node.elementIndex++;
			
			if(lists.get(node.arrayIndex).length > node.elementIndex)
				minHeap.add(node);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Integer[] array1 = new Integer[] {2, 6, 8};
		Integer[] array2 = new Integer[] {3, 6, 7};
		Integer[] array3 = new Integer[] {1, 3, 4};
		
		System.out.println(KthSmallestNumberinSortedArrays.find(Arrays.asList(array1, array2, array3), 5));
		
		
	}
	
	

}
