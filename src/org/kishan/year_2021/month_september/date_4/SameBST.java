package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

/**
 * 	--Time : O(n), where n is number of nodes
 * 	--Space : O(h), where h is height of tree and recursive stack
 */
public class SameBST {

	static boolean isSameBST(TreeNode root1,TreeNode root2){
		if(root1 == null && root2 == null) return true;
		if((root1 == null || root2 == null) || root1.getValue() != root2.getValue()) return false;
		return isSameBST(root1.getLeft(),root2.getLeft()) && isSameBST(root1.getRight(),root2.getRight());
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1,new TreeNode(2,null,null),null);
		TreeNode root2 = new TreeNode(1,new TreeNode(2,null,null),null);
		System.out.println("Is same BST -> " + isSameBST(root1,root2));

		TreeNode root3 = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(1,null,null));
		TreeNode root4 = new TreeNode(1,new TreeNode(1,null,null),new TreeNode(2,null,null));
		System.out.println("Is same BST -> " + isSameBST(root3,root4));
	}
}
