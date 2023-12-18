package com.ds.patterns.breadthFirstSearch;

public class TreeNode {
	
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	void printLevelOrder() {
		
		TreeNode nextLevelRoot = this;
		
		while(nextLevelRoot != null) {
			TreeNode current = nextLevelRoot;
			nextLevelRoot = null;
			
			while(current != null) {
				System.out.print(current.value+ " ");
				
				if(nextLevelRoot == null) {
					if(current.left != null)
						nextLevelRoot = current.left;
					else if(current.right != null)
						nextLevelRoot = current.right;
				}
				
				current = current.next;
			}
			
			System.out.println();
		}
		
	}

}
