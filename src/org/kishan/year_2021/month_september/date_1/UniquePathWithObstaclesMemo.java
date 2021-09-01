package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Recursive + Memoization)
 *
 *   -- Time : (m*n), where m and n are input, each recursive call we have 2 choices
 *   -- Space : O(m*n), recursive call + memoization
 */
public class UniquePathWithObstaclesMemo {

	static int uniquePath(int[][] grid){
		int[][] memo = new int[grid.length+1][grid[0].length+1];
		return uniquePath(grid,0,0,memo);
	}

	static int uniquePath(int[][] grid,int r,int c,int[][] memo){
		if(r >= grid.length || c >= grid[0].length || grid[r][c] == 1) return 0;
		if(r == grid.length -1 && c == grid[c].length-1) return 1;
		if(memo[r][c] != 0 ) return memo[r][c];

		return memo[r][c] = uniquePath(grid,r,c+1,memo) + uniquePath(grid,r+1,c,memo);
	}

	public static void main(String[] args) {
		 int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("Unique path -> " + uniquePath(grid));
	}
}
