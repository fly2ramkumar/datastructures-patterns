package com.ds.patterns.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
	
	private static TreeNode findSuccessor(TreeNode root, TreeNode predecessor){
		
		if(root == null || predecessor == null)
			return new TreeNode(-1);
		
		boolean isPredecessorFound = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			
			int levelSize = queue.size();
			
			for(int i=0; i<levelSize; i++){
				TreeNode currentNode = queue.poll();
				
				if(isPredecessorFound)
					return currentNode;				
				
				if(currentNode.value == predecessor.value)
					isPredecessorFound = true;
				
				if(currentNode.left != null)
					queue.offer(currentNode.left);
				
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		
		return new TreeNode(-1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);		
		System.out.println(findSuccessor(root, root.right).value);		
		
		root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);		
		System.out.println(findSuccessor(root, root.left.left).value);
		
	}

}
