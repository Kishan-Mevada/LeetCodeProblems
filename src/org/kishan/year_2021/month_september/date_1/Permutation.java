package org.kishan.year_2021.month_september.date_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Given an array nums of distinct integers,return all the possible permutations. you can return answer in any order;
 *
 * 	input = [1,2,3]
 * 	output = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 *
 * 	 Solution Algorithm (Backtracking approach)
 *
 * 	 - create following variables
 * 	 	- result, list of all permutation
 * 	 	- permutation list, current permutation
 * 	 	- used array , to keep track of used element
 * 	    - nums array , input array
 *
 * 	- base condition
 * 		- if permutation.size == nums.length
 * 			- add permutation to result
 * 			-return
 *
 * 	-  In each recursive call
 * 		- Iterate the indices of nums, denoted as i
 * 			- if used[i] is true
 * 			 	- continue
 * 			- set used[i] = true
 * 			- add nums[i] to permutation list
 * 			- recursively find rest of permutation
 * 			- set used[i] = false
 * 			- remove last element from permutation
 *
 * 	- return result
 *
 *
 */
public class Permutation {

	static List<List<Integer>> permutations(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		permute(nums,new boolean[nums.length],new ArrayList<Integer>(),result);
		return result;
	}
	private static void permute(int[] nums, boolean[] used, ArrayList<Integer> permutation, List<List<Integer>> result) {
		if(permutation.size() == nums.length){
			result.add(new ArrayList<>(permutation));
			return;
		}

		for(int i = 0; i< nums.length; i++){
			if (used[i]) continue;

			used[i] = true;
			permutation.add(nums[i]);
			permute(nums,used,permutation,result);
			used[i] = false;
			permutation.remove(permutation.size()-1);
		}
	}


	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("Permutation -> " + permutations(nums));
	}
}
