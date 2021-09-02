package org.kishan.year_2021.month_september.date_2;

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
 *	 -- Solution Algorithm (memoization)--
 *
 *	 - create following variables
 *	 	- r, current row
 *	 	- c, current column
 *	 	- grid, input grid
 *	 	- memo[][], memo to cache the already calculated result
 *
 *	 - base condition
 *	 	- if r and c are bottom right corner of grid
 *	 		- return grid[r][c]
 *	 	- if memo[r][c] != 0
 *	 		- return  memo[r][c]
 *	 - In each of the recursive call
 *	 	- create variable minSum to keep track of the minimum sum. initialize to max value
 *	 	- if r is not at the last row
 *	 		- recursively find the sum1 if we move down - r = r + 1
 *	 		- update minSum  if sum1 + grid[r][c] is smaller
 *  	- if c is not at the last column
 *   		- recursively find the sum2 if we move right - c = c + 1
 *   		- update minSum  if sum2 + grid[r][c] is smaller
 *	- return memo[r][c] = minSum
 *
 *   -- Time : O(m + n), where m,n are rows and columns
 *   -- Space : O(mn)
 */
public class MinimumPathSumWithCache {

	static int minPathSum(int[][] grid){
		return minPathSum(0,0,grid,new int[grid.length][grid[0].length]);
	}
	private static int minPathSum(int r, int c, int[][] grid,int[][] memo) {
		if (r == grid.length - 1 && c == grid[r].length - 1) return grid[r][c];
		if(memo[r][c] != 0) return memo[r][c];

		int minSum = Integer.MAX_VALUE;

		if(r != grid.length - 1){
			minSum = Math.min(minSum,minPathSum(r+1,c,grid,memo) + grid[r][c]);
		}

		if(c != grid.length - 1){
			minSum = Math.min(minSum,minPathSum(r,c+1,grid,memo) + grid[r][c]);
		}
		return memo[r][c] = minSum;
	}
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println("Min Path Sum -> " + minPathSum(grid));
	}
}
