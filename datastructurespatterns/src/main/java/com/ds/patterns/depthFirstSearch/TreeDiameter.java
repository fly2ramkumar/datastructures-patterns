package com.ds.patterns.depthFirstSearch;

public class TreeDiameter {
	
	private static int treeDiameter = 0;
	
	private static int findDiameter(TreeNode root) {
		calculateHeight(root);
		return treeDiameter;
	}
	
	private static int calculateHeight(TreeNode currentNode) {
		
		if(currentNode == null)
			return 0;
		
		System.out.println("Stack add - calculateHeight [ "+currentNode.value+ " ]");
		
		int leftTreeHeight = calculateHeight(currentNode.left);
		int rightTreeHeight = calculateHeight(currentNode.right);
		
		System.out.println();
		System.out.println("Stack remove - calculateHeight [ "+currentNode.value+ " ]");
				
		int diameter = leftTreeHeight + rightTreeHeight + 1;
		
		System.out.println("leftTreeHeight- "+leftTreeHeight+" rightTreeHeight - "+rightTreeHeight+" diameter - "+diameter);
		System.out.println();
		
		treeDiameter = Math.max(treeDiameter, diameter);
		
		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		System.out.println(findDiameter(root));
		
	}
	

}
