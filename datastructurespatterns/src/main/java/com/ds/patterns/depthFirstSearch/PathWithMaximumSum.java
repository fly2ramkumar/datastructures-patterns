package com.ds.patterns.depthFirstSearch;

public class PathWithMaximumSum {
	
	private static int maximumSum = 0;
	
	private static int findRecursiveSum(TreeNode root) {
		
		if(root == null)
			return 0;
		
		System.out.println("stack add findRecursiveSum [ root.value - "+root.value+" ]");
		
		int leftSum = findRecursiveSum(root.left);
		int rightSum = findRecursiveSum(root.right);
		
		int sum = leftSum + rightSum + root.value;
		
		maximumSum = Math.max(maximumSum, sum);
		
		System.out.println();
		System.out.println("stack remove findRecursiveSum [ root.value - "+root.value+" sum "+sum+" maximumSum - "+maximumSum+" ]");
		System.out.println();
		
		return Math.max(leftSum, rightSum) + root.value;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		findRecursiveSum(root);	
		System.out.println(maximumSum);
		
		maximumSum = 0;
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		
		root.right.right.left = new TreeNode(9);
		
		findRecursiveSum(root);	
		System.out.println(maximumSum);
	}

}
