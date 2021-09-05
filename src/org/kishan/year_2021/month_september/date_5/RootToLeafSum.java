package org.kishan.year_2021.month_september.date_5;

import org.kishan.utils.TreeNode;

/**
 * 	 BST -> 123
 * 	 Sum -> 25  (12 + 13)
 *
 * 	 -- Time : O(n), where n is number of nodes
 * 	 -- Space : O(h), where h is height of tree
 */
public class RootToLeafSum {

	static int sumNumbers(TreeNode root){
		return sumNumbers(root,0);
	}
	private static int sumNumbers(TreeNode node, int num) {
		if(node == null) return 0;

		num = num * 10 + node.getValue();

		if(node.getLeft() == null && node.getRight() == null){
			return num;
		}

		return sumNumbers(node.getLeft(),num) + sumNumbers(node.getRight(),num);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
		System.out.println("Max path sum -> " + sumNumbers(root));
	}
}
