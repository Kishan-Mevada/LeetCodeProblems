package org.kishan.year_2021.month_september.date_1;

/**
 * 	Given an array of non-negative integers, you initially positioned at first index of array
 * 	Each element in the array represents your maximum jump length at that position
 *
 * 	Determine if you are able to reach the last index
 *
 * 	 input 				output
 * 	[2,3,1,1,4]			true
 * 	[3,2,1,0,4]			false
 *
 * 	Solution Approach
 *
 * 	- create latestIndex to keep track of latest index , nums.length-1
 * 	- Iterate array from end -> start index, denoted as i
 * 		- if nums[i] + i >= latestIndex
 * 			- update latestIndex to i
 * 		- else
 * 			- return false
 *
 * 	-- Time : O(n), where n is size of array
 * 	-- Space : O(1)
 *
 */
public class JumpGame {

	static boolean canJump(int[] nums){
		int latestIndex = nums.length - 1;
		for(int i = nums.length - 1; i >= 0; i--){
			if(nums[i] + i >= latestIndex){
				latestIndex = i;
			}
		}
		return latestIndex == 0;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println("Can Jum to last index -> {2,3,1,1,4} -> " + canJump(nums));
		nums = new int[]{3,2,1,0,4};
		System.out.println("Can Jum to last index -> {3,2,1,0,4} -> " + canJump(nums));
	}
}
