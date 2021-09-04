package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeInOrderTraverse {
	/**
	 *  Recursive approach
	 *
	 *  -- Time : O(n)
	 *  -- Space : O(h) + O(n) = O(n)
	 *  		- where h is the height of the tree
	 *  		- where n is the number of nodes
	 *  		- O(h) recursive stack
	 *
	 */
	static void inOrderTraverse(TreeNode root){
		if(root != null){
			inOrderTraverse(root.getLeft());
			System.out.print(root.getValue() + " ");
			inOrderTraverse(root.getRight());
		}
	}

	/**
	 *  Iterative approach
	 *
	 *  -- Time : O(n)
	 *  -- Space : (h) + O(n) = O(n)
	 *  		- where h is the height of the tree
	 *  		- where n is the number of nodes
	 *
	 */
	static List<Integer> inOrderIterative(TreeNode root){
		if(root == null) return new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		pushAllNodeOfLeft(root,stack);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.getValue());
			pushAllNodeOfLeft(node.getRight(),stack);
		}
		return result;
	}
	private static void pushAllNodeOfLeft(TreeNode root, Stack<TreeNode> stack) {
		for(TreeNode node = root; node != null; node = node.getLeft()){
			stack.push(node);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
		List<Integer> integers = inOrderIterative(root);
		System.out.println("Iterative Traverse");
		System.out.println(integers);
		System.out.println("Recursive Traverse");
		inOrderTraverse(root);
	}
}
