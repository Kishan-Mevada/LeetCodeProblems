package org.kishan.year_2021.month_september.date_3;

/**
 *	Binary Search approach
 *
 * 	-- Time : O(log n)
 * 			worst : O (n)
 * 	-- Space : O(log n)
 *  		worst : O (n)
 *
 */
public class SearchInRotatedSortedArray {

	static boolean search(int[] nums,int target){
		return search(0,nums.length-1,nums,target);
	}
	private static boolean search(int left, int right, int[] nums, int target) {
		if(left > right) return false;

		int mid = left + (right - left) / 2;

		if(nums[mid] == target) return true;

		if(nums[left] <= target && target < nums[mid]){
			return search(left,mid-1,nums,target);
		}
		else if(nums[mid] < target && target < nums[right]){
			return search(mid+1,right,nums,target);
		}
		else{
			return search(left,mid-1,nums,target) || search(mid+1,right,nums,target);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1};
		int target = 2;
		System.out.println("Search (" + target + ") -> " + search(nums,target));
	}
}
