package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 	Give the roots of binary tree, return the level order traversal of its nodes value
 *
 * 	-- Time : O(n) , where n is number of nodes
 * 	-- Space : O(2 * n) = O(n), for list and queue
 *
 */
public class BSTLevelOrder {

	static List<List<Integer>> levelOrder(TreeNode root){
		if(root == null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){

			List<Integer> values = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				values.add(node.getValue());

				if(node.getLeft() != null) queue.add(node.getLeft());
				if(node.getRight() != null) queue.add(node.getRight());
			}
			result.add(values);
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null)));
		System.out.println(levelOrder(root));
	}
}
