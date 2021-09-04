package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

/**
 *	Given root of the binary tree, determine if it valid binary tree
 *
 * 	-- A valid BST is
 * 		- The left subtree of a node contains only nodes with keys less than the nodes key
 * 		- The right subtree of a node contains only nodes with keys greater than the nodes key
 * 		- both left and right subtree must also be binary search tree
 *
 * 	-- Time : O(n)
 * 	-- Space : O(h), where h is height of tree of recursive call
 */
public class ValidateBST {

	static boolean isValidTree(TreeNode root){
		if(root == null){
			return true;
		}

		if(root.getLeft() != null && root.getLeft().getValue() > root.getValue()){
			return false;
		}
		if(root.getRight() != null && root.getRight().getValue() < root.getValue()){
			return false;
		}
		return isValidTree(root.getLeft()) && isValidTree(root.getRight());
	}

	static boolean isValidTree1(TreeNode root){
		return isValidTree1(root,null,null);
	}

	static boolean isValidTree1(TreeNode node,Integer min,Integer max){
		if(node == null) return true;

		if(min != null && node.getValue() <= min) return false;
		if(max != null && node.getValue() >= max) return false;

		return isValidTree1(node.getLeft(),min,node.getValue()) && isValidTree1(node.getRight(),node.getValue(),max);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2,new TreeNode(1,null,null),new TreeNode(3,null,null));
		System.out.println("Is valid BST -> " + isValidTree1(root));
	}
}
