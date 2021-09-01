package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Bottom up)
 *
 * 	-- Time : O(mn)
 * 	-- Space : O(mn)
 */
public class UniquePathWithObstaclesBU {

	static int uniquePath(int[][] grid){
		int[][] paths = new int[grid.length][grid[0].length];
		for(int i = grid.length - 1; i >= 0; i--) {
			for(int j = grid[i].length-1; j >= 0; j--) {
				if(grid[i][j] == 1){
					continue;
				}
				if(i == grid.length - 1 && j == grid[i].length - 1){
					paths[i][j] = 1;
					continue;
				}
				if(i != grid.length -1){
					paths[i][j] += paths[i+1][j];
				}
				if(j != grid[i].length-1){
					paths[i][j] += paths[i][j+1];
				}
			}
		}
		return paths[0][0];
	}


	public static void main(String[] args) {
		 int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("Unique path -> " + uniquePath(grid));
	}
}
