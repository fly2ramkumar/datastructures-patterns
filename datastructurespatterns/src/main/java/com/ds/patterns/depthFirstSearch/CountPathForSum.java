package com.ds.patterns.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountPathForSum {
	
	private static int countPath(TreeNode root, int sum) {
		List<Integer> nodeList = new ArrayList<>();
		return countRecursivePath(root, sum, nodeList);
	}
	
	private static int countRecursivePath(TreeNode root, int sum, List<Integer> nodeList) {
		
		if(root == null)
			return 0;
		
		System.out.println("stack add countRecursivePath [ root.value - "+root.value+" sum -"+sum+" nodeList size - "+nodeList.size());
		
		nodeList.add(root.value);
		
		int pathSum = 0;
		int pathCount = 0;
		
		ListIterator<Integer> nodeListIterator = nodeList.listIterator(nodeList.size());
		while(nodeListIterator.hasPrevious()) {		
			pathSum += nodeListIterator.previous();
			
			if(pathSum == sum) {
				pathCount ++;
			}
		}
		
		pathCount += countRecursivePath(root.left, sum, nodeList);
		pathCount += countRecursivePath(root.right, sum, nodeList);
	
		nodeList.remove(nodeList.size() -1);
		
		System.out.println();
		System.out.println("stack remove countRecursivePath [ root.value - "+root.value+" sum -"+sum+" nodeList size - "+nodeList.size());
		System.out.println();
		return pathCount;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		System.out.println(countPath(root, 11));
	}
}
