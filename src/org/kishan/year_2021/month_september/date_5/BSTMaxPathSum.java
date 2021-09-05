package org.kishan.year_2021.month_september.date_5;

import org.kishan.utils.TreeNode;

/**
 * 	-- Time : O(n), where n is number of nodes
 * 	-- Space : O(h), where h is height of tree
 */
public class BSTMaxPathSum {

	private static class MaxSum{
		public int value = Integer.MIN_VALUE;
	}

	static int maxPathSum(TreeNode root){
		MaxSum maxSum = new MaxSum();
		maxPathSum(root,maxSum);
		return maxSum.value;
	}
	private static int maxPathSum(TreeNode node, MaxSum maxSum) {
		if(node == null) return 0;

		int left = Math.max(maxPathSum(node.getLeft(),maxSum),0);
		int right = Math.max(maxPathSum(node.getRight(),maxSum),0);
		maxSum.value = node.getValue() + left + right;

		return Math.max(node.getValue() + left,node.getValue() + right);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
		System.out.println("Max path sum -> " + maxPathSum(root));
	}
}
