package com.ds.patterns.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelArveragesInBinaryTree {
	
	private static List<Double> findAverages(TreeNode root){
		
		List<Double> averagesList = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			
			int levelSize = queue.size();
			double sum = 0;
			
			for(int i=0; i < levelSize; i++){
				
				TreeNode currentNode = queue.poll();
				sum += currentNode.value;
				
				if(currentNode.left !=  null)
					queue.offer(currentNode.left);
				
				if(currentNode.right != null)
					queue.offer(currentNode.right);
				
			}
			averagesList.add(sum/levelSize);
		}
		
		return averagesList;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		List<Double> result = findAverages(root);
		System.out.println(result.toString());
	}

}
