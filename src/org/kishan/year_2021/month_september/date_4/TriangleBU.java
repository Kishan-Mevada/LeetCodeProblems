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
 * 	 -- Time : O(n^2),
 * 	 -- Space : O(n^2), matrix
 *
 *	--Note : recursive call may lead to time limit exceed
 */
public class TriangleBU {

	static int minimumTotal(List<List<Integer>> triangle){
		int[][] minSum = new int[triangle.size()][triangle.size()];
		for(int r = triangle.size() - 1; r >= 0; r--) {
			for(int c = r; c >= 0; c--) {
				if(r == triangle.size() - 1){
					minSum[r][c] = triangle.get(r).get(c);
					continue;
				}
				minSum[r][c] = Math.min(minSum[r+1][c],minSum[r+1][c+1]) + triangle.get(r).get(c);
			}
		}
		return minSum[0][0];
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
