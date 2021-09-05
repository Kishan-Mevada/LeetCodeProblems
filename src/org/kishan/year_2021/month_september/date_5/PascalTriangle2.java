package org.kishan.year_2021.month_september.date_5;

import java.util.ArrayList;
import java.util.List;

/**
 * 	-- Time : O(n^2)
 * 	-- Space : O(n^2)
 *
 */
public class PascalTriangle2 {

	static List<Integer> generate(int numRows){
		if(numRows == 0) return new ArrayList<>();

		List<Integer> prev = new ArrayList<>();
		prev.add(1);

		for(int r = 1; r <= numRows; r++) {
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			for(int i = 1; i < prev.size(); i++) {
				cur.add(prev.get(i-1) + prev.get(i));
			}

			cur.add(1);
			prev = cur;
		}

		return prev;
	}

	public static void main(String[] args) {
		int rows = 3;
		System.out.println(generate(rows));
	}
}
