package org.kishan.year_2021.month_september.date_2;

import java.util.Arrays;

/**
 * 	Given m * n grid filled with no-negative numbers, find the path from top-left to bottom-right
 * 	which minimize the sum of all numbers along its path
 *
 * 	input
 * 	[[1,3,1],
 * 	 [1,5,1],
 *	 [4,2,1]]
 *
 *	 output = 7 ( 1 + 3 + 1 + 1
 *
 *	 -- Solution Algorithm (Bottom up approach)--
 *
 *	 - create following variables
 *	 	- grid, input grid
 *	 	- minSum array n to keep track of minimum sum
 *
 *  -  Iterate through the indices from  grid.length - 1 to 0 , denoted as r
 *    - Iterate through the indices from grid[r].length - 1 to 0
 *    		- if r == grid.length - 1 and c == grid[r].length - 1
 *    			- minSum[c] = grid[r][c]
 *    			- continue to next iteration
 *    		- store current sum (minSum[c]) to curr variable
 *    		- set minSum[c] to max value
 *    		- if r != grid.length - 1
 *    			- update minSum with minimum value of curr + grid[r][c]	// going down
 *    		- if c != grid.length[c] - 1
 *    			- update minSum with minimum value of minSum[c+1] + grid[r][c]	// going right
 *
 * 	- return minSum[0]
 *
 *   -- Time : O(mn), where m,n are rows and columns
 *   -- Space : O(n),
 */
public class MinimumPathSumBU1 {

	static int minPathSum(int[][] grid){
		int[] minSum = new int[grid[0].length];
		for(int r = grid.length - 1; r >= 0; r--) {
			for(int c = grid[r].length - 1; c >= 0; c--) {
				if( r == grid.length - 1 && c == grid[r].length - 1){
					minSum[c] = grid[r][c];
					continue;
				}
				int curr = minSum[c];
				minSum[c] = Integer.MAX_VALUE;
				if(r != grid.length - 1) minSum[c] = Math.min(minSum[c] ,curr + grid[r][c]);
				if(c != grid[r].length - 1) minSum[c] = Math.min(minSum[c] ,minSum[c+1] + grid[r][c]);
			}
		}
		return minSum[0];
	}

	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println("Min Path Sum -> " + minPathSum(grid));
	}
}
