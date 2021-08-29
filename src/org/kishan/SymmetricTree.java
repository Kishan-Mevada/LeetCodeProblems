package org.kishan;

import org.kishan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree,check whether it is a mirror of itself
 *
 * Solution Algorithm
 *
 * =====Recursive Approach=====
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
 *	Time : O(n)
 *  Space : O(h) -> recursive call stack where h is height of tree
 *
 *
 * ====Iterative Approach====
 *
 * - if root is null
 * 		- return true
 * - create variables p and q
 * - create queue to track of the nodes
 * - add root twice in queue
 * - while queue is not empty
 * 		- poll 2 nodes from queue to p and q respectively
 * 	    - if both nodes are null
 * 	    	- continue with next iteration
 * 	    - if one of the node is null
 * 	    	- return false
 * 	    - if both nodes value are not same
 * 	    	- return true
 * 	    - add p.left and q.right into queue
 * 	    - add p.right and q.left into queue
 * - return true
 *
 * Time : O(n)
 * Space : O(n)
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

	static boolean isSymmetric_Iterative(TreeNode root){
		if( root == null) return true;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode p,q;
		queue.add(root);
		queue.add(root);

		while(!queue.isEmpty()){
			p = queue.poll();
			q = queue.poll();
			if(p == null && q == null){
				continue;
			}
			if(p == null || q == null){
				return false;
			}
			if(p.getValue() != q.getValue()){
				return false;
			}
			queue.add(p.getLeft());
			queue.add(q.getRight());
			queue.add(p.getRight());
			queue.add(q.getLeft());
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,
				new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4,null,null)),
				new TreeNode(2,new TreeNode(4,null,null),new TreeNode(3,null,null)));
		System.out.println("Is Symmetric Tree -> " + isSymmetric_Iterative(root));

		root = new TreeNode(1,
				new TreeNode(2,new TreeNode(3,null,null),null),
				new TreeNode(2,new TreeNode(4,null,null),null));

		System.out.println("Is Symmetric Tree -> " + isSymmetric(root));
	}
}
