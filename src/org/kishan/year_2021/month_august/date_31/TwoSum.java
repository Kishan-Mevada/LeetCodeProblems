package org.kishan.year_2021.month_august.date_31;

import java.util.*;

/**
 * Solution Algorithms
 *
 * - Create Map to keep track of element and index
 * - Iterate the array
 * 		- if map contains target - arr[i]
 * 			return {current index,map.get(target-arr[i]}
 * 		- put arr[i] and current index to map
 * 	- Return an Empty array;
 *
 * 	Time = O(n)
 * 	Space = O(n)
 *
 * 	*/
public class TwoSum {

	static int[] twoSum(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				return new int[] {i, map.get(target - nums[i])};
			}
			map.put(nums[i],i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 26;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}
}
