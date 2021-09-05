package org.kishan.year_2021.month_september.date_5;

import java.util.HashMap;
import java.util.Map;

/**
 * 	-- Time : O(n)
 *	-- Space : O(1)
 */
public class SingleNumber2 {

	static int singleNumber(int[] nums){
		Map<Integer,Integer> map = new HashMap<>();

		for(int num : nums){
			map.put(num,map.getOrDefault(num,0)+1);
		}

		for(int x : map.keySet()){
			if(map.get(x) == 1) return x;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {2,2,1,2};
		System.out.println("Single Number -> " + singleNumber(nums));
	}
}
