package com.ds.patterns.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	
	private static int findMinimumDepth(TreeNode root) {
		
		if(root == null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		int minimumDepth = 0;
		
		while(!queue.isEmpty()) {
			
			minimumDepth++;
			int levelSize = queue.size();
			
			for(int i=0; i<levelSize; i++) {
				
				TreeNode currentNode = queue.poll();
				
				if(currentNode.left == null && currentNode.right == null)
					return minimumDepth;
				
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
			
		}
		
		return minimumDepth;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);		
		System.out.println(findMinimumDepth(root));		
		
		root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);		
		System.out.println(findMinimumDepth(root));
		
		root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);		
		root.right.left.right = new TreeNode(11);
		System.out.println(findMinimumDepth(root));
		
		
	}

}
