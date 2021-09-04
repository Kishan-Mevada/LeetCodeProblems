package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {

	static List<TreeNode> generate(int n){
		if(n == 0) return new ArrayList<>();
		return generateTree(1,n);
	}
	private static List<TreeNode> generateTree(int left, int right) {
		List<TreeNode> roots = new ArrayList<>();

		if(left > right){
			roots.add(null);
		}
		else{
			for(int i = left; i <= right; i++) {
				List<TreeNode> leftSubTrees = generateTree(left, i - 1);
				List<TreeNode> rightSubTrees = generateTree(i+1, right);
				for(TreeNode leftSubTree: leftSubTrees) {
					for(TreeNode rightSubTree: rightSubTrees) {
						roots.add(new TreeNode(i,leftSubTree,rightSubTree));
					}
				}
			}
		}
		return roots;
	}
	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> roots = generate(n);
		roots.forEach(System.out::println);
	}
}
