package org.kishan.year_2021.month_september.date_5;

/**
 * 		Given a non-empty array of integers nums,every element appears twice
 * 		except one,find that single one
 *
 * 		-- Time : O(n)
 * 		-- Space : O(1)
 */
public class SingleNumber {

	static int singleNumber(int[] nums){
		int result = 0;

		for(int num : nums){
			result ^= num;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println("Single Number -> " + singleNumber(nums));
	}
}
