package com.ds.patterns.depthFirstSearch;


public class SumOfPathNumbers {
	
	private static int findSumOfPathNumbers(TreeNode root){		
		int final1Count = findRecursivePath(root, 0);
		return final1Count;
	}
	
	private static int findRecursivePath(TreeNode root, int intermediatecount){
		
		if(root == null)
			return 0;
				
		intermediatecount *= 10;
		intermediatecount += root.value;
		
		System.out.println("stack add findRecursivePath [ root.value - "+root.value+" intermediatecount - "+intermediatecount+" ]");
		
		if(root.left == null && root.right == null) {
			return intermediatecount;
		}
		
		int finalCount = findRecursivePath(root.left, intermediatecount) +
		findRecursivePath(root.right, intermediatecount);
		
		System.out.println();
		System.out.println("stack remove findRecursivePath [ root.value - "+root.value+" intermediatecount - "+intermediatecount+" finalCount - "+finalCount+" ]");
		System.out.println();
		
		return finalCount;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(9);
		
		System.out.println(findSumOfPathNumbers(root));
	}

}
