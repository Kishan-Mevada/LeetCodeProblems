package org.kishan.year_2021.month_september.date_4;

import org.kishan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 	-- Time : O(n)
 * 	-- Space : O(1)
 */
public class PopulateNextRightInBST {
	static TreeNode connect(TreeNode root) {
		TreeNode node = root;
	 	while(node != null){
			 TreeNode left = null, prev = null, x = node;

			 while(x != null){
				 if(x.getLeft() != null){
					 if(left == null) left = x.getLeft();

					 if(prev != null){
						 prev.setNext(x.getLeft());
					 }
					 prev = x.getLeft();
				 }

				 if(x.getRight() != null){
					 if(left == null) left = x.getRight();

					 if(prev != null){
						 prev.setNext(x.getRight());
					 }
					 prev = x.getRight();
				 }

				 x = x.getNext();
			 }
			 node = left;
		}
		return root;
	}

	static void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == null){
				System.out.print(" # ");
			}
			else{
				System.out.print(" " + node.getValue() + " ");
				queue.add(root.getLeft());
				queue.add(root.getRight());
			}
		}
	}

}
