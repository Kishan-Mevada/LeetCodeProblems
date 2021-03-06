package org.kishan.utils;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public TreeNode(int value, TreeNode left, TreeNode right, TreeNode next) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode getNext() {
		return next;
	}
	public void setNext(TreeNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "TreeNode{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
	}
}
