package org.kishan.year_2021.month_september.date_5;

import org.kishan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 	-- Time : O(n)
 * 	-- Space : O(n)
 */
public class SymmetricTreeIterative {

	static boolean isSymmetric(TreeNode root){
		if(root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode p = queue.poll(), q = queue.poll();

			if(p == null && q == null) continue;
			if(p == null || q == null || p.getValue() != q.getValue()) return false;

			queue.add(p.getLeft());queue.add(q.getRight());
			queue.add(q.getRight());queue.add(p.getLeft());
		}
		return true;
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
