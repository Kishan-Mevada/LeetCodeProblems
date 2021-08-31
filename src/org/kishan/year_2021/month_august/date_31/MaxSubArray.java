package org.kishan.year_2021.month_august.date_31;

/**
 * Solution Algorithm
 *
 * - create 2 variables
 * 		- sum : to store current running sum , initialize with 0
 * 	    - maxSum : to store max sum of sub array, 	 initialize with Integer.MIN_VALUE
 * 	- Iterate the elements of array
 * 		- if sum is less than 0
 * 			- reset sum to 0
 * 		- Add  arr[currentIndex] to sum
 * 		- update maxSum if sum is greater than
 * 	- return maxSum
 *
 * 	Time : O(n)
 * 	Space : O(1)
 */

public class MaxSubArray {

	static int maxSum(int[] nums){
		int sum = 0, maxSum = Integer.MIN_VALUE;
		for(int n : nums){
			sum = Math.max(0,sum) + n;
			maxSum = Math.max(maxSum,sum);
		}
		return maxSum;
	}

	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max Sum Sub Array -> " + maxSum(nums));

		int[] nums1 = {-1};

		System.out.println("Max Sum Sub Array -> " + maxSum(nums1));
	}
}
