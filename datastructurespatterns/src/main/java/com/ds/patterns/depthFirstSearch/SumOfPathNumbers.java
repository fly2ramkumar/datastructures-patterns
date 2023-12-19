package com.ds.patterns.depthFirstSearch;


public class SumOfPathNumbers {
	
	private static int findSumOfPathNumbers(TreeNode root){		
		int final1Count = findRecursivePath(root, 0);
		return final1Count;
	}
	
	private static int findRecursivePath(TreeNode root, int intermediatecount/* , int finalCount */){
		
		if(root == null)
			return 0;
				
		intermediatecount *= 10;
		intermediatecount += root.value;
		
		if(root.left == null && root.right == null) {
			//finalCount += intermediatecount;
			//return finalCount;
			return intermediatecount;
		}
		
		return findRecursivePath(root.left, intermediatecount/*, finalCount*/) +
		findRecursivePath(root.right, intermediatecount/*, finalCount*/);
		
		//intermediatecount /= 10;
		//return finalCount;
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
