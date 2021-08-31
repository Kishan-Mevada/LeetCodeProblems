package org.kishan.year_2021.month_august.date_31;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CombinationSum {

	static List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(0,candidates,target,new ArrayList<>(),result);
		return result;
	}
	private static void combinationSum(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
		if(target == 0){
			result.add(new ArrayList<>(comb));
			return;
		}
		for(int j = i; j < candidates.length; j++) {
			if(candidates[j] > target) continue;
			comb.add(candidates[j]);
			combinationSum(j,candidates,target-candidates[j],comb,result);
			comb.remove(comb.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println("All sum combination for " + target + " -> " + combinationSum(candidates,target));
	}
}
