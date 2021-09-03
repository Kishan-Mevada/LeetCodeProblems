package org.kishan.year_2021.month_september.date_3;

import java.util.Arrays;

/**
 * 	Given an array nums, with n objects colored red,white or blue, sort them in place so that objects of the same color are adjacent
 * 	with color order red,while and blue
 *
 * 		0 represent red
 * 		1 represent white
 * 		2 represent blue
 *
 * 	Solution Approach
 *
 * 	 - create following variables
 * 	 	- i, initialize to 0
 * 	 	- j, initialize to 0
 * 	 	- k, last index, initialize to nums.length - 1
 *
 * 	 - while j <= k
 * 	 	- if nums[j] == 0
 * 	 	  - swap element at i and j and increment both
 * 	 	- else if nums[j] == 1
 * 	 		- do nothing just increment j
 * 	 	- else
 * 	 		- swap element at j and k
 * 	 		- decrement k
 *
 * 		-- Time : O(n), where n is number of element
 * 		-- Space : O(1)
 */
public class SortColor {

	static void sortColor(int[] nums){
		int i = 0,j=0,k = nums.length - 1;

		while(j <= k){
			if(nums[j] == 0){
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
				i++;
			}
			else if(nums[j] == 1){
				j++;
			}
			else{
				int temp = nums[j];
				nums[j] = nums[k];
				nums[k] = temp;
				k--;
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		System.out.println("Before sort -> " + Arrays.toString(nums));
		sortColor(nums);
		System.out.println("After sort -> " + Arrays.toString(nums));
	}
}
