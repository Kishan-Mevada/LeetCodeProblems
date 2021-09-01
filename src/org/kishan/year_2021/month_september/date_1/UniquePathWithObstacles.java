package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Recursive)
 *
 *   -- Time : (2^(m+n)), where m and n are input, each recursive call we have 2 choices
 *   -- Space : O(m+n), recursive call
 *
 *   Note : this approach may lead to time limit exceeded
 */
public class UniquePathWithObstacles {

	static int uniquePath(int[][] grid){
		return uniquePath(grid,0,0);
	}

	static int uniquePath(int[][] grid,int r,int c){
		if(r >= grid.length || c >= grid[0].length || grid[r][c] == 1) return 0;
		if(r == grid.length -1 && c == grid[c].length-1) return 1;

		return uniquePath(grid,r,c+1) + uniquePath(grid,r+1,c);
	}

	public static void main(String[] args) {
		 int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("Unique path -> " + uniquePath(grid));
	}
}
