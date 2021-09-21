package org.kishan.year_2021.month_september.date_21;

/**
 *Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */
public class MaxConsecutiveOnes {

	static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0,curMax = 0;
		for(int num : nums) {
			if(num == 1) {
				curMax++;
				continue;
			}
			max = Math.max(max, curMax);
			curMax = 0;
		}
		max = Math.max(max,curMax);
		return max;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
