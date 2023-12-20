package com.ds.patterns.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;


public class AllPathsForSum {
	
	private static void findAllPaths(TreeNode root, int sum, List<Integer> intermediateList, List<List<Integer>> finalList) {
		
		if(root == null) {
			return;
		}
		
		System.out.println("Stack add findAllPaths [root.value "+root.value+ " intermediateList -- "+intermediateList.size()+" finalList - "+finalList.size()+" ]");
			
		intermediateList.add(root.value);
		
		if(root.left == null && root.right == null && root.value == sum) {
			finalList.add(new ArrayList<Integer>(intermediateList));
			
		}else {
			findAllPaths(root.left, sum - root.value, intermediateList, finalList);
			
			findAllPaths(root.right, sum - root.value, intermediateList, finalList);
		}
		
		System.out.println();
		System.out.println("Stack remove findAllPaths [root.value "+root.value+ " intermediateList -- "+intermediateList.size()+" finalList - "+finalList.size()+" ]");
		System.out.println();
		
		intermediateList.remove(intermediateList.size() - 1);		
	}
	
	private static List<List<Integer>> fetchAllTreePaths(TreeNode root, int sum) {
		
		List<List<Integer>> finalList = new ArrayList<>();
		List<Integer> intermediateList = new ArrayList<>();
		
		findAllPaths(root, sum, intermediateList, finalList);
		
		return finalList;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		List<List<Integer>> finalList = fetchAllTreePaths(root, 23);
		System.out.println(finalList.toString());
	}

}
