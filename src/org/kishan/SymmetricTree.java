package org.kishan;

import org.kishan.utils.TreeNode;

/**
 * Given a binary tree,check whether it is a mirror of itself
 *
 * Solution Algorithm
 *
 *  - if root is null return true
 *  - variable p = root.left, q = root.right
 *  - compare recursively the subtree
 *  	 if both of node are null return true
 *  	 if one of the node is null return false
 *  	 if nodes value are not same return false
 *  	 recursively compare the subtree
 *  	 		p = p.left
 *  	 	 	q = q.right
 *  	 recursively compare the subtree
 *  	 		p = p.right
 *  	 		q = q.left
 *
 *
 */
public class SymmetricTree {

	static boolean isSymmetric(TreeNode root){
		if(root == null) return false;
		return isSymmetric(root.getLeft(),root.getRight());
	}
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if(left == null || right == null) return false;
		return left.getValue() == right.getValue()
				&& isSymmetric(left.getLeft(),right.getRight())
				&& isSymmetric(left.getRight(),right.getLeft());
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,
				new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4,null,null)),
				new TreeNode(2,new TreeNode(4,null,null),new TreeNode(3,null,null)));
		System.out.println("Is Symmetric Tree -> " + isSymmetric(root));

		root = new TreeNode(1,
				new TreeNode(2,new TreeNode(3,null,null),null),
				new TreeNode(2,new TreeNode(4,null,null),null));

		System.out.println("Is Symmetric Tree -> " + isSymmetric(root));
	}
}
