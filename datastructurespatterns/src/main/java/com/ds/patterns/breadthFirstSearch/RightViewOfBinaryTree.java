package com.ds.patterns.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

	private static List<Integer> findRightView(TreeNode root) {

		List<Integer> rightViewList = new ArrayList<>();

		if (root == null)
			return rightViewList;

		TreeNode previousRightViewNode = null;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {

				TreeNode currentNode = queue.poll();
				
				//grokking implementation
					if(i == levelSize -1) {
						rightViewList.add(currentNode.value);
					}

					
					//Custom implementation
				/*if (levelSize == 1) {
					rightViewList.add(currentNode.value);
					previousRightViewNode = currentNode;
				}

				if (currentNode == previousRightViewNode) {

					if (currentNode.right != null) {
						rightViewList.add(currentNode.right.value);
						previousRightViewNode = currentNode.right;
					} else {
						if (currentNode.left != null) {
							rightViewList.add(currentNode.left.value);
							previousRightViewNode = currentNode.left;
						}
					}

				}*/

				if (currentNode.left != null)
					queue.offer(currentNode.left);

				if (currentNode.right != null)
					queue.offer(currentNode.right);

			}

		}

		return rightViewList;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(findRightView(root).toString());

		root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		System.out.println(findRightView(root).toString());

	}

}
