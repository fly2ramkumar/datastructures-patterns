package com.ds.patterns.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ZigZagLevelOrderTraversal {

	private static List<List<Integer>> traverse(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 1;

		while (!queue.isEmpty()) {

			List<Integer> levelOrderList = new LinkedList<>();
			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {

				TreeNode node = queue.poll();
				if(count % 2 != 0) {
					levelOrderList.add(node.value);
				} else {
					levelOrderList.add(0, node.value);
				}
				

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

			}
		
			result.add(levelOrderList);
			count++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<List<Integer>> result = traverse(root);
		System.out.println(result.toString());
	}

}
