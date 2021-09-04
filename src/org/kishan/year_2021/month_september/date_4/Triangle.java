package org.kishan.year_2021.month_september.date_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	 Given a triangle array , return the minimum path sum from top to bottom
 *
 * 	 input = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 	 output = 11
 *
 * 	 Triangle
 * 	 	2
 * 	   3 4
 * 	  6 5 7
 * 	 4 1 8 3
 * 	 => 2+3+5+1 -> 11
 *
 * 	 -- Time : O(2^r), where r is number of row
 * 	 		 - 2 is for 2 choices
 * 	 -- Space : O(r), recursive stack memory
 *
 *	--Note : recursive call may lead to time limit exceed
 */
public class Triangle {

	static int minimumTotal(List<List<Integer>> triangle){
		return minimumTotal(0,0,triangle);
	}
	private static int minimumTotal(int r, int c, List<List<Integer>> triangle) {
		if(r == triangle.size() - 1) return triangle.get(r).get(c);

		int sum1 = minimumTotal(r+1,c,triangle);
		int sum2 = minimumTotal(r+1,c+1,triangle);
		return Math.min(sum1,sum2) + triangle.get(r).get(c);
	}
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		System.out.println("Triangle min sum -> " + minimumTotal(triangle));
	}
}
