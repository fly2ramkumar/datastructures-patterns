package com.ds.patterns.kWayMerge;

import java.util.PriorityQueue;

class MatrixNode {
	
	int rowIndex;
	int columnIndex;
	
	MatrixNode(int rowIndex, int columnIndex){
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
}

public class KthSmallestnumberinMatrix {

	private static int find(int[][] matrix, int k) {
		
		PriorityQueue<MatrixNode> minHeap = new PriorityQueue<>((node1, node2) -> matrix[node1.rowIndex][node1.columnIndex] - matrix[node2.rowIndex][node2.columnIndex]);
		System.out.println("matrix length - "+matrix.length);
		
		for(int i=0; i < matrix.length && i < k; i++) 
			minHeap.add(new MatrixNode(i, 0));
		
		int elementCount = 0, result = 0;
		
		while(!minHeap.isEmpty()) {
			
			MatrixNode node = minHeap.poll();
			result = matrix[node.rowIndex][node.columnIndex];
			
			if(++elementCount == k)
				break;
			
			node.columnIndex++;
			
			if(matrix[node.rowIndex].length > node.columnIndex)
				minHeap.add(new MatrixNode(node.rowIndex, node.columnIndex));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
		System.out.println(KthSmallestnumberinMatrix.find(matrix, 5));
	}
}
