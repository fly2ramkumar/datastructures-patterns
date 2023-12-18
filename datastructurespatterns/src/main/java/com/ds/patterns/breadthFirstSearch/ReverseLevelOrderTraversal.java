package com.ds.patterns.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

	private static List<List<Integer>> traverse(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> result = new LinkedList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			List<Integer> levelOrderList = new ArrayList<>();
			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {

				TreeNode node = queue.poll();
				levelOrderList.add(node.value);

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}

			}

			result.add(0, levelOrderList);
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

		List<List<Integer>> result = traverse(root);
		System.out.println(result.toString());
	}

}
