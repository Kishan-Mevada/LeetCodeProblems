package org.kishan.year_2021.month_september.date_1;

/**
 *  A robot is located at the top-left corner of a m * n grid.
 *
 *  the robot can move either down or right at any point in time, the robot is trying to reach
 *  the bottom-right corner of grid
 *
 *  how many possible unique path are there.?
 *
 *  Solution Approach (Bottom UP)
 *
 *	- create 2d matrix of m * n, denoted as ways[][]
 *	- Iterate from 1 -> m, denoted as i
 *	  -	Iterate from 1 -> n, denoted as j
 *			- if i and j is equals  to 1
 *				- ways[i][j] = 1
 *				- continue
 *			- set ways[i][j] = ways[i][j-1] + ways[i-1][j]
 *	- return ways[m][n]
 *
 * 	-- Time : O(mn)
 * 	-- Space : O(mn)
 */
public class UniquePathBottomUp {

	static int uniquePath(int m,int n){
		int[][] ways = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if( i == 1 && j == 1){
					ways[i][j] = 1;
					continue;
				}
				ways[i][j] = ways[i][j-1] + ways[i-1][j];
			}
		}
		return ways[m][n];
	}
	public static void main(String[] args) {
		int row = 3;
		int col = 7;
		System.out.println("Unique path -> " + uniquePath(row,col));
	}
}
