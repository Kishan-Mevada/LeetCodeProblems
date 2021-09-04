package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Given the root of the binary tree and integer targetSum, return all root to leaf path where each path's equals to targetSum
 *
 * 	 -- Time : O(n)
 * 	 -- Space : O(2 * h) , where h is height of the tree
 */
public class BSTPathSum {

	static List<List<Integer>> pathSum(TreeNode root,int targetSum){
		List<List<Integer>> result = new ArrayList<>();
		pathSum(root,new ArrayList<Integer>(),0,targetSum,result);
		return result;
	}
	private static void pathSum(TreeNode node, ArrayList<Integer> path, int sum, int targetSum, List<List<Integer>> result) {
		if(node == null) return;

		sum += node.getValue();
		path.add(node.getValue());

		if(node.getLeft() == null && node.getRight() == null && sum == targetSum){
			result.add(new ArrayList<>(path));
		}

		pathSum(node.getLeft(),path,sum,targetSum,result);
		pathSum(node.getRight(),path,sum,targetSum,result);
		path.remove(path.size() - 1);
	}
	public static void main(String[] args) {
		TreeNode leftSubTree = new TreeNode(4,new TreeNode(11,new TreeNode(7,null,null),new TreeNode(2,null,null)),null);
		TreeNode rightSubTree = new TreeNode(8,new TreeNode(13,null,null),new TreeNode(4,new TreeNode(5,null,null),new TreeNode(1,null,null)));

		TreeNode root = new TreeNode(5,leftSubTree,rightSubTree);
		int targetSum = 22;
		System.out.println("Path sum for target " + targetSum);
		System.out.println(pathSum(root,targetSum));
	}
}
