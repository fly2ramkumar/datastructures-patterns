package com.ds.patterns.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {
		
	private static void connect(TreeNode root) {
		
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		TreeNode previousNode = null;
		
		while(!queue.isEmpty()) {
			
			int levelsize = queue.size();

			for(int i=0; i< levelsize; i++) {
				
				TreeNode currentNode = queue.poll();
				
				if(previousNode != null) {
					previousNode.next = currentNode;
				}		
								
				previousNode = currentNode;
				
				if(currentNode.left != null)
					queue.offer(currentNode.left);
					
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);	
		
		connect(root);
		
		TreeNode current = root;
		System.out.println("Treversal using next pointer");
		while(current != null) {
			System.out.print(current.value+ " ");
			current = current.next;
		}
		
	}



}
