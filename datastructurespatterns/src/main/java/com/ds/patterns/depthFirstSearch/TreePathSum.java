package com.ds.patterns.depthFirstSearch;


public class TreePathSum {
	
	private static boolean hasPath(TreeNode root, int sum) {
		
		if(root == null)
			return false;
		
		System.out.println(" stack add hasPath [ root value -- "+root.value+" sum - "+sum+" ]");
		
		if(root.value == sum && root.left == null && root.right == null)
			return true;
		
		boolean isSumZero = hasPath(root.left, sum - root.value) || hasPath(root.right, sum - root.value);
		
		System.out.println();
		System.out.println(" stack remove hasPath [ root value - "+root.value+" sum - "+sum+" isSumZero - "+isSumZero+" ]");
		System.out.println();
		
		return isSumZero;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		System.out.println("Is Tree has Path - "+hasPath(root, 16));
	}

}
