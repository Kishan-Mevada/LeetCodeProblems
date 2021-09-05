package org.kishan.year_2021.month_september.date_5;

import org.kishan.utils.TreeNode;

/**
 * 	-- Time : O(n)
 * 	-- Space : O(n)
 */
public class ConvertSortedArrayToBST {

	static TreeNode convert(int[] nums){
		return convert(nums,0,nums.length-1);
	}
	private static TreeNode convert(int[] nums, int left, int right) {
		if(left > right) return null;

		int mid = left + (right - left) / 2;
		return  new TreeNode(nums[mid],convert(nums,left,mid-1),convert(nums,mid+1,right));
	}
	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = convert(nums);
		System.out.println(root);
	}
}
