package org.kishan.year_2021.month_september.date_5;

import java.util.ArrayList;
import java.util.List;

/**
 * 	-- Time : O(n^2)
 * 	-- Space : O(n^2)
 *
 */
public class PascalTriangle {

	static List<List<Integer>> generate(int numRows){
		if(numRows == 0) return new ArrayList<>();

		List<List<Integer>> result = new ArrayList<>();
		generate(numRows,result);
		return result;
	}
	private static List<Integer> generate(int r, List<List<Integer>> result) {
		List<Integer> cur = new ArrayList<>();
		cur.add(1);

		if(r == 1){
			result.add(cur);
			return cur;
		}

		List<Integer> prev = generate(r-1,result);
		for(int i = 1; i < prev.size(); i++) {
			cur.add(prev.get(i-1) + prev.get(i));
		}

		cur.add(1);
		result.add(cur);
		return cur;
	}
	public static void main(String[] args) {
		int rows = 5;
		System.out.println(generate(rows));
	}
}
