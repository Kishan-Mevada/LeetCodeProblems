package org.kishan.year_2021.month_september.date_1;

/**
 * 	Given an unsorted array nums,find the smallest missing positive integer
 *
 * 	input				output
 *  [1,2,0]				3
 *  [3,4,-1,1] 			2
 *  [7,8,9]				1
 *
 *  Solution Algorithm
 *
 *  - Iterate the array nums from starting index (0), denoted as i
 *  	- create variable num and set nums[i]
 *  	- set num[i] to 0
 *  	- find the correct position of num in array, if not found then it out of box
 *  		- while(true)
 *  			- if num is less than 1 or num is greater than nums.length or num == nums[nums-1]
 *  				- break
 *  			- swap the nums and nums[num-1]
 *  - Iterate the array nums from starting index (0), denoted as i
 *  	- if nums[i] == 0
 *  		- return i + 1
 *  - return nums.length + 1
 *
 *  Time : O(n) + O(n) = O(n), where n is length of array
 *  		- 2 times O(n) because we are iterating twice
 *  Space : O(1)
 */
public class FirstMissingPositive {

	static int firstMissingPositive(int[] nums){
		for(int i =0; i< nums.length; i++){
			int num = nums[i];
			nums[i] = 0;
			while(num >= 1 && num <= nums.length && num != nums[num - 1]) {
				int temp = nums[num - 1];
				nums[num - 1] = num;
				num = temp;
			}
		}

		for(int i = 0; i < nums.length; i++){
			if (nums[i] == 0){
				return i + 1;
			}
		}
		return nums.length + 1;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("First Missing Positive -> " + firstMissingPositive(nums));
	}
}
