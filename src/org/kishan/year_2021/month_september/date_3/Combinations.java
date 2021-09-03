package org.kishan.year_2021.month_september.date_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 	given 2 numbers n and k, return all possible combinations of k numbers out of 1..n
 *
 * 	you may return the answer in any order.
 *
 * 	Example n = 4,k = 2
 * 		[1,2]
 * 		[1,3]
 * 		[1,4]
 * 		[2,3]
 * 		[2,4]
 * 		[3,4]
 *
 */
public class Combinations {
	static List<List<Integer>> combinationK(int n,int k){
		List<List<Integer>> result = new ArrayList<>();
		combinationK(1,n,k,new ArrayList<Integer>(),result);
		return result;
	}
	private static void combinationK(int startIndex,int n, int k, ArrayList<Integer> comb, List<List<Integer>> result) {
		if(comb.size() == k){
			result.add(new ArrayList<>(comb));
			return;
		}
		for(int i = startIndex; i <= n; i++) {
			comb.add(i);
			combinationK(i+1,n,k,comb,result);
			comb.remove(comb.size() - 1);
		}
	}
	public static void main(String[] args) {
		int n = 4, k = 2;
		System.out.println("Combinations -> " + combinationK(n,k));
	}
}
