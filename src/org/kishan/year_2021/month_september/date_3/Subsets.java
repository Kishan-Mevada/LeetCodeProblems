package org.kishan.year_2021.month_september.date_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 	given an integers array nums of unique elements, return the all possible subset
 *
 * 	The solution must not contain duplicate subsets
 *
 * 		input = [1,2,3]
 * 		output = [[],[1],[2],[1,2],[3],[3,1],[2,3],[1,2,3]]
 *
 * 	Solution Algorithm( Backtracking approach)
 *
 * 	- Create following variables
 * 		- i, current index, start from 0
 * 		- nums, input array
 * 		- subset, current subset list
 * 		- result, list of all subset
 *
 * 	- each recursive call
 * 		- add copy of subset to result
 * 		- Iterate through i -> nums.length, denoted as j
 * 			- add nums[j] to subset
 * 			- recursive call with j + 1
 * 			- remove last element from subset
 *
 */
public class Subsets {

	static List<List<Integer>> subset(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		subset(0,nums,new ArrayList<Integer>(),result);
		return result;
	}
	private static void  subset(int i, int[] nums, ArrayList<Integer> subset, List<List<Integer>> result) {
		result.add(new ArrayList<>(subset));
		for(int j = i; j < nums.length; j++) {
			subset.add(nums[j]);
			subset(j+1,nums,subset,result);
			subset.remove(subset.size() - 1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("Subsets -> " + subset(nums));
	}
}
