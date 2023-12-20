package com.ds.patterns.depthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathWithGivenSequence {
	
	//Custom implementation
	private static boolean findPath(TreeNode root, List<Integer> sequenceList) {
		
		if(sequenceList == null || sequenceList.isEmpty())
			return false;
		
		int sequenceValue = 0;
		
		for(int i=0; i< sequenceList.size(); i++) {
			sequenceValue *= 10;
			sequenceValue += sequenceList.get(i);
		}
		
		return findRecursivePath(root, sequenceValue, 0);
		
	}

	//Custom implementation
	private static boolean findRecursivePath(TreeNode root, int sequenceValue, int sum) {
		
		if(root == null)
			return false;
		
		sum = (sum *10) + root.value;
		
		if(root.left == null && root.right == null && sum == sequenceValue)
			return true;
		
		return findRecursivePath(root.left, sequenceValue, sum) || findRecursivePath(root.right, sequenceValue, sum);
		
	}
	
	//Grokking Implementation
	private static boolean findPath(TreeNode root, int[] sequence) {

		if(root == null)
			return sequence.length == 0;
		
		return findRecursivePath(root, sequence, 0);
	}
	
	//Grokking Implementation
	private static boolean findRecursivePath(TreeNode root, int[] sequence, int sequenceindex) {
		
		if(root == null)
			return false;
		
		System.out.println("stack add findRecursivePath [ root.value - "+root.value+" sequenceindex - "+sequenceindex+" sequence[sequenceindex]"+ sequence[sequenceindex]+" ]");
		
		if(sequenceindex >= sequence.length || root.value != sequence[sequenceindex]) {
			return false;
		}			
		
		if(root.left == null && root.right == null && sequenceindex == sequence.length -1)
			return true;
		
		boolean hasPath = findRecursivePath(root.left, sequence, sequenceindex+1) || findRecursivePath(root.right, sequence, sequenceindex+1);
		
		System.out.println();
		System.out.println("stack remove findRecursivePath [ root.value - "+root.value+" sequenceindex - "+sequenceindex+" hasPath - "+hasPath+" ]");
		System.out.println();
		
		return hasPath;
	}
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(9);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(9);
		
	   //System.out.println(findPath(root, Arrays.asList(1, 7)));
	   
		System.out.println(findPath(root, new int[] {1, 9, 7}));
	}
}
